package ro.leje;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ro.leje.collection.Enum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Immutable data structure
 */
class Student {

    private final String name;
    private final int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return name + " " + age;
    }
}

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
}
