package solid.single_responsibility.after;

import solid.single_responsibility.User;

public class UserRepository {
    public void save(User user) {
        System.out.println("Saving user to DB...");
    }
}
