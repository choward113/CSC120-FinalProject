
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
        //if input is examine, look, look around
        //print description of location(if room is none)
        //else print room description
        //maybe add "look up,down,etc"
        if (this.currentLocation.getDescription() != null){
            System.out.println(this.currentLocation.getDescription());
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

    public void look(Cat c){
        //if input is examine cat, look at cat, check cat
        //print
    }

    public String getCatName(){
        return this.cat.getName();
    }

    public void pickUpItem(String name){
        if (this.currentLocation.contains(name) != null){
            this.cat.pickUp(this.currentLocation.contains(name));
            this.inventory.addItem((name));
        } else 
        System.out.println("test");
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
}