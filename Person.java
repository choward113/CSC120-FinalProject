import java.util.Scanner;
import java.util.ArrayList;

/**A Person class representing a player in the game. 
 *  The player can move through the game world, pick up and drop items, use items, and interact with their cat. */ 
public class Person {

    private Location currentLocation;
    private final Inventory inventory;
    private final Cat cat;

    /**
     * Constructor for Person class
     * @param startLocation The starting location of the person
     * @param cat The person's cat
     */
    public Person(Location startLocation, Cat cat) {
        this.currentLocation = startLocation;
        this.inventory = new Inventory();
        this.cat = cat;
    }

    /**
     * Accessor for currentLocation
     * @return The current location of the person
     */
    public Location getCurrentLocation() {
        return this.currentLocation;
    }
    
    /**
     * Accessor for cat name
     * @return The cat's name
     */
    public String getCatName() {
        return this.cat.getName();
    }

    /**
     * Returns person's inventory
     * @return Person's inventory as an ArrayList
     */
    public ArrayList<Item> getInventory() {
        return this.inventory.getItems();
    }

    /**
     * Returns a string representation of the person's inventory
     * @return A string representation of the person's inventory
     */
    public String entireInventory() {
        return this.inventory.printInventory();
    }

    /**Prints the description of the person's current location and the items in it*/
    public void look() {
        if (this.currentLocation.getDescription() != null){
            System.out.println(this.currentLocation.getDescription());
            System.out.println(this.currentLocation.getItemsString());
        }
        else{
            System.out.println(this.currentLocation.getDescription());
        }
    }
    
    /**
     * Prints a description of an item in the person's inventory or current location
     * @param name The name of the item
     */
    public void lookAtItem(String name) {
        if (this.hasItem(name)) {
            System.out.println(this.getItem(name).getDescription()); 
        } else if (this.currentLocation.contains(name) != null) {
            System.out.println(this.currentLocation.contains(name).getDescription());
        } else {
            System.out.println("The " + name + " cannot be found here.");
        }
    }

    /**
     * Removes item from person's inventory
     * @param itemName The item to be dropped
     */
    public void dropItem(String itemName) {
        Item item = inventory.removeItem(itemName);
        if (item != null) {
            currentLocation.addItem(item);
            System.out.println("Dropped "+ item.getName());
        }
    }

    /**Pet's the cat and sets sabotageChance to 0*/
    public void petCat(){
        System.out.println("You pet "+ this.getCatName()+".");
        this.cat.setIsPet(true);
        this.cat.setSabotageChange(0);
        if (this.cat.getIsHappy()){
            System.out.println(this.getCatName()+ " looks content.");
        }
    }

    /**
     * Moves the person in a given direction, and updates the currentLocation.
     * @param direction The direction to walk
     */
    public void walk(String direction) {
        if (checkWalkRequirements(direction)) {
            boolean sabotaged = this.cat.sabotage();
            if (sabotaged) {
                System.out.println(this.cat.getName()+" sits in front of the door and stares at you. You can't move forward.");
                
            } else {
                Location nextLocation = this.currentLocation.getExit(direction);
                this.currentLocation = nextLocation;
                System.out.println("You walk " + direction + " to the " + nextLocation.getName() + ".");
                System.out.println("You are now in the " + this.currentLocation.getName() + ".");
            }
        }
    }

    /**
     * Adds an item to the person's inventory
     * @param name The item to be picked up
     */
    public void pickUpItem(String name){
        if (checkPickUpRequirements(name)) {
            boolean sabotaged = this.cat.sabotage();
            if (sabotaged) {
                System.out.println(this.cat.getName()+" bats the "+ name+ " out of your hands.");
                
            } else {
                Location itemLocation = this.currentLocation;
                Item item = itemLocation.contains(name);
                this.inventory.addItem(name, itemLocation);
                System.out.println("Picked up " + name);
                item.setPickedUp(true);
                itemLocation.removeItem(item);
            }
        }
    }

    /**
     * Checks if the person can pick up the given item
     * @param name The name of the item that the player wants to pick up
     * @return True if the player can pick up the item, false otherwise
     */
    public boolean checkPickUpRequirements(String name){
        Location itemLocation = this.currentLocation;
        Item item = itemLocation.contains(name);
        if (itemLocation.contains(name) != null && !item.getPickedUp()){
            return true;
        } else {
            System.out.println("There's no "+name+" here.");
            return false;
        }
    }

    /**
     * Checks if the person can move in the given direction 
     * @param direction The direction that the player wants to move
     * @return True if the player can move in that direction, false otherwise
     */
    public boolean checkWalkRequirements(String direction) {
        Location nextLocation = this.currentLocation.getExit(direction);
        if (nextLocation == null) {
            System.out.println("You cannot go that way.");
            return false;
        } else {
            return true;
        }
    }

    /**
     * Checks if the person has an item
     * @param name The name of the item the player wants to check for
     * @return True if the person has the item, false otherwise
     */
    public boolean hasItem(String name){
            for (Item item : getInventory()) {
                if (item.getName().equals(name)) { 
                    return true;
                }
            }
            return false;
        }

    /**
     * Returns an item in the inventory with a given name
     * @param name The name of the item 
     * @return The item if the person has the item, null otherwise
     */
    public Item getItem(String name){
        for (Item item : getInventory()) {
            if (item.getName().equals(name)) { 
                return item;
            }
        }
        return null;
    }

    /**
     * Uses item from inventory
     * @param itemName The name of the item to be used
     */
    public void use(String itemName) {
        if (this.hasItem(itemName)) {
          if (itemName.equals("bowl")) { //If the player uses the bowl 
            if (this.hasItem("cat food") || this.hasItem("strawberry")) { //Player can use strawberry or cat food
              Scanner scanner = new Scanner(System.in);
              System.out.println("Use bowl with which item?");
              String itemToUseWith = scanner.nextLine().toLowerCase().trim();
      
              if (itemToUseWith.equals("cat food") && this.hasItem("cat food")) {
                System.out.println("You feed the cat the cat food.");
                this.inventory.removeItem(itemToUseWith);
                this.cat.feed("cat food");
                return;
              } else if (this.hasItem(itemToUseWith)) {
                System.out.println("You try to feed the cat the " + itemToUseWith + ".");
                this.inventory.removeItem(itemToUseWith);
                this.cat.feed("strawberry");
                return;
              } else {
                System.out.println("You can't use the bowl with that item.");
                return;
              }
            } else {
              System.out.println("You need something to put in the bowl.");
              return;
            }
      
          } else if (itemName.equals("collar")) { //player can 
            if (this.hasItem("bell") || this.hasItem("leash")) {
              Scanner scanner = new Scanner(System.in);
              System.out.println("Use collar with which item?");
              String itemToUseWith = scanner.nextLine().toLowerCase().trim();
      
              if (itemToUseWith.equals("bell") && this.hasItem("bell")) {
                System.out.println("You put the collar on the cat " + this.getCatName() + " looks extra cute.");
                this.inventory.removeItem(itemToUseWith);
                this.inventory.removeItem(itemName);
                return;
      
              }
      
            } else if (itemName.equals("cat food")) {
              System.out.println("You can't use that here");
            } else {
                System.out.println("Used " + itemName);
              this.inventory.removeItem(itemName);
              return;
            }

          } else {
            System.out.println("You can't use that.");
          }
        }
      }    
}
