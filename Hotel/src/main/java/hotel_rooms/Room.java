package hotel_rooms;

import java.util.Objects;

public class Room {
    private final int roomNumber;
    private final int floor;
    private final String description;
    private final int price;
    private boolean free = true; //true jeśli jest wolny

    public Room(int roomNumber, String description, int price) {
        this.roomNumber = roomNumber;
        this.description = description;
        this.price = price;
        this.floor = roomNumber / 100;
    }

    public boolean isFree() {
        return free;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return roomNumber == room.roomNumber && floor == room.floor && price == room.price && free == room.free && Objects.equals(description, room.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber, floor, description, price, free);
    }
}
