package Generic.rawtypes;

public class Store<T> {
    T value;

    public Store(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
