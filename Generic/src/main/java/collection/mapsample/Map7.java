package collection.mapsample;

import java.util.HashMap;

public class Map7 {
    public static void main(String[] args) {
        var hashMap = new HashMap<Integer, Integer>();
        hashMap.put(1,100);
        hashMap.put(2,200);
        hashMap.put(3,300);

        hashMap.compute(1,(k,v) -> v+10);

        System.out.println(hashMap);
    }
}
