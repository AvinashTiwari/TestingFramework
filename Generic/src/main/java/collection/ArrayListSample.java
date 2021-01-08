package collection;

import java.util.ArrayList;

public class ArrayListSample {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(3);
        list.add(2);

        System.out.println(list.get(2));
        System.out.println(list.size());

    }
}
