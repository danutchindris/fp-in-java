package ro.leje.collection;

import ro.leje.function.BiFunction;
import ro.leje.function.Consumer;
import ro.leje.function.Function;
import ro.leje.function.Predicate;

import java.util.ArrayList;
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
    public static <T> void each(final Iterable<T> list, final Consumer<T> f) {
        for (T element : list) {
            f.consume(element);
        }
    }

    /**
     * @param iterable
     * @param function
     * @param <T>
     * @param <R>
     * @return An ordered iterable
     */
    public static <T, R> Iterable<R> map(final Iterable<T> iterable, final Function<T, R> function) {
        final List<R> newIterable = new ArrayList<>();
        for (T element : iterable) {
            newIterable.add(function.apply(element));
        }
        return newIterable;
    }

    public static <T> Iterable<T> filter(final Iterable<T> iterable, final Predicate<T> predicate) {
        List<T> newIterable = new ArrayList<>();
        for (T element : iterable) {
            if (predicate.test(element)) {
                newIterable.add(element);
            }
        }
        return newIterable;
    }

    public static <T, R> R reduce(final Iterable<T> iterable, final R zero, final BiFunction<T, R, R> function) {
        R accumulator = zero;
        for (T element : iterable) {
            accumulator = function.apply(element, accumulator);
        }
        return accumulator;
    }
}
