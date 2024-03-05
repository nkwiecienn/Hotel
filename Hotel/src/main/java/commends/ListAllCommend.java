package commends;

import hotel_rooms.Guest;
import hotel_rooms.HotelMap;
import hotel_rooms.Room;

public class ListAllCommend extends Commend {

    public ListAllCommend(String commendType) {
        super(commendType);
    }

    public void print(HotelMap<Room, Guest> hotel) {
        for(Room room : hotel.keys()) {
            System.out.println("Room " + room.getRoomNumber() + ":");
            roomInformation(hotel, room);
            System.out.print("\n");
        }
    }

}
