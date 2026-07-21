package hashmap;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class ManagerTest {

    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.addNewUser(new User("aidana", "12345", Instant.now().minus(2, ChronoUnit.MINUTES)));
        manager.addNewUser(new User("aiman", "67890", Instant.now().minus(5, ChronoUnit.MINUTES)));
        manager.addNewUser(new User("ilyas", "1112131415", Instant.now().plus(3, ChronoUnit.MINUTES)));
        manager.addNewUser(new User("nurshat", "1617181920", Instant.now().plus(6, ChronoUnit.MINUTES)));
        manager.addNewUser(new User("nuraisha", "2122232425", Instant.now().plus(10, ChronoUnit.DAYS)));

        manager.getAllUsers("date");
    }
}
