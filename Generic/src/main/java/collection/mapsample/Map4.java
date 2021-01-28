package collection.mapsample;

import java.util.HashMap;

public class Map4 {
    public static void main(String[] args) {
        var hashMap = new HashMap<Integer, Integer>();
        hashMap.put(1,100);
        hashMap.put(2,200);
        hashMap.put(3,300);
        var values = hashMap.values();
        System.out.println(values);
        System.out.println(hashMap);
        var keys = hashMap.keySet();
        System.out.println(keys);
        var removvalue = hashMap.remove(1);
        System.out.println(removvalue);
    }
}
