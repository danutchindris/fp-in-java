package ro.leje.function;

@FunctionalInterface
public interface Consumer<T> {

    void consume(T t);
}
