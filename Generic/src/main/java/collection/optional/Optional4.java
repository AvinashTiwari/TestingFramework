package collection.optional;

import javax.swing.text.html.Option;
import java.util.Optional;

public class Optional4 {

    public static void main(String[] args) {
        Optional<Integer> intgerValue = Optional.empty();
        intgerValue = Optional.of(50);
        System.out.println(intgerValue.map(i->i + 10).orElse(10));
    }

   }
