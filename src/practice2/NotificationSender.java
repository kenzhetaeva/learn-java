package practice2;

public interface NotificationSender {
    void send(NotificationRequest request);
    NotificationType getType();
}
