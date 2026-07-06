package com.aidana.collection.enums;

public class Pair<T, V> {
    private T key;
    private V value;

    public Pair(T key, V value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public static void main(String[] args) {
        for (Day day: Day.values()) {
            Pair<Day, Integer> pair = new Pair<>(day, day.getWorkingHour());
            System.out.println("День недели: " + pair.getKey() + ". Количество часов: " + pair.getValue());
        }
    }
}
