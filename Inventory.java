import java.util.ArrayList;

public class Inventory {
    
    private ArrayList<Item> inventory;

    public Inventory(){
        this.inventory = new ArrayList<Item>();
    }
    
    public String addItem(String name){
        for (Item item : Item.getPremadeItems()) {
            if (item.getName().equals(name)) {
                this.inventory.add(item); 
                return item.getName();
            }
        }
        throw new RuntimeException("Item with name " + name + " not found.");
    }

    private String removeItem(String name){
        for (Item item : Item.getPremadeItems()) {
            if (item.getName().equals(name)) {
                this.inventory.remove(item); 
                return item.getName();
            }
        }
        throw new RuntimeException("Item with name " + name + " not found.");
    }

    public String printInventory(){
        String entireInventory = "You currently have:\n";
        for (int i = 0; i < this.inventory.size(); i++){
            entireInventory += "+ "+this.inventory.get(i).getName().toLowerCase()+"\n";
        }
        return entireInventory;
    }
    
    public Item contains(String name){
        for (Item item : Item.getPremadeItems()) {
            if (item.getName().equals(name)) { 
                return item;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        Inventory myInv = new Inventory();
        myInv.addItem("stick");
        myInv.addItem("Test Item");
        myInv.inventory.get(0);
        System.out.println(myInv.printInventory());
    }
}