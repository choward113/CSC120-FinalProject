import java.util.ArrayList;

public class Inventory {
    
    private ArrayList<Item> inventory;

    public Inventory(){
        this.inventory = new ArrayList<Item>();
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

    public String addItem(String name, Location currentLocation) {
        Item itemToAdd = currentLocation.contains(name);
        if (itemToAdd != null) {
            this.inventory.add(itemToAdd);
            return itemToAdd.getName();
        }
        throw new RuntimeException("Item with name " + name + " not found.");
    }

}