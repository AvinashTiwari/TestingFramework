package collection.optional;

import java.util.List;

public class Optional1 {

    public static void main(String[] args) {
        var per = number(0);
        System.out.println(per);
    }

    static Person number(int poistion){
        Person person = null;
        var personlist = List.of(
                new Person("A",1),
                new Person("B",2)
        );

         if(poistion >=0 && poistion < personlist.size()){
             person = personlist.get(poistion);
         }

        return person;
    }
}
