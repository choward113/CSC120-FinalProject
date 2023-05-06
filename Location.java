import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;

/**A Location class representing a location that can contain items and have them added and removed*/
public class Location {

    private final String name;
    private final String description;
    private ImmutableMap<String, Location> exits;
    private ArrayList<Item> items;

    /**
     * Constructor for Location class
     * @param name The name of the location
     * @param description The description of the location
     * @param exits ImmutableMap that represents the exits of the location
     */
    public Location(String name, String description, ImmutableMap<String, Location> exits) {
        this.name = name;
        this.description = description;
        this.exits = exits;
        this.items = new ArrayList<>();
    }

    /**
     * Accessor for name
     * @return The name of the location
     */
    public String getName() {
        return this.name;
    }

    /**
     * Accessor for description
     * @return The description of the location
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Accessor for exits
     * @return ImmutableMap that represents the exits of the location
     */
    public ImmutableMap<String, Location> getExits() {
        return this.exits;
    }

    /**
     * Returns the location in the given direction
     * @param direction The direction of the exit
     * @return The location in a given direction
     */
    public Location getExit(String direction) {
        return this.exits.get(direction);
    }

    /**
     * Accessor for items
     * @return ArrayList of Items in the location
     */
    public ArrayList<Item> getItems() {
        return items;
    }
    
    /**
     * Mutator for exits
     * @param exits ImmutableMap that represents the exits of the location
     */
    public void setExits(ImmutableMap<String, Location> exits) {
        if (exits == null) {
            throw new IllegalArgumentException("Exits cannot be null");
        }
        this.exits = exits;
    }
    
    /**
     * Returns a string representation of the items in a location
     * @return A string representation of the items in a location
     */
    public String getItemsString() {
        String itemStringDescriptions = "You can see a";
        for (int i = 0; i < this.items.size(); i++) {
            String itemName = this.items.get(i).getName().toLowerCase();
            if (i == this.items.size() - 1) {
                itemStringDescriptions += (" and " + itemName);
            } else {
                itemStringDescriptions += (" " + itemName + ",");
            }
        }
        return itemStringDescriptions;
    }

    /**
     * Adds an item to the location
     * @param item The item to be added
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * Removes item from the location
     * @param item The item to be removed
     */
    public void removeItem(Item item) {
        items.remove(item);
    }

    /**
     * Checks if location contains an Item with a given name
     * @param name The name of the itme
     * @return The item with a given name, or null if the item is not found
     */
    public Item contains(String name){
        Item newItem = null;
        for (Item item : this.items) {
            if (item.getName().equals(name)) { 
                newItem = item;
                break;
            } 
        } 
        return newItem;
    }

    /**
     * Returns a string representation of the items in the current location
     * @return A string representation of the items in the location
     */
    public String printInventory() {
        String entireInventory = "This room has:\n";
        for (int i = 0; i < this.items.size(); i++) {
            entireInventory += "+ " + this.items.get(i).getName().toLowerCase() + "\n";
        }
        return entireInventory;
    }
}
