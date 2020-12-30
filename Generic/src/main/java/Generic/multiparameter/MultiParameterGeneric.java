package Generic.multiparameter;

public class MultiParameterGeneric {
    public static void main(String[] args) {
        var store = new store<String,Integer>("hello",2);
        int a = store.getVal2();

        var store2 = new store<Double, Character>(12.0,'c');
        double b = store2.getVal1();
    }
}
