package string_n_string_pool;

public class StringQuiz {
    public static void main(String[] args) {
        String s1 = "Java";
        String s2 = "Java";
        String s3 = new String("Java");
        String s4 = s3.intern();

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s4);
//        System.out.println(s3.intern());

        String s5 = "Ja";
        String s6 = s5 + "va";
        System.out.println(s1 == s6);
    }
}
