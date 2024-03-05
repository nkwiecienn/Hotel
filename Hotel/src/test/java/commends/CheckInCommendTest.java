package commends;

import hotel_rooms.Guest;
import hotel_rooms.HotelConfiguration;
import hotel_rooms.HotelMap;
import hotel_rooms.Room;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;

class CheckInCommendTest {
    HotelMap<Room, Guest> hotel;
    HotelConfiguration configuration;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    InputStream sysInBackup = System.in;

    @BeforeEach
    void beforeEach() {
        hotel = new HotelMap<>();
        configuration = new HotelConfiguration();

        configuration.configureFromFile(new File("src/main/resources/roomsCVSCommandTests.cvs"), hotel);

        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void afterEach() {
        System.setOut(originalOut);
        System.setIn(sysInBackup);
    }

    @Test
    void shouldCheckInNewGuest() throws IOException {
        Guest guest = new Guest("Klaudia", "Janiszewska", 20);

        ByteArrayInputStream in = new ByteArrayInputStream("104\nKlaudia\nJaniszewska\n20".getBytes());
        System.setIn(in);

        Commend commend = new Commend("checkin");
        commend.execute(hotel);

        assertEquals(hotel.values().get(3), guest);
    }

    @Test
    void shouldThrowExceptionRoomDoesntExist() {
        ByteArrayInputStream in = new ByteArrayInputStream("99\nKlaudia\nJaniszewska\n20".getBytes());
        System.setIn(in);

        Commend commend = new Commend("checkin");

        Throwable thrown = catchThrowable(() -> commend.execute(hotel));
        assertThat(thrown).hasMessageContaining("This room doesn't exist");
    }

    @Test
    void shouldThrowExceptionRoomIsNotFree() {
        ByteArrayInputStream in = new ByteArrayInputStream("101\nKlaudia\nJaniszewska\n20".getBytes());
        System.setIn(in);

        Commend commend = new Commend("checkin");

        Throwable thrown = catchThrowable(() -> commend.execute(hotel));
        assertThat(thrown).hasMessageContaining("This room isn't free");
    }
}