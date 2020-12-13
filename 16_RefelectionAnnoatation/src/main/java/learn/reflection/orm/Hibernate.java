package learn.reflection.orm;

import learn.reflection.orm.annotation.Column;
import learn.reflection.orm.annotation.PrimaryKey;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
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
        this.conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
    }

    public void write(T t) throws Exception {
        Class<? extends Object> clss = t.getClass();
        Field[] decalredFields = clss.getDeclaredFields();
        Field pkey  = null;
        ArrayList<Field> columns = new ArrayList<>();
        StringJoiner joiner = new StringJoiner(",");
        for(Field field : decalredFields ){
            if(field.isAnnotationPresent(PrimaryKey.class)){
                pkey = field;
               // System.out.println("The primary Key Is " + field.getName() + " Value :" + field.get(t));
            }else if(field.isAnnotationPresent(Column.class)){
               joiner.add(field.getName());
                columns.add(field);
                //System.out.println("The Column Key Is " + field.getName()  + " Value :" + field.get(t));
            }
        }

        int number = joiner.length() + 1;
       String qMarks =  IntStream.range(0, number)
                .mapToObj(e->"?")
                .collect(Collectors.joining(","));

        String sql = "insert into " + clss.getSimpleName() + " ( " + pkey.getName() + " , " + joiner.toString()+ ") values ( ?,?,?,?,?)" ;
        System.out.println("sql strin " + sql);
        PreparedStatement stmt = conn.prepareStatement(sql);

        if(pkey.getType() == long.class){
            stmt.setLong(1, id.incrementAndGet());
        }
        int index = 2;
        for(Field field: columns){
            field.setAccessible(true);
            if(field.getType() == int.class){
                stmt.setInt(index++,(int)field.get(t));
                System.out.println("in int" + (int)field.get(t));
            } else if(field.getType() == String.class){
                stmt.setString(index++,(String) field.get(t));
                System.out.println("in String " + (String)field.get(t));

            }
        }
        stmt.executeUpdate();
    }

    public T read(Class<T> clss, long l) throws SQLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Field[] decalredFields = clss.getDeclaredFields();
        Field primaryField = null;
        for(Field field : decalredFields ){
            if(field.isAnnotationPresent(PrimaryKey.class)){
                primaryField = field;
                break;
                // System.out.println("The primary Key Is " + field.getName() + " Value :" + field.get(t));
            }
        }
        String sql = "select * from " + clss.getSimpleName() + " where " + primaryField.getName() + "  = " + l;
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        T t = clss.getConstructor().newInstance();
        long transationid = rs.getInt(primaryField.getName());
        primaryField.setAccessible(true);
        primaryField.set(t,transationid);
        for(Field field : decalredFields ){
            if(field.isAnnotationPresent(Column.class)){
                field.setAccessible(true);
                if(field.getType() == int.class){
                    field.set(t,rs.getInt(field.getName()));
                }else if(field.getType() == String.class){
                    field.set(t,rs.getString(field.getName()));
                }
            }
        }
        return t;
    }
}

