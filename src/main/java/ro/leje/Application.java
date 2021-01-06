package ro.leje;

import java.util.List;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        var list = List.of(7, 3, 8, 10, -2);

        var stream = list.stream()
                .filter(number -> number > 0)
                .map(number -> number / 2.0D);

        var newList = stream.collect(Collectors.toList());

        // forEach is a higher-order function
        newList.forEach(x -> System.out.println(x)); // think about functions as data
    }
}

// Streams are lazy

// FP = functions (higher-order) + lazy evaluation
