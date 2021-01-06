package ro.leje;

import java.util.List;

public class BiFunctionExample {

    public static void main(String[] args) {

        // we want to calculate the list's elements product
        var list = List.of(7, 3, 8, 10, -2);

        var product = list.stream()
                .reduce(1, (x, y) -> x * y);
        // 1 (identity) is the neutral element for the "product" operation

        System.out.println("Product: " + product);
    }
}
