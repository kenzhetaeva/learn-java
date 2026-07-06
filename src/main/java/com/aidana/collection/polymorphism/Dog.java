package com.aidana.collection.polymorphism;

public class Dog extends Animal {
    @Override
    public String getAnimalVoice(Animal animal) {
        return "Gav";
    }
}
