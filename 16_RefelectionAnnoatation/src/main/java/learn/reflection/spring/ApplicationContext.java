package learn.reflection.spring;

import learn.reflection.spring.annotation.Configuration;

import java.util.HashMap;

public class ApplicationContext {
    private static HashMap<Class<?>, Object> app = new HashMap<>();

    public ApplicationContext(Class<AppConfig> appConfigClass) {
        Spring.initializeSpringContext(appConfigClass);
    }

    private static class Spring {
        private static  void initializeSpringContext(Class<?> clss){
            if(!clss.isAnnotationPresent(Configuration.class)){

            }else
            {}
        }

    }
}
