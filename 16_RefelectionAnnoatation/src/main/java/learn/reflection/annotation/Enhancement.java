package learn.reflection.annotation;

public class Enhancement {
    public static void main(String[] args) {
        Box<String> box = new @NoEmpty @ReadOnly Box<>(10, "Container");
        box.new @ReadOnly NestedBox(11,"Cylinder");
    }
}
