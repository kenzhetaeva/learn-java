package com.aidana.collection.polymorphism;

public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Cat();
        doAction(animal1);
        Animal animal2 = new Dog();
        doAction(animal2);
    }

    static void doAction(Animal animal) {
        System.out.println(animal.getAnimalVoice(animal));
    }
}
