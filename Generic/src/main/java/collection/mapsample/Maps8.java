package collection.mapsample;

import java.util.HashMap;

public class Maps8 {
    public static void main(String[] args) {
        var hashMap = new HashMap<Integer, Integer>();
        hashMap.put(1,100);
        hashMap.put(2,200);
        hashMap.put(3,300);
        hashMap.merge(2,200, (ov,nv) -> ov+nv);
        hashMap.merge(4,400, (ov,nv) -> ov+nv);

        System.out.println(hashMap);
    }
}
