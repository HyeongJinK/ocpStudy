package khj.study;


public class Melon implements Comparable {
    private final String type;
    private final int weight;

    public Melon(String type, int weight) {
        this.type = type;
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Object o) {
        Melon m = (Melon) o;

        return Integer.compare(this.getWeight(), m.getWeight());
    }

    // constructor, getters, equals() and hashCode() omitted for brevity
}
