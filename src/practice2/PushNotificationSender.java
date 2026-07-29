package practice2;

public class PushNotificationSender implements NotificationSender {
    @Override
    public void send(NotificationRequest request) {
        System.out.println("Sending PUSH to " + request.recipient() + ": " + request.message());
    }

    @Override
    public NotificationType getType() {
        return NotificationType.PUSH;
    }
}
