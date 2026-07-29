package practice2;

public class SmsNotificationSender implements NotificationSender {
    @Override
    public void send(NotificationRequest request) {
        System.out.println("Sending SMS to " + request.recipient() + ": " + request.message());
    }

    @Override
    public NotificationType getType() {
        return NotificationType.SMS;
    }
}
