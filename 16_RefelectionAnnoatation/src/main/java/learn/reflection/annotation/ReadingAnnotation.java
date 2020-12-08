package learn.reflection.annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReadingAnnotation {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clss = Class.forName("learn.reflection.annotation.Utility");
        Constructor<?> constructor = clss.getConstructor();
       Utility u = (Utility)constructor.newInstance();
        Method[] methods = clss.getDeclaredMethods();

        for (Method method:methods){
            if(method.isAnnotationPresent(MostUsed.class)){
                MostUsed annotation = method.getAnnotation(MostUsed.class);
                String dv = annotation.value();
                method.invoke(u, dv);
                //method.invoke(u, "Scala");
            }
        }


    }
}
