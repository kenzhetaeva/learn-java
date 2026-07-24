package inheritance_n_composition.composition;

public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Flying with my wings");
    }
}
