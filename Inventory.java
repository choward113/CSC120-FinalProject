import java.util.ArrayList;

/**An Inventory class represents an inventory that can hold multiple Item objects*/
public class Inventory {
    
    private ArrayList<Item> inventory;

    /**Default constructor, initializes an empty ArrayList of Items*/
    public Inventory() {
        this.inventory = new ArrayList<Item>();
    }

    /**
     * Accessor for inventory
     * @return The current inventory
     */
    public ArrayList<Item> getItems() {
        return this.inventory;
    }

    /**
     * Removes an item with a given name from the inventory
     * @param name The name of the item
     * @return The item to be removed
     */
    public Item removeItem(String name) {
        Item itemToRemove = null;
        for (Item item : inventory) {
            if (item.getName().equals(name)) {
                itemToRemove = item;
                inventory.remove(item); 
                break;
            }
        }
        return itemToRemove;
    }

    /**
     * Returns the string representation of the inventory
     * @return The string representation of the inventory
     */
    public String printInventory() {
        String entireInventory = "You currently have:\n";
        for (int i = 0; i < this.inventory.size(); i++) {
            entireInventory += "+ "+this.inventory.get(i).getName().toLowerCase()+"\n";
        }
        return entireInventory;
    }
    
    /**
     * Checks if an item is a premade item
     * @param name The name of the item
     * @return The item if it's in the inventory, null otherwise
     */
    public Item contains(String name) {
        for (Item item : Item.getPremadeItems()) {
            if (item.getName().equals(name)) { 
                return item;
            }
        }
        return null;
    }

    /**
     * Adds item from a location to the inventory
     * @param name The name of the item
     * @param currentLocation The location of the person
     * @return The name of the item
     */
    public String addItem(String name, Location currentLocation) {
        Item itemToAdd = currentLocation.contains(name);
        if (itemToAdd != null) {
            this.inventory.add(itemToAdd);
            return itemToAdd.getName();
        }
        throw new RuntimeException("Item with name " + name + " not found.");
    }
}