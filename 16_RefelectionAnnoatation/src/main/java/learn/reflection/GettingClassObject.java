package learn.reflection;

public class GettingClassObject {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> class1= Class.forName("java.lang.String");
        Class<?> class2= Class.forName("java.lang.String");

        System.out.println(class1==class2);
        Class<?> class3 = int.class;
        Class<?> class4 = String.class;

        myclass myclassd = new myclass();
       Class<? extends  myclass>class5  = myclassd.getClass();

       Class<?> superclass = class5.getSuperclass();
        Class<?>[] interfaces = class5.getInterfaces();
        System.out.println(class5.getName());
    }
}
