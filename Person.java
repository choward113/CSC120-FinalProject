import java.util.Scanner;
import java.util.ArrayList;

public class Person {

    private Location currentLocation;
    private final Inventory inventory;
    private final Cat cat;

    public Person(Location startLocation, Cat cat){
        //currentLocation is start
        //inventory is inventory class
        this.currentLocation = startLocation;
        this.inventory = new Inventory();
        this.cat = cat;
    }

    public Location getCurrentLocation(){
        return this.currentLocation;
    }

    public void look(){
        //if input is look, look around
        //print description of location(if room is none)
        if (this.currentLocation.getDescription() != null){
            System.out.println(this.currentLocation.getDescription());
            System.out.println(this.currentLocation.getItemsString());
        }
        else{
            System.out.println(this.currentLocation.getDescription());
        }
    }

    public void lookAtItem(String name){
        //if input is examine item, look at item, check item
        //check if item is in inventory or in the room
        //print description
        if (this.inventory.contains(name) != null){
            System.out.println(this.inventory.contains(name).getDescription());

        }
        else if (this.currentLocation.contains(name) != null){
            System.out.println(this.currentLocation.contains(name).getDescription());
        }
        else{
            System.out.println("The " + name + " cannot be found here.");
        }
    }

    public String getCatName(){
        return this.cat.getName();
    }

    public void dropItem(String itemName) {
        Item item = inventory.removeItem(itemName);
        if (item != null) {
            currentLocation.addItem(item);
            System.out.println("Dropped "+ item.getName());
        }
    }

    public void petCat(){
        System.out.println("You pet "+ this.getCatName()+".");
        this.cat.setIsPet(true);
        this.cat.setSabotageChange(0);
        if (this.cat.getIsHappy()){
            System.out.println(this.getCatName()+ " looks content.");
        }
    }

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

    public String entireInventory(){
        return this.inventory.printInventory();
    }

    public boolean checkWalkRequirements(String direction) {
        Location nextLocation = this.currentLocation.getExit(direction);
        if (nextLocation == null) {
            System.out.println("You cannot go that way.");
            return false;
        } else {
            return true;
        }
    }

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

    public ArrayList<Item> getInventory(){
        return this.inventory.getItems();
    }
    public boolean hasItem(String name){
            for (Item item : getInventory()) {
                if (item.getName().equals(name)) { 
                    return true;
                }
            }
            return false;
        }

    public void use(String itemName) {
        if (this.hasItem(itemName)) {
            if (itemName.equals("bowl")) {
                if (this.hasItem("cat food") || this.hasItem("strawberry")) {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Use bowl with which item?");
                    String itemToUseWith = scanner.nextLine().toLowerCase().trim();
    
                    if (itemToUseWith.equals("cat food") && this.hasItem("cat food")) {
                        System.out.println("You feed the cat the cat food.");
                        this.inventory.removeItem(itemToUseWith);
                        this.cat.feed("cat food");
                        return;
                    } else if (itemToUseWith.equals("strawberry") && this.hasItem("strawberry")) {
                        System.out.println("You feed the cat the strawberry.");
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
