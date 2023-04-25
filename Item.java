
public class Item{
    
    private String itemDescription;
    private String name;
    private boolean canBeUsed;
    private String location;

    //Premade items
    Item testItem = new Item("A test item", "Test Item", true, "somewhere");
    Item collar = new Item("A small red collar. It looks small enough for a cat. ", "collar", true, "somewhere");
    Item leash = new Item("A black leash.", "leash", true, "somewhere");
    Item oldCatFood = new Item("A can of cat food. It looks old...", "cat food", true, "somewhere");
    Item bell = new Item("A small bell", "bell", true, "somewhere");//if used with collar, tells user where cat is
    Item strawberry = new Item("A handful of ripe strawberries. How long have they been on the ground?", "strawberries", true, "somewhere");
    Item stone = new Item("A large stone. It's too large to be picked up", "cat food",false , "somewhere");
    Item stick = new Item("A stick.", "stick", true, "somewhere");
    Item grass = new Item("A patch of grass.", "grass", true, "somewhere");
    Item niceCatFood = new Item(".", "grass", true, "somewhere");

    public Item(String itemDescription, String name, boolean canBeUsed, String location){
        this.itemDescription = itemDescription;
        this.name = name;
        this.canBeUsed = false;
        this.location = location;
    }

    public String getDescription(){
        return this.itemDescription;
    }

    public String getName(){
        return this.name;
    }

    public boolean getCanBeUsed(){
        return this.canBeUsed;
    }

    private String getLocation(){
        return this.location;
    }

}