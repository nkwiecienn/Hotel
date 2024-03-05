package commends;

import hotel_rooms.Guest;
import hotel_rooms.HotelMap;
import hotel_rooms.Room;

import java.util.Scanner;

public class CheckInCommend extends Commend {
    public CheckInCommend(String commendType) {
        super(commendType);
    }

    public void print(HotelMap<Room, Guest> hotel) {
        System.out.print("Enter room number:");
        Scanner in = new Scanner(System.in);
        int roomNumber = in.nextInt();
        Room room = this.contains(roomNumber, hotel);

        if (room == null)
            throw new IllegalArgumentException("This room doesn't exist");
        else if (!room.isFree())
            throw new IllegalArgumentException("This room isn't free");
        else {
            System.out.print("Enter first name: ");
            String firstName = in.next();
            System.out.print("Enter second name: ");
            String secondName = in.next();
            System.out. print("Enter your age: ");
            int age = in.nextInt();

            Guest guest = new Guest(firstName, secondName, age);
            room.setFree(false);
            hotel.put(room, guest);
        }
    }
}
