package collection.hashsample;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class Hash2 {
    public static void main(String[] args) {
        var hashSet = new LinkedHashSet<Integer>();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(4);
        System.out.println(hashSet);

    }
}
