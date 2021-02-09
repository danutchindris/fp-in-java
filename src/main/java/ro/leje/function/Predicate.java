package ro.leje.function;

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T element);
}
