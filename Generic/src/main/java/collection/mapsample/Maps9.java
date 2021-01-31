package collection.mapsample;

import java.util.HashMap;

public class Maps9 {
    public static void main(String[] args) {
        var hashMap = new HashMap<Integer, Integer>();
        hashMap.put(1,100);
        hashMap.put(2,200);
        hashMap.put(3,300);

        var result = hashMap.containsKey(22);
        System.out.println(result);

        var resultValue = hashMap.containsKey(100);
        System.out.println(resultValue);
        var size = hashMap.containsKey(22);
        System.out.println(size);
    }
}
