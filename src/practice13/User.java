package practice13;

public class User {
    private final String name;
    private final int age;
    private final boolean isActive;

    public User(String name, int age, boolean isActive) {
        this.name = name;
        this.age = age;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isActive() {
        return isActive;
    }
}
