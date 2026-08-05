package hashmap2;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("A", 1);
        map.put("A", 2);

        System.out.println(map.size());
        System.out.println(map.get("A"));
    }
}
