package interfaces;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Clinic implements Iterable{
    private int numberOfRooms;
    private String name;
    private List<Room> rooms;

    public Clinic(String name, int numberOfRooms) {
        this.setNumberOfRooms(numberOfRooms);
        this.setRooms(numberOfRooms);
        this.name = name;
    }

    private void setNumberOfRooms(int numberOfRooms) {
        if (numberOfRooms % 2 == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        }
        this.numberOfRooms = numberOfRooms;
    }

    private void setRooms(int capacity) {
        this.rooms = new ArrayList<>(capacity);
        for (int i = 0; i < this.numberOfRooms; i++) {
            this.rooms.add(i, new Room());
        }
    }

    public boolean addPet(Pet p) {
        for (Object o : this) {
            Room r = (Room) o;
            if (r.isEmpty()) {
                r.addPet(p);
                return true;
            }
        }
        return false;
    }

    public boolean hasEmptyRooms() {
        for (Room room : rooms) {
            if (room.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public String print() {
        StringBuilder result = new StringBuilder();
        for (Room room : this.rooms) {
            result.append(room).append(System.lineSeparator());
        }
        return result.toString().trim();
    }

    public String print(int indexRoom) {
        return this.rooms.get(indexRoom - 1).toString();
    }

    public boolean release() {
        int startIndex = 0;
        if (numberOfRooms != 1) {
            startIndex = numberOfRooms / 2;
        }
        for (int i = startIndex; i < this.rooms.size(); i++) {
            Room currentRoom = this.rooms.get(i);
            if (!currentRoom.isEmpty()) {
                currentRoom.release();
                return true;
            }
        }
        for (int i = 0; i < startIndex; i++) {
            Room currentRoom = this.rooms.get(i);
            if (!currentRoom.isEmpty()) {
                currentRoom.release();
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return new ClinicIterator();
    }

    private final class ClinicIterator implements Iterator {
        private int index;
        private boolean minus;
        private int counter;

        private ClinicIterator() {
            if (numberOfRooms == 1) {
                this.index = 0;
            } else {
                this.index = numberOfRooms / 2;
            }
            this.minus = false;
            this.counter = 0;
        }

        @Override
        public boolean hasNext() {
            return this.counter < rooms.size();
        }

        @Override
        public Room next() {
            int currentIndex = this.index;
            if (this.minus) {
                this.minus = false;
                this.index -= this.counter;
                return rooms.get(currentIndex  - this.counter++);
            } else {
                this.minus = true;
                this.index += this.counter;
                return rooms.get(currentIndex  + this.counter++);
            }
        }
    }
}
