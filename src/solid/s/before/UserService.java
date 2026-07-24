package solid.s.before;

import solid.s.User;

public class UserService { // God Object
    public void registerUser(User user) {
        // 1. Логика сохранения в БД
        System.out.println("Saving user to DB...");

        // 2. Логика отправки email
        System.out.println("Sending welcome email...");

        // 3. Логика логирования
        System.out.println("Log: User registered at" + System.currentTimeMillis());
    }
}
