package Generic.interfaceGeneric;

public interface Operation<T> {
    T get (int position);
    void replace(int position , Integer value);
}
