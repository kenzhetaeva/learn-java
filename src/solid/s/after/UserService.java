package solid.s.after;

import solid.s.User;

public class UserService {
    private final UserRepository userRepository;
    private final EmailSender emailSender;

    public UserService(UserRepository userRepository, EmailSender emailSender) {
        this.userRepository = userRepository;
        this.emailSender = emailSender;
    }

    public void registerUser(User user) {
        userRepository.save(user);
        emailSender.sendWelcomeEmail(user);
    }
}
