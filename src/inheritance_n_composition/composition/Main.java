package inheritance_n_composition.composition;

public class Main {
    public static void main(String[] args) {
        Bird eagle = new Bird(new FlyWithWings());
        Bird penguin = new Bird(new NoFly());

        eagle.performFly();
        penguin.performFly();
    }
}
