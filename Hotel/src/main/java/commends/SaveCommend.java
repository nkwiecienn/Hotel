package commends;

import hotel_rooms.Guest;
import hotel_rooms.HotelMap;
import hotel_rooms.Room;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SaveCommend extends Commend {
    public SaveCommend(String commendType) {
        super(commendType);
    }

    public void print(HotelMap<Room, Guest> hotel) throws IOException {

        FileWriter file = new FileWriter("src/main/resources/roomsCVS.cvs");

        PrintWriter out = new PrintWriter(file);

        out.println("roomNumber;description;price;free;firstName;secondName;Age");

        for(Room room : hotel.keys()) {
            out.print(room.getRoomNumber() + ";" + room.getDescription() + ";" + room.getPrice() + ";");

            if(hotel.get(room) == null)
                out.print("1;;;\n");
            else {
                Guest guest = hotel.get(room);
                out.print("0;" + guest.getFirstName() + ";" + guest.getSecondName() + ";" + guest.getAge() + "\n");
            }
        }

        file.close();
    }
}
