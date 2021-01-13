package ro.leje.collection;

import ro.leje.function.Function;

import java.util.List;

/**
 * The Enum class contains utility methods which are higher-order functions.
 * Its methods are generic (they have a generic behavior).
 * The methods' first parameter is a collection (for now let's deal only with lists).
 * This collections shouldn't be modified at all by the methods we pass it to.
 * We want our data structures to be immutable.
 * Usually, the methods in this class return a new collection.
 */
public class Enum {

    /**
     * This method iterates over the list passed as first parameter and applies the function passed as
     * second parameter to each element.
     *
     * @param list The list we want to iterate over
     * @param f    The function we want to apply to each element in the list
     * @param <T>  The elements we work with are of a generic type
     */
    public static <T> void each(final List<T> list, Function<T, Void> f) {
        for (T element : list) {
            f.apply(element);
        }
    }

    // TODO: map
    // TODO: filter
    // TODO: reduce
}
