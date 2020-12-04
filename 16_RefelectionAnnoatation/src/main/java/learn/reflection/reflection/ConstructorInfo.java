package learn.reflection.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorInfo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clss= Class.forName("learn.reflection.reflection.Entity");
        Constructor<?>[] constructors = clss.getConstructors();
        for(Constructor<?> constructor : constructors){
            System.out.println(constructor);
        }

        Constructor<?>[] constructorss = clss.getDeclaredConstructors();
        for(Constructor<?> constructor : constructorss){
            System.out.println(constructor);
        }

        Constructor<?> publicconstructor = clss.getConstructor(int.class, String.class);
        Entity studentId = (Entity) publicconstructor.newInstance(10, "studentId");
        System.out.println(studentId.getType());
        System.out.println(studentId.getVal());

        Constructor<?> privateconstructor = clss.getDeclaredConstructor();
        privateconstructor.setAccessible(true);
        Entity privatestudentId = (Entity) privateconstructor.newInstance();
        System.out.println(privatestudentId.getType());
        System.out.println(privatestudentId.getVal());



    }
}
