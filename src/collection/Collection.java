package collection;

import java.util.*;

public class Collection {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            list.add(random.nextInt(20));
        }
        System.out.println(list);

        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {
            if (iterator.next() % 2 == 0) {
                iterator.remove();
            }
        }
        System.out.println(list);

        Set<Integer> set = new TreeSet<>(list);
        System.out.println(set);

    }
}
