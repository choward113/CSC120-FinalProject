import java.util.ArrayList;

public class Item{

    private String itemDescription;
    private String name;
    private boolean canBeUsed;
    private boolean pickedUp;
    static public ArrayList <Item> premadeItems = new ArrayList<Item>();

    public Item(String itemDescription, String name, boolean canBeUsed){
        this.itemDescription = itemDescription;
        this.name = name;
        this.canBeUsed = false;
        this.pickedUp = false;
    }

    public String getDescription(){
        return this.itemDescription;
    }

    public boolean getPickedUp(){
        return this.pickedUp;
    }

    public void setPickedUp(boolean bool){
        this.pickedUp = bool;
    }

    public Item getItem(String name){
        for (Item item : Item.getPremadeItems()) {
            if (item.getName().equals(name)) { 
                return item;
            } 
        }   
        return null;
    }

    public static ArrayList<Item> getPremadeItems() {
        return premadeItems;
    }

    public String getName(){
        return this.name;
    }

    public boolean getCanBeUsed(){
        return this.canBeUsed;
    }

}