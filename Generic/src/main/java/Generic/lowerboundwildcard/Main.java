package Generic.lowerboundwildcard;

public class Main {
    public static void main(String[] args) {
        var countries = new String[] {"USA", "INDIA", "UK"};
        var scores = new Number[]{22,64,55};
        var names = new String[] {"A", "B"};
        var store1 =  new Store<>(countries);
        var store2 =  new Store<>(scores);
        var store3 = new Store<>(names);

        System.out.println(store1.list.length);
        System.out.println(store2.list.length);

        store1.greaterThen(store2);

    }
}
