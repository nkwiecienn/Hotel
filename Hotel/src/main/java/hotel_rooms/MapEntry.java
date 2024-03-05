package hotel_rooms;

public class MapEntry<K, V> {
    private final K key;
    private V value = null;

    public MapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public MapEntry(K key) {
        this.key = key;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void remove() {
        value = null;
    }
}
