package com.aidana.collection.polymorphism;

public class Cat extends Animal {
    @Override
    public String getAnimalVoice(Animal animal) {
        return "Meow";
    }
}
