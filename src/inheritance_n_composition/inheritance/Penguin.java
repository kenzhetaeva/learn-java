package inheritance_n_composition.inheritance;

public class Penguin extends Bird {
    @Override
    public void fly() {
        // Нарушение принципа подстановки Лисков (LSP)!
        throw new UnsupportedOperationException("Penguins can't fly");
    }
}
