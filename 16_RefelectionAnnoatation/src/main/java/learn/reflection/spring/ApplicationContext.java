package learn.reflection.spring;

import learn.reflection.spring.annotation.Autowired;
import learn.reflection.spring.annotation.Component;
import learn.reflection.spring.annotation.CompotentScan;
import learn.reflection.spring.annotation.Configuration;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class ApplicationContext {
    private static HashMap<Class<?>, Object> map = new HashMap<>();

    public ApplicationContext(Class<AppConfig> appConfigClass) {
        Spring.initializeSpringContext(appConfigClass);
    }

    public <T> T getBean(Class<T> clss) {
          T object =  (T)map.get(clss);
        Field[] declaredFiled = clss.getDeclaredFields();
        injectBean(object , declaredFiled);
          return object;
    }

    private <T> void injectBean(T object, Field[] declaredFiled) {
        for (Field field : declaredFiled) {
            if (field.isAnnotationPresent(Autowired.class)) {
                field.setAccessible(true);
                Class<?> type = field.getType();
                Object innerObject = map.get(type);
                try {
                    field.set(object, innerObject);
                    Field[] typefileds = type.getDeclaredFields();
                    injectBean(innerObject, typefileds);

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Spring {
        private static  void initializeSpringContext(Class<?> clss){
            if(!clss.isAnnotationPresent(Configuration.class)){
                  throw new RuntimeException("The file is not a configuration ");
            }else
            {
                CompotentScan annotation = clss.getAnnotation(CompotentScan.class);
                String value = annotation.value();
                String packageStruct = "bin/"+ value.replace(".", "/");
                File[] files = findClasses(new File(packageStruct));

                for(File file : files){
                    String name = value +"." + file.getName().replace(".class","");
                    try {
                        Class<?> loadingClss = Class.forName(name);
                        if(loadingClss.isAnnotationPresent(Component.class)){
                            Constructor<?> constructor = loadingClss.getDeclaredConstructor();
                            Object newInstance = constructor.newInstance();
                            map.put(loadingClss, newInstance);
                        }
                    } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        private static File[] findClasses(File file) {
                if(!file.exists()){
                    throw new RuntimeException("Package " + file + " does not exist");
                }else{
                    File[] listFiles = file.listFiles(e -> e.getName().endsWith(".class"));
                    return listFiles;
                }
        }

    }
}
