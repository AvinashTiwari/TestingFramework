package collection.hashsample;

import java.util.HashSet;

public class Hash1 {
    public static void main(String[] args) {
        var hashSet = new HashSet<Integer>();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(4);

        System.out.println(hashSet);
        for(Integer inta : hashSet){
            System.out.println(inta);
        }
    }
}
