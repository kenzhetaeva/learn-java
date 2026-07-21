package polymorphism;

public class Cat extends Animal {
    @Override
    public String getAnimalVoice(Animal animal) {
        return "Meow";
    }
}
