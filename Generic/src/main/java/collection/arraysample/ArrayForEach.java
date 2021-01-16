package collection.arraysample;

import java.util.ArrayList;

public class ArrayForEach {
    public static void main(String[] args) {
        var  list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        for(int i =0 ; i < list.size();i++){
            System.out.println(list.get(i));
        }

        for(int x: list){
            System.out.println(x);
        }
    }
}
