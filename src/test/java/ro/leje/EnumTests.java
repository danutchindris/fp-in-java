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
}
