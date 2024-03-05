package hotel_rooms;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class HotelMapTest {
    @Test
    public void shouldPutAndGetValues() {
        int a = 1;
        String a1 = "one";
        HotelMap<Integer, String> hotelMap = new HotelMap<>();

        hotelMap.put(a, a1);
        assertEquals(hotelMap.get(a), a1);
    }

    @Test
    public void shouldListKeys() {
        int a = 1, b = 2;
        String a1 = "one", b2 = "two";
        HotelMap<Integer, String> hotelMap = new HotelMap<>();

        hotelMap.put(a, a1);
        hotelMap.put(b, b2);

        assertThat(hotelMap.keys()).containsExactly(a, b);
    }

    @Test
    public void shouldListValues() {
        int a = 1, b = 2;
        String a1 = "one", b2 = "two";
        HotelMap<Integer, String> hotelMap = new HotelMap<>();

        hotelMap.put(a, a1);
        hotelMap.put(b, b2);

        assertThat(hotelMap.values()).containsExactly(a1, b2);
    }

    @Test
    public void shouldRemoveValue() {
        int a = 1, b = 2;
        String a1 = "one", b2 = "two";
        HotelMap<Integer, String> hotelMap = new HotelMap<>();

        hotelMap.put(a, a1);
        hotelMap.put(b, b2);

        hotelMap.remove(b);

        assertNull(hotelMap.get(b));
    }

}