import java.util.ArrayList;

public class Item{

    private String location;
    private String itemDescription;
    private String name;
    private boolean canBeUsed;
    static private ArrayList <Item> premadeItems = new ArrayList<Item>();

    static {
        //Premade items. Location "out" means it hasn't been picked up
        Item testItem = new Item("A test item", "Test Item", true, "out");
        Item collar = new Item("A small red collar. It looks small enough for a cat. ", "collar", true, "out");
        Item leash = new Item("A black leash.", "leash", true, "out");
        Item oldCatFood = new Item("A can of cat food. It looks old...", "cat food", true, "out");
        Item bell = new Item("A small bell", "bell", true, "out");//if used with collar, tells user where cat is
        Item strawberry = new Item("A handful of ripe strawberries. How long have they been on the ground?", "strawberries", true, "out");
        Item stone = new Item("A large stone. It's too large to be picked up", "cat food",false , "out");
        Item stick = new Item("A stick.", "stick", true, "out");
        Item grass = new Item("A patch of grass.", "grass", true, "out");
        premadeItems.add(testItem);
        premadeItems.add(collar);
        premadeItems.add(leash);
        premadeItems.add(oldCatFood);
        premadeItems.add(bell);
        premadeItems.add(strawberry);
        premadeItems.add(stone);
        premadeItems.add(stick);
        premadeItems.add(grass);
    }

    public Item(String itemDescription, String name, boolean canBeUsed, String location){
        this.itemDescription = itemDescription;
        this.name = name;
        this.canBeUsed = false;
        this.location = location;
    }

    public String getDescription(){
        return this.itemDescription;
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