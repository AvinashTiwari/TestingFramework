package Generic.interfaceGeneric;

public class Store<T> implements Operation<T>{
    T[] values;

    public Store(T[] values) {
        this.values = values;
    }

    @Override
    public T get(int position) {
           return values[position];
    }

    @Override
    public void replace(int position, Integer value) {

    }
 /*
    @Override
    public Integer get(int position) {
        return values[position];
    }


    @Override
    public void replace(int position, Integer value) {
        values[position] = value;

    }*/
}
