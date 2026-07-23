package autoboxing_n_wrapper_classes;

public class Main {
    public static void main(String[] args) {
        Integer a = 100;
        Integer b = 100;
        System.out.println(a == b);

        Integer c = 200;
        Integer d = 200;
        System.out.println(c == d);

        //В Java существует **Integer Cache** (от -128 до 127). Числа в этом диапазоне кэшируются,
        // поэтому ссылки `a` и `b` указывают на один объект. `200` в кэш не входит, создаются два разных объекта.

        System.out.println("===========");

        Integer e1 = -128;
        Integer f1 = -128;
        System.out.println(e1 == f1);

        Integer e2 = -129;
        Integer f2 = -129;
        System.out.println(e2 == f2);

        System.out.println("===========");

        Integer g1 = 127;
        Integer h1 = 127;
        System.out.println(g1 == h1);

        Integer g2 = 128;
        Integer h2 = 128;
        System.out.println(g2 == h2);
    }
}
