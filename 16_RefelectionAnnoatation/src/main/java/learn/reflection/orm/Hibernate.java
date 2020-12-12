package learn.reflection.orm;

import learn.reflection.orm.annotation.Column;
import learn.reflection.orm.annotation.PrimaryKey;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Hibernate<T> {
    private Connection conn;
    private AtomicLong id = new AtomicLong(0L);

    public static <T> Hibernate<T> getConnection() throws SQLException {
        return new Hibernate<T>();
    }

    private Hibernate() throws SQLException {
        this.conn = DriverManager.getConnection("");
    }

    public void write(T t) throws Exception {
        Class<? extends Object> clss = t.getClass();
        Field[] decalredFields = clss.getDeclaredFields();
        Field pkey  = null;
        ArrayList<Field> columns = new ArrayList<>();
        StringJoiner joiner = new StringJoiner(",");
        for(Field field : decalredFields ){
            if(field.isAnnotationPresent(PrimaryKey.class)){
                pkey =field;
                System.out.println("The primary Key Is " + field.getName() + " Value :" + field.get(t));
            }else if(field.isAnnotationPresent(Column.class)){
               joiner.add(field.getName());
                columns.add(field);
                System.out.println("The Column Key Is " + field.getName()  + " Value :" + field.get(t));
            }
        }

        int number = joiner.length() + 1;
       String qMarks =  IntStream.range(0, number)
                .mapToObj(e->"?")
                .collect(Collectors.joining(","));

        String sql = "inert into " + clss.getSimpleName() + " (" + pkey.getName() + joiner.toString()+ ") values ( " + qMarks + ")" ;
        PreparedStatement stmt = conn.prepareStatement(sql);

        if(pkey.getType() == long.class){
            stmt.setLong(1, id.incrementAndGet());
        }
        int index = 2;
        for(Field field: columns){
            field.setAccessible(true);
            if(field.getType() == int.class){
                stmt.setInt(index++,(int)field.get(t));
            } else if(field.getType() == String.class){
                stmt.setString(index++,(String) field.get(t));

            }
        }
        stmt.executeUpdate();
    }
}

