package khj.study;

public final class Pair<L, R> extends Tuple implements Comparable {

    final L left;
    final R right;

    public Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public class Entry<L, R> {}
}
