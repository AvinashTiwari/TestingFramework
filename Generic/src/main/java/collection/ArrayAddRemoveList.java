package collection;

import java.util.ArrayList;

public class ArrayAddRemoveList {
    public static void main(String[] args) {
        var  list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(1,707);

        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        list.remove(Integer.valueOf(1));
        System.out.println(list);
    }

}
