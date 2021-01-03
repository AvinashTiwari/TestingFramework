package Generic.interfaceGeneric;

public class Main {
    public static void main(String[] args) {
      var values = new Integer[]{45,22,24,26};
      var store = new Store<Integer>(values);

        System.out.println(store.get(1));

        var valuestring = new String[]{"45","22","24","26"};
        var storeString = new Store<String>(valuestring);
        System.out.println(storeString.get(3));
    }
}
