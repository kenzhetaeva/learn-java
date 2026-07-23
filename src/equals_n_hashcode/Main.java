package equals_n_hashcode;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<User, String> map = new HashMap<>();
        User u1 = new User("1");
        User u2 = new User("1");

        map.put(u1, "First");
        System.out.println(map.get(u2));
    }
}
