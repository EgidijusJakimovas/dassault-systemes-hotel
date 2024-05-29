import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HotelManagement hotelManagement = new HotelManagement(6, 20.0);
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nMENU:");
            System.out.println("1. Register Guest");
            System.out.println("2. Check-out Guest");
            System.out.println("3. Review Standard and Business Class Room Availability");
            System.out.println("4. Room Occupancy History and Status");
            System.out.println("5. Room Occupancy Report");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter guest's name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter guest's surname: ");
                    String surname = scanner.nextLine();
                    hotelManagement.registerGuest(name, surname);
                    break;
                case 2:
                    System.out.print("Enter room number to check-out: ");
                    int roomNumber = scanner.nextInt();
                    hotelManagement.checkoutGuest(roomNumber);
                    break;
                case 3:
                    System.out.println("Standard Class Rooms:");
                    hotelManagement.displayRoomAvailability(0, hotelManagement.getTOTAL_ROOMS() / 2);
                    System.out.println("Business Class Rooms:");
                    hotelManagement.displayRoomAvailability(hotelManagement.getTOTAL_ROOMS() / 2, hotelManagement.getTOTAL_ROOMS());
                    break;
                case 4:
                    hotelManagement.displayRoomOccupancyHistory();
                    break;
                case 5:
                    hotelManagement.displayRoomOccupancyReport();
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 0 and 5.");
            }
        } while (choice != 0);
        scanner.close();
    }
}
