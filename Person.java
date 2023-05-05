
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

    public void pickUpItem(String name){
        Location itemLocation = this.currentLocation;
        Item item = itemLocation.contains(name);
        if (itemLocation.contains(name) != null && !item.getPickedUp()){
            this.inventory.addItem(name, itemLocation);
            System.out.println("Picked up " + name);
            item.setPickedUp(true);
            itemLocation.removeItem(item);
        } else {
            System.out.println("There's no "+name+" here.");
        }
    }

    public void dropItem(String itemName) {
        Item item = inventory.removeItem(itemName);
        if (item != null) {
            currentLocation.addItem(item);
            System.out.println("Dropped "+ item.getName());
        }
    }

    public void walk(String direction){
        Location nextLocation = this.currentLocation.getExit(direction);
        if (nextLocation == null) {
            System.out.println("You cannot go that way.");
        } else {
            System.out.println("You walk " + direction + " to the " + nextLocation.getName() + ".");
            this.currentLocation = nextLocation;
            System.out.println("You are now in the " + this.currentLocation.getName() + ".");
        }
    }

    public String entireInventory(){
        return this.inventory.printInventory();
    }

}