package Generic.bounded;

public class Store <T extends Car>{
    T value;

    public Store(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
