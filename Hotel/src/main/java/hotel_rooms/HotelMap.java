package hotel_rooms;

import java.util.ArrayList;
import java.util.List;

public class HotelMap<K, V> {
    private final ArrayList<MapEntry<K,V>> rooms = new ArrayList<>();

    public void put(K key, V value) {
        for(MapEntry<K,V> r : rooms) {
            if(r.getKey() == key) {
                r.setValue(value);
                return;
            }
        }
        MapEntry<K, V> entry = new MapEntry<>(key, value);
        rooms.add(entry);
    }

    public void put(K key) {
        if(this.get(key) == null) {
            MapEntry<K, V> entry = new MapEntry<>(key);
            rooms.add(entry);
        }
    }

    public V get(K key) {
        for(MapEntry<K,V> r : rooms) {
            if(r.getKey() == key)
                return r.getValue();
        }
        return null;
    }

    public List<K> keys() {
        List<K> key = new ArrayList<>();

        for(MapEntry<K,V> r : rooms)
            key.add(r.getKey());

        return key;
    }

    public List<V> values() {
        List<V> value = new ArrayList<>();

        for(MapEntry<K,V> r : rooms)
            value.add(r.getValue());

        return value;
    }

    public void remove(K key) {
        for (MapEntry<K, V> room : rooms) {
            if (room.getKey() == key) {
                room.remove();
                return;
            }
        }
    }
}
