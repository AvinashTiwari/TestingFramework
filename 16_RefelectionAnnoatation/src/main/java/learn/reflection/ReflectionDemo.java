package learn.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class myclass {
    private myclass(){
        System.out.println("Myclass object class!");
    }
}

public class ReflectionDemo {
    public static void main(String[] args) {
        try {
          Class<?> cls = Class.forName("learn.reflection.myclass");
           Constructor<?> con = cls.getDeclaredConstructor();
            con.setAccessible(true);
            myclass  newInstance = (myclass) con.newInstance();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
