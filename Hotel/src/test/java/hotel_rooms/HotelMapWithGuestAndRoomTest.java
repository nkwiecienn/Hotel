package hotel_rooms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class HotelMapWithGuestAndRoomTest {

        Guest guest1, guest2, guest3;
        Room room1, room2, room3;
        HotelMap<Room, Guest> hotel;
    @BeforeEach
    public void beforeEach() {
        guest1 = new Guest("Natalia", "Kwiecien", 20);
        guest2 = new Guest("Oliwier", "Maj", 20);
        guest3 = new Guest("Jan", "Kusa", 20);

        room1 = new Room(101, "super room", 115);
        room2 = new Room(102, "very nice room", 120);
        room3 = new Room(103, "great room", 150);

        hotel = new HotelMap<>();
    }

    @Test
    public void shouldPutAndGetValues() {
        hotel.put(room1, guest1);

        assertEquals(hotel.get(room1), guest1);
    }

    @Test
    public void shouldListKeys() {
        hotel.put(room1);
        hotel.put(room2);
        hotel.put(room3);

        assertThat(hotel.keys()).containsExactly(room1, room2, room3);
    }

}
