package commends;

import hotel_rooms.Guest;
import hotel_rooms.HotelMap;
import hotel_rooms.Room;

import java.util.Scanner;

public class CheckOutCommend extends Commend{
    public CheckOutCommend(String commendType) {
        super(commendType);
    }

    public void print(HotelMap<Room, Guest> hotel) {
        System.out.print("Enter room number:");
        Scanner in = new Scanner(System.in);
        int roomNumber = in.nextInt();
        Room room = this.contains(roomNumber, hotel);

        if (room == null)
            throw new IllegalArgumentException("This room doesn't exist");
        else if (room.isFree())
            throw new IllegalArgumentException("This room is already free");
        else {
            room.setFree(true);
            hotel.remove(room);
        }
    }
}
