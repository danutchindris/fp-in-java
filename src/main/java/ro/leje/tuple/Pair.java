package ro.leje.tuple;

public class Pair<U, V> {

    private final U left;
    private final V right;

    public Pair(U left, V right) {
        this.left = left;
        this.right = right;
    }

    public U getLeft() {
        return left;
    }

    public V getRight() {
        return right;
    }
}
