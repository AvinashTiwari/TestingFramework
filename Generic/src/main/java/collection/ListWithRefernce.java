package collection;

import java.util.ArrayList;

public class ListWithRefernce {
    public static void main(String[] args) {
        var user = new ArrayList<User>();
        user.add(new User("A",10));
        user.add(new User("B",20));

        var FU = user.get(0);
        System.out.println(FU.age);
    }
}
