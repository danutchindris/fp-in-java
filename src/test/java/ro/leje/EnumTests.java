package ro.leje;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ro.leje.collection.Enum;
import ro.leje.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EnumTests {

    @Test
    void testEach() {
        List<Integer> list = Arrays.asList(1, 2, 4, 2);
        List<Integer> original = new ArrayList<>(list);
        Enum.each(list, x -> System.out.println(x));
    }

    @Test
    void testEachDoesNotModifyElements() {
        final List<Student> list = Arrays.asList(new Student("Ionel", 20), new Student("Ana", 21));
        final List<Student> original = Arrays.asList(new Student("Ionel", 20), new Student("Ana", 21));
        Enum.each(list, element -> System.out.println(element));
        Assertions.assertIterableEquals(original, list);
    }

    @Test
    void testMap() {
        final Map<Integer, Student> students = Map.of(
                1, new Student("Ionel", 20),
                2, new Student("Ana", 21)
        );
        Enum.each(students.entrySet(), x -> System.out.println(x.getValue().getName()));
    }

    @Test
    void testMapMethod() {
        var list = Enum.map(
                List.of(new Student("Ionel", 20), new Student("Ana", 21)),
                student -> student.getName()
        );
        Assertions.assertIterableEquals(List.of("Ionel", "Ana"), list);
    }

    @Test
    void testMapMethodWithSet() {
        var returnedIterable = Enum.map(
                new LinkedHashSet<>(List.of(new Student("Ionel", 20), new Student("Ana", 21))),
                student -> student.getName()
        );
        Assertions.assertIterableEquals(List.of("Ionel", "Ana"), returnedIterable);
    }

    @Test
    void testFilterMethodReturningEvenNumbers() {
        var returnedNumbers = Enum.filter(
                List.of(6, 9, 12, 44, 21, 10, 33),
                number -> number % 2 == 0
        );
        Assertions.assertIterableEquals(List.of(6, 12, 21, 44, 10), returnedNumbers);
    }

    @Test
    void testFilterMethodWithHashSets() {
        var firstHashSet = new HashSet<Integer>();
        firstHashSet.add(2);
        firstHashSet.add(6);
        firstHashSet.add(7);
        firstHashSet.add(9);

        var secondHashSet = new HashSet<Integer>();
        secondHashSet.add(7);
        secondHashSet.add(2);
        secondHashSet.add(9);
        secondHashSet.add(6);

        Assertions.assertIterableEquals(firstHashSet, secondHashSet);
    }

    @Test
    void testEqualsLists() {
        var firstList = List.of(2, 6, 7, 9);

        var secondList = List.of(7, 9, 2, 6);

        Assertions.assertIterableEquals(firstList, secondList);
    }

    @Test
    void testSumWithReduceFunction() {
        var list = List.of(1, 2, 5, 6, 9);
        var result = Enum.reduce(list, 0, (nr, acc) -> nr + acc);

        Assertions.assertEquals(23, result);
    }

    @Test
    void testProductWithReduceFunction() {
        var list = List.of(1, 2, 5, 6, 9);
        var result = Enum.reduce(list, 1, (nr, acc) -> nr * acc);

        Assertions.assertEquals(540, result);
    }

    @Test
    void testConcatenationWithReduceFunction() {
        var list = List.of("1", "2", "5", "6", "9");
        var result = Enum.reduce(list, "", (str, acc) -> acc + str);

        Assertions.assertEquals("12569", result);
    }

    @Test
    void testEmptyListWithReduceFunction() {
        List<Integer> list = List.of();
        var result = Enum.reduce(list, 0, (nr, acc) -> nr + acc);

        Assertions.assertEquals(0, result);
    }
}
