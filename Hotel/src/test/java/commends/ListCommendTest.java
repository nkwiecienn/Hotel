package commends;

import hotel_rooms.Guest;
import hotel_rooms.HotelConfiguration;
import hotel_rooms.HotelMap;
import hotel_rooms.Room;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ListCommendTest {

    HotelMap<Room, Guest> hotel;
    HotelConfiguration configuration;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

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
    }

    @Test
    void shouldListRooms() throws IOException {
        Commend commend = new Commend("list");
        commend.execute(hotel);

        assertEquals("101 102 103 104 \n", outContent.toString());
    }
}