package ro.leje.service;

import ro.leje.domain.Employee;
import ro.leje.tuple.Pair;

import java.math.BigDecimal;
import java.util.List;

public class Average {

    public static BigDecimal calculateAverage(final List<Employee> employees, final BigDecimal lowerSalaryBoundary) {
        var total = BigDecimal.ZERO;
        var count = 0;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getSalary().compareTo(lowerSalaryBoundary) >= 0) {
                total = total.add(employees.get(i).getSalary());
                count++;
            }
        }
        return count != 0 ? total.divide(new BigDecimal(count)) : BigDecimal.ZERO;
    }

    public static BigDecimal calculateAverageInAModernFashion(final List<Employee> employees,
                                                              final BigDecimal lowerSalaryBoundary) {
        var pair = employees.stream()
                .map(employee -> employee.getSalary())
                .filter(salary -> salary.compareTo(lowerSalaryBoundary) >= 0)
                .map(salary -> new Pair<>(salary, BigDecimal.ONE))
                .reduce(new Pair<>(BigDecimal.ZERO, BigDecimal.ZERO),
                        (a, b) -> new Pair<>(a.getLeft().add(b.getLeft()), a.getRight().add(b.getRight())));

        return pair.getRight() != BigDecimal.ZERO ? pair.getLeft().divide(pair.getRight()) : BigDecimal.ZERO;
    }
}
