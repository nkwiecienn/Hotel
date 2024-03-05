package commends;

import hotel_rooms.Guest;
import hotel_rooms.HotelMap;
import hotel_rooms.Room;

import java.io.IOException;

public class Commend {
    String commendType;

    public Commend(String commendType) {
        this.commendType = commendType;
    }

    public void execute(HotelMap<Room, Guest> hotel) throws IOException {
        switch (commendType) {
            case "list":
                ListCommend listCommend = new ListCommend(commendType);
                listCommend.print(hotel);
                break;
            case "view":
                ViewCommend viewCommend = new ViewCommend(commendType);
                viewCommend.print(hotel);
                break;
            case "checkin":
                CheckInCommend checkInCommend = new CheckInCommend(commendType);
                checkInCommend.print(hotel);
                break;
            case "checkout":
                CheckOutCommend checkOutCommend = new CheckOutCommend(commendType);
                checkOutCommend.print(hotel);
                break;
            case "listall":
                ListAllCommend listAllCommend = new ListAllCommend(commendType);
                listAllCommend.print(hotel);
                break;
            case "save":
                SaveCommend saveCommend = new SaveCommend(commendType);
                saveCommend.print(hotel);
                break;
            case "exit":
                System.exit(0);
            default:
                System.out.println("Unknown commend");
                break;
        }
    }

    Room contains(int roomNumber, HotelMap<Room, Guest> hotel) {
        for (Room room : hotel.keys()) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    static void roomInformation(HotelMap<Room, Guest> hotel, Room room) {
        System.out.println("Price " + room.getPrice());
        System.out.println("Description: " + room.getDescription());

        if (room.isFree())
            System.out.println("This room is free");
        else {
            Guest guest = hotel.get(room);
            System.out.println("Guest: " + guest.getFirstName() + " " + guest.getSecondName() + " age: "
                    + guest.getAge());
        }
    }
}
