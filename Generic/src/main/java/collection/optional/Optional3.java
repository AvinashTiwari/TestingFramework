package collection.optional;

import java.util.List;
import java.util.Optional;

public class Optional3 {

    public static void main(String[] args) {
        Optional<Integer> intgerValue = Optional.empty();
        intgerValue = Optional.of(11);
        if(intgerValue.isPresent()) {
            System.out.println(intgerValue.get());
        }else
        {
            System.out.println("No value");
        }


        intgerValue = Optional.ofNullable(null);
        if(intgerValue.isPresent()) {
            System.out.println(intgerValue.get());
        }else
        {
            System.out.println("No value");
        }
    }

   }
