package collection.arraysample;

import java.util.Arrays;

public class ArrayIterator {
    public static void main(String[] args) {
        var list = Arrays.asList(3,4,5,6,7);
        var iterate = list.iterator();

        while(iterate.hasNext()){
            System.out.println(iterate.next());
        }


        var iterates = list.listIterator();
        while(iterates.hasNext()){
            System.out.println("list " + iterates.next());
        }

    }
}
