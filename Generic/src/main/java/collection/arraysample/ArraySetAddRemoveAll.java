package collection.arraysample;

import java.util.ArrayList;

public class ArraySetAddRemoveAll {
    public static void main(String[] args) {
        var  lists = new ArrayList<Integer>();
        lists.add(10);
        lists.add(21);
        lists.add(32);

        var  list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);
        list.set(1,11);
        System.out.println(list);
        list.addAll(lists);
        System.out.println(list);
        list.removeAll(lists);
        System.out.println(list);

    }
}
