package collection;

import java.util.List;

public class ArrayListViceversa {
    public static void main(String[] args) {
        var num = List.of(22,1,101,22);
        var arr = num.toArray();
        System.out.println(arr[1]);
    }
}
