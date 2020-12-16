package ro.leje;

import ro.leje.domain.Employee;
import ro.leje.service.Average;

import java.math.BigDecimal;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        var employees = List.of(new Employee("Maria", new BigDecimal(2400)),
                new Employee("Ionut", new BigDecimal(2000)),
                new Employee("Ioana", new BigDecimal(1800)),
                new Employee("Ana", new BigDecimal(4500)),
                new Employee("Marian", new BigDecimal(3000))
        );
        // TODO write unit tests instead
        System.out.println("Media salariilor peste 2000 de lei: " + Average.calculateAverage(employees));
        System.out.println("Media salariilor peste 2000 de lei: " + Average.calculateAverageInAModernFashion(employees));
    }
}
