package collection.optional;

import java.util.List;
import java.util.Optional;

public class Optional2 {

    public static void main(String[] args) {
        Optional<Integer> intgerValue = Optional.empty();
        intgerValue = Optional.of(23);
        System.out.println(intgerValue.get());
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
