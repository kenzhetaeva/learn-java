package final_key_word;

import java.util.ArrayList;
import java.util.List;

public class FinalTest {
    public static void main(String[] args) {
        final List<String> list = new ArrayList<>();
        list.add("Middle");       // Состояние объекта менять можно
//        list = new ArrayList<>(); // Нельзя переназначить ссылку

        final int x = 10;
//        x = 20; // Значение примитива менять нельзя
    }
}
