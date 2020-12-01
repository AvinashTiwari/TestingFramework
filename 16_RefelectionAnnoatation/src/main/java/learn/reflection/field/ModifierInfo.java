package learn.reflection.field;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ModifierInfo {
    public static void main(String[] args) throws NoSuchMethodException {
        Entity e = new Entity(10,"Id");
        Class<? extends  Entity> clss = e.getClass();
        int modifierInt = clss.getModifiers();
        int publicModifier = (modifierInt & Modifier.PUBLIC);
        System.out.println(publicModifier);

        Method setVal = clss.getMethod("getVal");
        int modifiers = setVal.getModifiers();
        int privateModifeer =  (modifiers & Modifier.PUBLIC);
        System.out.println(privateModifeer);


    }
}
