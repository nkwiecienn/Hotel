package hotel_rooms;

import java.io.*;

public class HotelConfiguration {
    public void configureFromFile(File file, HotelMap<Room, Guest> hotel) {

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");

                int roomNumber = Integer.parseInt(values[0]);
                String description = values[1];
                int price = Integer.parseInt(values[2]);
                int free = Integer.parseInt(values[3]);

                Room room = new Room(roomNumber, description, price);

                if(free == 0) {
                    String firstName = values[4];
                    String secondName = values[5];
                    int age = Integer.parseInt(values[6]);
                    Guest guest = new Guest(firstName, secondName, age);
                    room.setFree(false);
                    hotel.put(room, guest);
                }
                else
                    hotel.put(room);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
