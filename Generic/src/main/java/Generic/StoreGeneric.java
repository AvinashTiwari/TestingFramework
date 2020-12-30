package Generic;

public class StoreGeneric<T> {
    T value;

    public StoreGeneric(T object){
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void valueClass(){
        System.out.println(value.getClass());
    }
}
