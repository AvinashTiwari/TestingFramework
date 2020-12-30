package Generic;

public class Main {
    public static void main(String[] args) {
        StoreGeneric<Integer> store = new StoreGeneric<Integer>(4);
        Integer x = store.getValue();

    }
}
