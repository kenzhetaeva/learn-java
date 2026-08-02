package mutable_key_in_hashmap;

import java.util.HashMap;
import java.util.Map;

public class MutableKeyExample {
    public static void main(String[] args) {
        Map<UserKey, String> map = new HashMap<>();

        UserKey key = new UserKey("USR-101");
        map.put(key, "ACTIVE_SESSION");

        key.setId("USR-999");

        String session = map.get(key);

        System.out.println("Session status: " + session); // null
    }
}
