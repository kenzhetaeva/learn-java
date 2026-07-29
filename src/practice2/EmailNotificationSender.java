package practice2;

public class EmailNotificationSender implements NotificationSender {
    @Override
    public void send(NotificationRequest request) {
        System.out.println("Sending EMAIL to " + request.recipient() + ": " + request.message());
    }

    @Override
    public NotificationType getType() {
        return NotificationType.EMAIL;
    }
}
