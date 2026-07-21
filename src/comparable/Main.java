package comparable;

import java.util.Comparator;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        Comparator<User> userComparator = new UserNameComparator().thenComparing(new UserAgeComparator());
        TreeSet<User> users = new TreeSet<>(userComparator);
        users.add(new User("Nuraisha", 16));
        users.add(new User("Nurshat", 21));
        users.add(new User("Nurshat", 20));
        users.add(new User("Ilyas", 23));
        users.add(new User("Aidana", 25));
        users.add(new User("Aiman", 27));
        users.add(new User("Aiman", 28));

        for (User user: users) {
            System.out.println("Name: " + user.getName() + ", Age: " + user.getAge());
        }


    }
}
