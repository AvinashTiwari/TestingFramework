package learn.reflection.field;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodInfo {
    public static void main(String[] args) {
        Entity e = new Entity(10,"Id");
        Class<? extends  Entity> clss = e.getClass();
        Method[] methods = clss.getMethods();
        for(Method method: methods){
            System.out.println(method.getName());
        }

        System.out.println("=======A+++++=====");
        Method[] decmethods = clss.getDeclaredMethods();
        for(Method method: decmethods){
            System.out.println(method.getName());
        }
        System.out.println("=======A+++++=====");
        try {
            Method setValues = clss.getMethod("setVal", int.class);
              setValues.invoke(e, 15);
            Method getValues = clss.getMethod("getVal",null);
            System.out.println(getValues.invoke(e, null));

            Method setprivateValues = clss.getDeclaredMethod("setprivateVal", int.class);
            setprivateValues.setAccessible(true);
            setValues.invoke(e, 16);
            getValues = clss.getMethod("getVal",null);
            System.out.println(getValues.invoke(e, null));


        } catch (NoSuchMethodException noSuchMethodException) {
            noSuchMethodException.printStackTrace();
        } catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
        } catch (InvocationTargetException invocationTargetException) {
            invocationTargetException.printStackTrace();
        }
    }
}
