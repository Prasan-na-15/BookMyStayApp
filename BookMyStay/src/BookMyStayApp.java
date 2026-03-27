import java.util.HashMap;
import java.util.Map;

public class RoomInventory {

    private Map<String, Integer> inventory;

    // Constructor: initialize inventory
    public RoomInventory() {
        inventory = new HashMap<>();

        // Initial room setup
        inventory.put("Deluxe", 5);
        inventory.put("Suite", 3);
        inventory.put("Standard", 10);
    }

    // Get availability
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    // Book room
    public boolean bookRoom(String roomType) {
        int available = getAvailability(roomType);

        if (available > 0) {
            inventory.put(roomType, available - 1);
            return true;
        }
        return false;
    }

    // Release room
    public void releaseRoom(String roomType) {
        inventory.put(roomType, getAvailability(roomType) + 1);
    }

    // Add/update room type
    public void setAvailability(String roomType, int count) {
        inventory.put(roomType, count);
    }

    // Display inventory
    public void displayInventory() {
        System.out.println("\nCurrent Inventory:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    // Main method (Flow execution)
    public static void main(String[] args) {

        // Step 1: Initialize system
        RoomInventory system = new RoomInventory();

        // Step 2: Show initial state
        system.displayInventory();

        // Step 3: Book a room
        System.out.println("\nBooking Deluxe...");
        if (system.bookRoom("Deluxe")) {
            System.out.println("Booking successful!");
        } else {
            System.out.println("No rooms available!");
        }

        // Step 4: Check availability
        System.out.println("Deluxe Available: " + system.getAvailability("Deluxe"));

        // Step 5: Add new room type (scalability)
        System.out.println("\nAdding Executive rooms...");
        system.setAvailability("Executive", 4);

        // Step 6: Release a room
        System.out.println("\nReleasing Deluxe...");
        system.releaseRoom("Deluxe");

        // Step 7: Final state
        system.displayInventory();
    }
}