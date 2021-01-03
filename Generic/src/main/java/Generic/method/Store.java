package Generic.method;

public class Store {
    public void Open(){
        System.out.println("Opening Store..");
    }

    public <T extends Number> void Print(T num){
        System.out.println(num);
    }
}
