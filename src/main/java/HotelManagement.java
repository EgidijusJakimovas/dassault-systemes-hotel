import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class HotelManagement {
    private final List<Room> rooms;
    private final Map<Integer, Integer> roomOccupancy;
    private final int TOTAL_ROOMS;
    private final double STANDARD_ROOM_PRICE;

    public HotelManagement(int totalRooms, double standardRoomPrice) {
        this.TOTAL_ROOMS = totalRooms;
        this.STANDARD_ROOM_PRICE = standardRoomPrice;
        rooms = new ArrayList<>();
        roomOccupancy = new HashMap<>();
        initializeRooms();
    }

    private void initializeRooms() {
        double businessClassPriceMultiplier = 1.5;
        int roomsInEachClass = TOTAL_ROOMS / 2;

        for (int i = 1; i <= roomsInEachClass; i++) {
            rooms.add(new Room(i, STANDARD_ROOM_PRICE));
        }

        for (int i = roomsInEachClass + 1; i <= TOTAL_ROOMS; i++) {
            rooms.add(new BusinessRoom(i, STANDARD_ROOM_PRICE * businessClassPriceMultiplier));
        }
    }

    public void registerGuest(String name, String surname) {
        Room availableRoom = findAvailableRoom();
        if (availableRoom != null) {
            Guest guest = new Guest(name, surname);
            availableRoom.setGuest(guest);
            int roomNumber = availableRoom.getNumber();
            roomOccupancy.put(roomNumber, roomOccupancy.getOrDefault(roomNumber, 0) + 1);
            // Add occupancy history
            availableRoom.addOccupancyHistory(new RoomOccupancyHistory(name, surname, LocalDateTime.now().toString(), null));
            System.out.println("Guest " + name + " " + surname + " registered in room number " + roomNumber);
        } else {
            System.out.println("Sorry, no available rooms.");
        }
    }

    public void checkoutGuest(int roomNumber) {
        for (Room room : rooms) {
            if (room.getNumber() == roomNumber && room.isOccupied()) {
                room.setGuest(null);
                System.out.println("Guest checked out from room number " + roomNumber);
                // Update occupancy history
                room.getOccupancyHistory().getLast().setCheckOutDate(LocalDateTime.now().toString());
                return;
            }
        }
        System.out.println("Room " + roomNumber + " is not occupied.");
    }

    public void displayRoomAvailability(int startIndex, int endIndex) {
        for (int i = startIndex; i < endIndex; i++) {
            Room room = rooms.get(i);
            if (!room.isOccupied()) {
                System.out.println("Room " + room.getNumber() + " - Free");
            } else {
                System.out.println("Room " + room.getNumber() + " - Occupied by: " + room.getGuest().getName() + " " + room.getGuest().getSurname());
            }
        }
    }

    public void displayRoomOccupancyReport() {
        System.out.println("Room occupancy report:");
        if (roomOccupancy.isEmpty()) {
            System.out.println("No history to display yet.");
        } else {
            roomOccupancy.entrySet().stream()
                    .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                    .forEach(entry -> {
                        int roomNumber = entry.getKey();
                        int occupancyCount = entry.getValue();
                        double profit = occupancyCount * getRoomPrice(roomNumber);
                        System.out.println("Room " + roomNumber + ": Occupied " + occupancyCount + " times, Profit: " + profit + " EUR");
                    });
        }
    }

    private Room findAvailableRoom() {
        for (Room room : rooms) {
            if (!room.isOccupied()) {
                return room;
            }
        }
        return null;
    }

    private double getRoomPrice(int roomNumber) {
        for (Room room : rooms) {
            if (room.getNumber() == roomNumber) {
                return room.getPrice();
            }
        }
        return 0.0;
    }

    public void displayRoomOccupancyHistory() {
        System.out.println("Room occupancy history:");
        for (Room room : rooms) {
            if (!room.getOccupancyHistory().isEmpty()) {
                System.out.println("Room " + room.getNumber() + " - Occupancy History:");
                for (RoomOccupancyHistory history : room.getOccupancyHistory()) {
                    System.out.println("Guest: " + history.getGuestName() + " " + history.getGuestSurname() + ", Check-in: " + history.getCheckInDate() + ", Check-out: " + (history.getCheckOutDate() != null ? history.getCheckOutDate() : "Still Occupied"));
                }
            } else {
                System.out.println("Room " + room.getNumber() + " - No occupancy history.");
            }
        }
    }
}
