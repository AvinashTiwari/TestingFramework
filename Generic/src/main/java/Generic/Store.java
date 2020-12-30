package Generic;

public class Store {
    Object value;

    public Store(Object object){
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public void valueClass(){
        System.out.println(value.getClass());
    }
}
