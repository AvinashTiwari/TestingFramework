package learn.reflection.field;

import java.lang.reflect.Field;

public class FieldInfo {
    public static void main(String[] args) {
        Entity e = new Entity(10,"Id");
        Class<? extends  Entity> clss = e.getClass();
        Field[] fields = clss.getFields();

        for(Field field: fields){
            System.out.println(field.getName());
        }

        Field[] declaredFields = clss.getDeclaredFields();
        for(Field field: declaredFields){
            System.out.println(field.getName());
        }

        Field type = null;
        Field val = null;
        try {
            type = clss.getField("type");
            val = clss.getDeclaredField("val");
            val.setAccessible(true);
            val.set(e, 19);
            type.set(e, "roll no");
            System.out.println(e.getType()+ " " + e.getVal());

        } catch (NoSuchFieldException noSuchFieldException) {
            noSuchFieldException.printStackTrace();
        } catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
        }

    }
}
