package collection.hashsample;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Hash4 {
    public static void main(String[] args) {

        var compare = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 > o2 ){
                    return 1;
                }
                else if(o1 == o2){
                    return 0;
                }else
                {
                    return -1;
                }

            }


        };

        var hashSet = new TreeSet<Integer>(compare);
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(4);
        System.out.println(hashSet);
    }
}
