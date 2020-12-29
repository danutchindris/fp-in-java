package ro.leje;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ro.leje.domain.Employee;
import ro.leje.service.Average;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationTests {

    private static final List<Employee> employees = List.of(
            new Employee("Alex", new BigDecimal(-100000)),
            new Employee("Maria", new BigDecimal(2400)),
            new Employee("Ionut", new BigDecimal(2000)),
            new Employee("Ioana", new BigDecimal(1800)),
            new Employee("Ana", new BigDecimal(4500)),
            new Employee("Marian", new BigDecimal(3000)),
            new Employee("Alex", new BigDecimal(0))
    );

    @Test
    void imperativeAverage() {
        assertEquals(BigDecimal.valueOf(2975), Average.calculateAverage(employees, BigDecimal.valueOf(2000)));
    }

    @Test
    void declarativeAverage() {
        assertEquals(BigDecimal.valueOf(2975), Average.calculateAverageInAModernFashion(employees, BigDecimal.valueOf(2000)));
    }

    @Test
    @DisplayName("1 + 1 = 2")
    void addsTwoNumbers() {
        assertEquals(2, 1 + 1, "1 + 1 should equal 2");
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,    1,   1",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101"
    })
    void add(int first, int second, int expectedResult) {
        assertEquals(expectedResult, first + second,
                () -> first + " + " + second + " should equal " + expectedResult);
    }
}
