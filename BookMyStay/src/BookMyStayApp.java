/**
 * Book My Stay App - Room Initialization Demo (Single Class Version)
 * Demonstrates abstraction, inheritance, polymorphism, and encapsulation
 *
 * @author YourName
 * @version 1.1
 */
public class BookMyStayApp {

    // 🔹 Abstract Class
    static abstract class Room {

        private String type;
        private int beds;
        private double price;

        public Room(String type, int beds, double price) {
            this.type = type;
            this.beds = beds;
            this.price = price;
        }

        public String getType() {
            return type;
        }

        public int getBeds() {
            return beds;
        }

        public double getPrice() {
            return price;
        }

        // Abstract method
        public abstract void displayRoomDetails();
    }

    // 🔹 Single Room
    static class SingleRoom extends Room {

        public SingleRoom() {
            super("Single Room", 1, 1000);
        }

        @Override
        public void displayRoomDetails() {
            System.out.println("Room Type: " + getType());
            System.out.println("Beds: " + getBeds());
            System.out.println("Price: ₹" + getPrice());
        }
    }

    // 🔹 Double Room
    static class DoubleRoom extends Room {

        public DoubleRoom() {
            super("Double Room", 2, 1800);
        }

        @Override
        public void displayRoomDetails() {
            System.out.println("Room Type: " + getType());
            System.out.println("Beds: " + getBeds());
            System.out.println("Price: ₹" + getPrice());
        }
    }

    // 🔹 Suite Room
    static class SuiteRoom extends Room {

        public SuiteRoom() {
            super("Suite Room", 3, 3000);
        }

        @Override
        public void displayRoomDetails() {
            System.out.println("Room Type: " + getType());
            System.out.println("Beds: " + getBeds());
            System.out.println("Price: ₹" + getPrice());
        }
    }

    // 🔹 Main Method (Entry Point)
    public static void main(String[] args) {

        System.out.println("=== Book My Stay App ===");

        // Polymorphism: using Room reference
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Static availability variables
        int singleAvailability = 5;
        int doubleAvailability = 3;
        int suiteAvailability = 2;

        // Display room details
        System.out.println("\n--- Room Details ---");

        single.displayRoomDetails();
        System.out.println("Available: " + singleAvailability);

        System.out.println();

        doubleRoom.displayRoomDetails();
        System.out.println("Available: " + doubleAvailability);

        System.out.println();

        suite.displayRoomDetails();
        System.out.println("Available: " + suiteAvailability);
    }
}