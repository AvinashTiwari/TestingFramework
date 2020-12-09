package learn.reflection.orm;

import learn.reflection.orm.annotation.Column;
import learn.reflection.orm.annotation.PrimaryKey;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Hibernate<T> {
    Connection conn;
    public static <T> Hibernate<T> getConnection() throws SQLException {
        return new Hibernate<T>();
    }

    private Hibernate() throws SQLException {
        //this.conn = DriverManager.getConnection("");
    }

    public void write(T t) throws IllegalAccessException {
        Class<? extends Object> clss = t.getClass();
        Field[] decalredFields = clss.getDeclaredFields();
        for(Field field : decalredFields ){
            if(field.isAnnotationPresent(PrimaryKey.class)){
                System.out.println("The primary Key Is " + field.getName() + " Value :" + field.get(t));
            }else if(field.isAnnotationPresent(Column.class)){
                System.out.println("The Column Key Is " + field.getName()  + " Value :" + field.get(t));
            }
        }

        String sql = "inert into " + clss.getSimpleName() + " (" ++ ") values ( " + + ")" ;
    }
}

