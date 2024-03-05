package hotel_rooms;

import org.junit.jupiter.api.Test;
import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

class HotelConfigurationTest {
    @Test
    public void shouldAddRoomsFromFileWithoutGuests() {
        Room room1 = new Room(101, "super room", 115);
        Room room2 = new Room(102, "very nice room", 120);
        Room room3 = new Room(103, "great room", 150);
        Room room4 = new Room(104, "mid room", 90);

        HotelMap<Room, Guest> hotel = new HotelMap<>();
        HotelConfiguration configuration = new HotelConfiguration();

        configuration.configureFromFile(new File("src/main/resources/roomsCVSTestWithoutGuests.csv"), hotel);

        assertThat(hotel.keys()).containsExactly(room1, room2, room3, room4);
    }

    @Test
    public void shouldAddRoomsAndGuests() {
        Room room1 = new Room(101, "super room", 115);
        Room room2 = new Room(102, "very nice room", 120);
        Room room3 = new Room(103, "great room", 150);
        room1.setFree(false);
        room2.setFree(false);
        room3.setFree(false);

        Guest guest1 = new Guest("Oliwier", "Maj", 20);
        Guest guest2 = new Guest("Natalia", "Kwiecien", 20);
        Guest guest3 = new Guest("Jan", "Kusa", 20);

        HotelMap<Room, Guest> hotel = new HotelMap<>();
        HotelConfiguration configuration = new HotelConfiguration();

        configuration.configureFromFile(new File("src/main/resources/roomsCVSTestGuests.cvs"), hotel);

        assertThat(hotel.keys()).containsExactly(room1, room2, room3);
        assertThat(hotel.values()).containsExactly(guest1, guest2, guest3);
    }
}