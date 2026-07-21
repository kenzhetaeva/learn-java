package generic;

public class Gen<T> {
    T obj;
    Gen(T o) {
        obj = o;
    }

    static void setA(Gen<? extends A> obj) {
        System.out.println("setA");
    }

    static void setB(Gen<? super B> obj) {
        System.out.println("setB");
    }

    public static void main(String[] args) {
        Gen<A> aGen = new Gen<>(new A());
        Gen<B> bGen = new Gen<>(new B());
        Gen<C> cGen = new Gen<>(new C());

        setA(cGen);
        setB(aGen);
        setB(bGen);
    }
}
