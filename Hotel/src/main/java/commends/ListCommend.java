package commends;

import hotel_rooms.Guest;
import hotel_rooms.HotelMap;
import hotel_rooms.Room;

public class ListCommend extends Commend {

    public ListCommend(String commendType) {
        super(commendType);
    }

    public void print(HotelMap<Room, Guest> hotel) {
        for(Room room : hotel.keys()) {
            System.out.print(room.getRoomNumber() + " ");
        }
        System.out.print("\n");
    }
}
