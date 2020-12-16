package ro.leje.service;

import ro.leje.domain.Employee;
import ro.leje.tuple.Pair;

import java.math.BigDecimal;
import java.util.List;

public class Average {

    public static BigDecimal calculateAverage(final List<Employee> employees) {
        var total = BigDecimal.ZERO;
        var count = 0;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getSalary().compareTo(BigDecimal.valueOf(2000)) >= 0) {
                total = total.add(employees.get(i).getSalary());
                count++;
            }
        }
        return count != 0 ? total.divide(new BigDecimal(count)) : BigDecimal.ZERO;
    }

    public static BigDecimal calculateAverageInAModernFashion(final List<Employee> employees) {
        var pair = employees.stream()
                .map(employee -> employee.getSalary())
                .filter(salary -> salary.compareTo(BigDecimal.valueOf(2000)) >= 0)
                .map(salary -> new Pair<>(salary, BigDecimal.ONE))
                .reduce(new Pair<>(BigDecimal.ZERO, BigDecimal.ZERO),
                        (a, b) -> new Pair<>(a.left.add(b.left), a.right.add(b.right)));
        return pair.right != BigDecimal.ZERO ? pair.left.divide(pair.right) : BigDecimal.ZERO;
    }
}
