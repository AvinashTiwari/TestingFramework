package learn.reflection.annotation;

public class Box<@NoEmpty T> {
    @NoEmpty int size;
    T type;

    public Box(int size, T type){
        this.size = size;
        this.type = type;
    }

    class NestedBox extends Box<T>{
         NestedBox(int size,@NoEmpty T type){
             super(size, type);
        }
    }

}
