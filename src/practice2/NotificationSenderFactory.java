package practice2;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NotificationSenderFactory {
    private final Map<NotificationType, NotificationSender> senders;

    // Автоматическая сборка всех реализаций из списка (как это делает Spring DI)
    public NotificationSenderFactory(List<NotificationSender> senderList) {
        this.senders = senderList.stream()
                .collect(Collectors.toMap(NotificationSender::getType, Function.identity()));
    }

    public NotificationSender getSender(NotificationType type) {
        NotificationSender sender = senders.get(type);
        if (sender == null) {
            throw new IllegalArgumentException("Sender not found for type: " + type);
        }
        return sender;
    }
}
