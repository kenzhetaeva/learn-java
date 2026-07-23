package practice1;

import java.util.Date;

public final class Employee {
    private final String name;
    private final double salary;
    private final Date hireDate;

    public Employee(String name, double salary, Date hireDate) {
        this.name = name;
        this.salary = salary;
        // 4. Защитное копирование для mutable объекта (Date)
        // Это предотвратит изменение даты извне через оригинальную ссылку
        this.hireDate = new Date(hireDate.getTime());    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Date getHireDate() {
        hireDate.setTime(12345);
        // 4. Защитное копирование при возврате из геттера
        return new Date(hireDate.getTime());
    }
}
