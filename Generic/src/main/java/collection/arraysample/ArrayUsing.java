package collection.arraysample;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayUsing {
    public static void main(String[] args) {
        var list = new ArrayList<>(Arrays.asList(3,4,5,6,7));
        list.add(90);
        System.out.println(list.get(1));
    }
}
