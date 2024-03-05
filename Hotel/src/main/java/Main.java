import commends.Commend;
import hotel_rooms.Guest;
import hotel_rooms.HotelConfiguration;
import hotel_rooms.HotelMap;
import hotel_rooms.Room;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        HotelMap<Room, Guest> hotel = new HotelMap<>();
        HotelConfiguration configuration = new HotelConfiguration();

        configuration.configureFromFile(new File("src/main/resources/roomsCVS.cvs"), hotel);

        Scanner in = new Scanner(System.in);

        System.out.println("Enter commend (list, view, checkin, chechout, listall, save, exit)");
        String commendType = "";

        while(!Objects.equals(commendType, "exit")) {
            commendType = in.next();
            Commend commend = new Commend(commendType);
            commend.execute(hotel);
        }
    }
}