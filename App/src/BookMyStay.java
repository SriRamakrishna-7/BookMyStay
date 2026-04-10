import java.util.HashMap;
import java.util.Map;

// RoomInventory class (Core logic)
class RoomInventory {

    // HashMap to store room type -> available count
    private HashMap<String, Integer> inventory;

    // Constructor (Initialize inventory)
    public RoomInventory() {
        inventory = new HashMap<>();
    }

    // Register a room type with count
    public void addRoomType(String roomType, int count) {
        inventory.put(roomType, count);
    }

    // Get availability of a room type
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    // Update availability (e.g., booking or cancellation)
    public void updateAvailability(String roomType, int change) {
        if (inventory.containsKey(roomType)) {
            int current = inventory.get(roomType);
            int updated = current + change;

            if (updated >= 0) {
                inventory.put(roomType, updated);
            } else {
                System.out.println("Not enough rooms available for: " + roomType);
            }
        } else {
            System.out.println("Room type not found: " + roomType);
        }
    }

    // Display full inventory
    public void displayInventory() {
        System.out.println("\nCurrent Room Inventory:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}


// Main class
public class UseCase3InventorySetup {

    public static void main(String[] args) {

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Register room types
        inventory.addRoomType("Single", 10);
        inventory.addRoomType("Double", 5);
        inventory.addRoomType("Suite", 2);

        // Display initial inventory
        inventory.displayInventory();

        // Simulate booking
        System.out.println("\nBooking 2 Single rooms...");
        inventory.updateAvailability("Single", -2);

        // Simulate cancellation
        System.out.println("\nCancelling 1 Double room...");
        inventory.updateAvailability("Double", +1);

        // Check availability
        System.out.println("\nAvailable Suites: " + inventory.getAvailability("Suite"));

        // Display updated inventory
        inventory.displayInventory();
    }
}