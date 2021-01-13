package ro.leje;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ro.leje.collection.Enum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class Student {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
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
}

public class EnumTests {

    @Test
    void testEach() {
        List<Integer> list = Arrays.asList(1, 2, 4, 2);
        List<Integer> original = new ArrayList<>(list);
        Enum.each(list, x -> {
            System.out.println(x);
            // TODO improve the function return type so that we're not forced to return null
            //  at the moment the situation is like this because the return type is Void
            return null;
        });
    }

    @Test
    void testEachDoesNotModifyElements() {
        List<Student> list = Arrays.asList(new Student("Ionel", 20), new Student("Ana", 21));
        List<Student> original = Arrays.asList(new Student("Ionel", 20), new Student("Ana", 21));
        Enum.each(list, x -> {
            // TODO how can we make sure that the function we pass to each() doesn't change the list at all?
            x.age += 1;
            return null;
        });
        Assertions.assertIterableEquals(original, list);
    }
}
