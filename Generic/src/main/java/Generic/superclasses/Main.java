package Generic.superclasses;

public class Main {
    public static void main(String[] args) {
       var  box = new Box<Integer>();
       box.value = 5;
       int x = box.getValue();
        System.out.println(x);
    }
}
