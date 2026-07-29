package practice2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<NotificationSender> senderList = new ArrayList<>();
        senderList.add(new EmailNotificationSender());
        NotificationSenderFactory notificationSenderFactory = new NotificationSenderFactory(senderList);
        NotificationService service = new NotificationService(notificationSenderFactory);
        service.sendNotification(NotificationType.EMAIL, "Aidana", "Hehe");
    }
}
