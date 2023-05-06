import java.util.ArrayList;

/**An Item class representing an item that has a name, description, and can be picked up and used */
public class Item{

    private String itemDescription;
    private String name; 
    private boolean canBeUsed; 
    private boolean pickedUp;
    static public ArrayList <Item> premadeItems = new ArrayList<Item>();

    /**
     * Constructor for Item class
     * @param itemDescription The description of the item
     * @param name The name of the item
     * @param canBeUsed A boolean saying if the item can be used or not
     */
    public Item(String itemDescription, String name, boolean canBeUsed) {
        this.itemDescription = itemDescription;
        this.name = name;
        this.canBeUsed = false;
        this.pickedUp = false;
    }

    /**
     * Accessor for itemDescription
     * @return The item description
     */
    public String getDescription() {
        return this.itemDescription;
    }

    /**
     * Accessor for pickedUp
     * @return A boolean saying if the item has been picked up or not
     */
    public boolean getPickedUp() {
        return this.pickedUp;
    }

    /**
     * Returns an object with a given name
     * @param name The name of the object
     * @return The object with the given name, null if the object is not found
     */
    public Item getItem(String name) {
        for (Item item : Item.getPremadeItems()) {
            if (item.getName().equals(name)) { 
                return item;
            } 
        }   
        return null;
    }

    /**
     * Mutator for pickedUp
     * @param newPickedUp The new value for pickedUp
     */
    public void setPickedUp(boolean newPickedUp) {
        this.pickedUp = newPickedUp;
    }

    /**
     * Accessor for premadeItems
     * @return ArrayList of Items from premadeItems
     */
    public static ArrayList<Item> getPremadeItems() {
        return premadeItems;
    }

    /**
     * Accessor for name
     * @return The name of the item
     */
    public String getName() {
        return this.name;
    }

    /**
     * Accessor for canBeUsed
     * @return A boolean saying if the item can be used or not
     */
    public boolean getCanBeUsed() {
        return this.canBeUsed;
    }

}