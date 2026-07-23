package stack_heap;

public class MemoryTest {

    public static void main(String[] args) {  // аргумент args - ссылка, поэтому лежит в stack
        int primitive = 10;                   // локальные примитивы лежат в stack
        User user = new User("Aidana"); // объект User лежит в Heap, ссылка 'user' - в stack
        check(user);                          // новый фрейм в stack
    }

    static void check(User user) {            // копия ссылки 'user' в stack
        String name = user.getName();         // ссылка 'name' в stack, строка в Heap (Pool)
    }
}
