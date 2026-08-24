package grouping_by;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class GroupingByExamples {

    record Employee(String department, String name, BigDecimal salary) {}

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("IT", "Alice", new BigDecimal("5000")),
                new Employee("IT", "Bob", new BigDecimal("7000")),
                new Employee("HR", "Charlie", new BigDecimal("4000")),
                new Employee("HR", "Diana", new BigDecimal("4500"))
        );

        // 1. Подсчет кол-ва сотрудников в каждом отделе
        Map<String, Long> countByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.counting() // Downstream операция
                ));

        System.out.println("Количество по отделам: " + countByDept); // {HR=2, IT=2}

        // 2. Трансформация списка: Отдел -> Список только имен сотрудников (а не объектов)
        Map<String, List<String>> namesByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.mapping(Employee::name, Collectors.toList())
                ));

        System.out.println("Имена по отделам: " + namesByDept); // {HR=[Charlie, Diana], IT=[Alice, Bob]}

        // 3. Поиск сотрудника с максимальной зарплатой в каждом отделе
        Map<String, Optional<Employee>> topPaidByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.maxBy(Comparator.comparing(Employee::salary))
                ));

        System.out.println("Самые высокие зарплаты: " + topPaidByDept); // {HR=Optional[Employee[department=HR, name=Diana, salary=4500]], IT=Optional[Employee[department=IT, name=Bob, salary=7000]]}
    }
}
