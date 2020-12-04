package learn.reflection.annotation;

class parent {
    public void m1(){
        System.out.println("m1 implementation from parent");
    }

    public void m2(int a){
        System.out.println("m2 implementation from parent"  +a);
    }

    public void m3(){
        System.out.println("m3 implementation from parent");
    }

}

public class GeneralPurposeAnnotation extends  parent{
    @Override
    public void m1(){
        System.out.println("m1 implementation from Child");
    }

    public static void main(String[] args) {
        @SuppressWarnings("unused")
     int a =10;

    }

    MyfunctionalInterface impl = () -> System.out.println("Method invoked");

}

@FunctionalInterface
interface MyfunctionalInterface {
    public void method();
}
