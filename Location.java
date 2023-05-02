import com.google.common.collect.ImmutableMap;

import java.util.HashSet;
import java.util.Set;

public class Location {

    private final String name;
    private final String description;
    private ImmutableMap<String, Location> exits;
    private final Set<Item> items;

    public Location(String name, String description, ImmutableMap<String, Location> exits) {
        this.name = name;
        this.description = description;
        this.exits = exits;
        this.items = new HashSet<>();
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
    

    public boolean contains(Item item) {
        return items.contains(item);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public Set<Item> getItems() {
        return items;
    }

    //Checks if location has an item
    public Item contains(String name){
        for (Item item : Item.getPremadeItems()) {
            if (item.getName().equals(name)) { 
                return item;
            }
        }
        return null;
    }
}
