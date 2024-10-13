import java.util.Scanner;

public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Room details (type, price, availability)
        String[] roomTypes = {"Single", "Double", "Suite"};
        double[] roomPrices = {100.0, 150.0, 350.0};
        boolean[] roomAvailability = {true, true, true}; // Initially all rooms are available

        // Maximum number of customers
        final int MAX_CUSTOMERS = 100; 
        String[] customerNames = new String[MAX_CUSTOMERS]; // To store customer names
        String[] bookedRoomTypes = new String[MAX_CUSTOMERS]; // To store booked room types
        double[] bookedRoomPrices = new double[MAX_CUSTOMERS]; // To store booked room prices
        int customerCount = 0; // To track the number of customers

        while (true) {
            // Display Options
            System.out.println("\nOptions:");
            System.out.println("1. Search Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View Bookings");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            // Search For Available Rooms
            if (choice == 1) {
                System.out.println("Available Rooms:");
                for (int i = 0; i < roomTypes.length; i++) {
                    if (roomAvailability[i]) {
                        System.out.println("Type: " + roomTypes[i] + ", Price: " + roomPrices[i]);
                    }
                }
            } 
            // To Make a Reservation
            else if (choice == 2) {
                if (customerCount >= MAX_CUSTOMERS) {
                    System.out.println("Sorry, all booking slots are full.");
                    continue;
                }

                System.out.print("Enter your name: ");
                String name = scanner.nextLine();

                System.out.print("Enter room type to book (Single/Double/Suite): ");
                String roomType = scanner.nextLine();
                
                boolean reservationMade = false;

                for (int j = 0; j < roomTypes.length; j++) {
                    if (roomTypes[j].equalsIgnoreCase(roomType) && roomAvailability[j]) {
                        // Make the reservation
                        roomAvailability[j] = false; 
                        customerNames[customerCount] = name; 
                        bookedRoomTypes[customerCount] = roomTypes[j]; 
                        bookedRoomPrices[customerCount] = roomPrices[j]; 
                        System.out.println("Booking successful! Room Type: " + roomTypes[j] + ", Price: " + roomPrices[j]);
                        customerCount++; 
                        reservationMade = true;
                        break;
                    }
                }
                if (!reservationMade) {
                    System.out.println("Sorry, no available rooms of type: " + roomType);
                }
            } 
            // To View Bookings
            else if (choice == 3) {
                System.out.println("Current Bookings: ");
                for (int i = 0; i < customerCount; i++) {
                    System.out.println("Name: " + customerNames[i] + ", Room Type: " + bookedRoomTypes[i] + ", Price: " + bookedRoomPrices[i]);
                }
            } 
            // To Exit
            else if (choice == 4) {
                System.out.println("Thank You For Visiting Us!");
                scanner.close();
                return;
            } 
            else {
                System.out.println("Invalid choice! Please try again later.");
            }
        }
    }
}
