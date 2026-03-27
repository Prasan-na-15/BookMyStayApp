import java.util.HashMap;
import java.util.Map;

public class RoomSystem {

    // -------------------------------
    // Room Domain Model
    // -------------------------------
    static class Room {
        String type;
        double price;
        String amenities;

        Room(String type, double price, String amenities) {
            this.type = type;
            this.price = price;
            this.amenities = amenities;
        }

        void displayDetails() {
            System.out.println("Type: " + type +
                    ", Price: $" + price +
                    ", Amenities: " + amenities);
        }
    }

    // -------------------------------
    // Centralized Inventory (State)
    // -------------------------------
    private Map<String, Integer> inventory = new HashMap<>();

    // Room details storage (Domain layer)
    private Map<String, Room> roomCatalog = new HashMap<>();

    // Constructor: initialize system
    public RoomSystem() {

        // Inventory setup
        inventory.put("Deluxe", 5);
        inventory.put("Suite", 0);       // unavailable
        inventory.put("Standard", 10);

        // Room details setup
        roomCatalog.put("Deluxe", new Room("Deluxe", 120.0, "WiFi, TV, Mini Bar"));
        roomCatalog.put("Suite", new Room("Suite", 250.0, "WiFi, TV, Jacuzzi"));
        roomCatalog.put("Standard", new Room("Standard", 80.0, "WiFi, TV"));
    }

    // -------------------------------
    // Read-Only Search Logic
    // -------------------------------
    public void searchAvailableRooms() {

        System.out.println("\nAvailable Rooms:\n");

        for (String roomType : inventory.keySet()) {

            int available = inventory.get(roomType);

            // Validation: skip unavailable rooms
            if (available <= 0) {
                continue;
            }

            // Defensive check
            Room room = roomCatalog.get(roomType);
            if (room == null) {
                continue;
            }

            // Display room details
            room.displayDetails();
            System.out.println("Available Count: " + available);
            System.out.println("------------------------");
        }
    }

    // -------------------------------
    // Booking Logic (Separate Concern)
    // -------------------------------
    public void bookRoom(String roomType) {
        int available = inventory.getOrDefault(roomType, 0);

        if (available > 0) {
            inventory.put(roomType, available - 1);
            System.out.println("Booked: " + roomType);
        } else {
            System.out.println("No availability for: " + roomType);
        }
    }

    // -------------------------------
    // Main Flow (Guest Interaction)
    // -------------------------------
    public static void main(String[] args) {

        RoomSystem system = new RoomSystem();

        // Step 1: Guest searches rooms (READ-ONLY)
        system.searchAvailableRooms();

        // Step 2: Booking happens separately
        System.out.println("\nBooking Deluxe...");
        system.bookRoom("Deluxe");

        // Step 3: Search again (updated view)
        system.searchAvailableRooms();
    }
}