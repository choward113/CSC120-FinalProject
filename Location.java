import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;

public class Location {

    private final String name;
    private final String description;
    private ImmutableMap<String, Location> exits;
    private ArrayList<Item> items;
    private String itemsDescription;

    public Location(String name, String description, ImmutableMap<String, Location> exits) {
        this.name = name;
        this.description = description;
        this.exits = exits;
        this.items = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    //Returns all exits
    public ImmutableMap<String, Location> getExits() {
        return exits;
    }

    //Returns the exit in a given direction
    public Location getExit(String direction) {
        return exits.get(direction);
    }
    
    public void setExits(ImmutableMap<String, Location> exits) {
        if (exits == null) {
            throw new IllegalArgumentException("Exits cannot be null");
        }
        this.exits = exits;
    }
    
    public String getItemsString(){
        String itemStringDescriptions = "You can see a";
        for (int i = 0; i < this.items.size(); i++) {
            String itemName = this.items.get(i).getName().toLowerCase();
            if (i == this.items.size() - 1) {
                itemStringDescriptions += (" and " + itemName);
            } else {
                itemStringDescriptions+= (" " + itemName + ",");
            }
        }
        return itemStringDescriptions;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    //Checks if location has an item
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

    public String printInventory() {
        String entireInventory = "This room has:\n";
        for (int i = 0; i < this.items.size(); i++) {
            entireInventory += "+ " + this.items.get(i).getName().toLowerCase() + "\n";
        }
        return entireInventory;
    }

    public static void main(String[] args) {
        Location loc = new Location("Location name", "description", null);
        Item item1 = new Item("Item 1", "Item 1", true);
        Item item2 = new Item("Item2 Desc", "item2", true);
        Item item3 = new Item("Item3 desc", "item3", true);
        loc.addItem(item1);
        loc.addItem(item2);
        loc.addItem(item3);
        System.out.println(loc.getItemsString());
    }
}
