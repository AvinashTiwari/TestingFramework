package collection;

import java.util.ArrayList;

public class ArrayRemoveIfClearConatin {
    public static void main(String[] args) {
        var  list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.removeIf(integer -> integer %2 ==0 );
        System.out.println(list);
      var result =   list.contains(3);
        System.out.println(result);
    }
}
