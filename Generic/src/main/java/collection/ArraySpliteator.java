package collection;

import java.util.Arrays;

public class ArraySpliteator {
    public static void main(String[] args) {
        var list = Arrays.asList(3,4,5,6,7);
        var iterateS = list.spliterator();
        //iterateS.forEachRemaining(integer-> System.out.println(integer));
        while(iterateS.tryAdvance(i-> System.out.println(i)));

    }
}
