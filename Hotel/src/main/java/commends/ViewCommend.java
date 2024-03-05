package commends;

import hotel_rooms.Guest;
import hotel_rooms.HotelMap;
import hotel_rooms.Room;

import java.util.Scanner;

public class ViewCommend extends Commend {

    public ViewCommend(String commendType) {
        super(commendType);
    }

    public void print(HotelMap<Room, Guest> hotel) {
        System.out.print("Enter room number:");
        Scanner in = new Scanner(System.in);
        int roomNumber = in.nextInt();
        Room room = this.contains(roomNumber, hotel);

        if(room == null)
            throw new IllegalArgumentException("This room doesn't exist");
        else {
            roomInformation(hotel, room);
        }
    }
}
