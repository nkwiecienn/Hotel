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

class CheckOutCommendTest {
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
        ByteArrayInputStream in = new ByteArrayInputStream("101".getBytes());
        System.setIn(in);

        Commend commend = new Commend("checkout");
        commend.execute(hotel);

        assertNull(hotel.values().get(0));
    }

    @Test
    void shouldThrowExceptionRoomDoesntExist() {
        ByteArrayInputStream in = new ByteArrayInputStream("99".getBytes());
        System.setIn(in);

        Commend commend = new Commend("checkout");

        Throwable thrown = catchThrowable(() -> commend.execute(hotel));
        assertThat(thrown).hasMessageContaining("This room doesn't exist");
    }

    @Test
    void shouldThrowExceptionRoomIsFree() {
        ByteArrayInputStream in = new ByteArrayInputStream("104".getBytes());
        System.setIn(in);

        Commend commend = new Commend("checkout");

        Throwable thrown = catchThrowable(() -> commend.execute(hotel));
        assertThat(thrown).hasMessageContaining("This room is already free");
    }

}