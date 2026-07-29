package practice2;

public class NotificationService {
    private final NotificationSenderFactory senderFactory;

    public NotificationService(NotificationSenderFactory senderFactory) {
        this.senderFactory = senderFactory;
    }

    public void sendNotification(NotificationType type, String recipient, String message) {
        NotificationRequest request = new NotificationRequest(recipient, message);
        NotificationSender sender = senderFactory.getSender(type);
        sender.send(request);
    }
}
