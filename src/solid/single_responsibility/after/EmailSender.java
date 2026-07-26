package solid.single_responsibility.after;

import solid.single_responsibility.User;

public class EmailSender {
    public void sendWelcomeEmail(User user) {
        System.out.println("Sending welcome email...");
    }
}
