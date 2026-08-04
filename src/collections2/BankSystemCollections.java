package collections2;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BankSystemCollections {

    // 1. Список последних 100 транзакций пользователя
    // Выбор: ArrayDeque или LinkedList в режиме фиксированного размера
    // Почему: Позволяет добавлять новые транзакции в начало/конец за O(1)
    // и удалять устаревшие (101-е) элементы без затрат на сдвиг массива.
    private final Deque<Transaction> recentTransactions = new ArrayDeque<>(100);

    // 2. Быстрый поиск счета по номеру
    // Выбор: HashMap<String, Account>
    // Почему: Поиск, добавление и получение по String-ключу происходят за O(1).
    // String неизменяем (immutable) и отлично подходит на роль ключа.
    private final Map<String, Account> accountLookupMap = new HashMap<>();

    // 3. Хранение уникальных ролей пользователя
    // Выбор: EnumSet (если ролями являются Enum) или HashSet
    // Почему: EnumSet крайне эффективен по памяти (использует битовые маски/битовые векторы),
    // гарантирует уникальность ролей и операции за O(1).
    private final Set<UserRole> userRoles = EnumSet.noneOf(UserRole.class);

    // 4. Очередь задач на отправку уведомлений
    // Выбор: Concurrent / BlockingQueue (например, ArrayBlockingQueue)
    // Почему: Нужна потокобезопасная коллекция для шаблона "Producer-Consumer".
    // Потоки-издатели кладут задачи, а потоки-воркеры их обрабатывают.
    private final BlockingQueue<NotificationTask> notificationQueue = new ArrayBlockingQueue<>(1000);

    // 5. Список счетов, отсортированных по балансу
    // Выбор: TreeSet<Account> (или сортировка ArrayList при выдаче)
    // Почему: TreeSet автоматически поддерживает порядок элементов на основе Comparator/Comparable
    // за время O(log n) на операцию вставки.
    private final Set<Account> accountsSortedByBalance = new TreeSet<>(
            Comparator.comparing(Account::getBalance).reversed()
                    .thenComparing(Account::getAccountNumber) // Доп. критерий для исключения утери уникальных счетов с одинаковым балансом
    );
}
