import java.util.ArrayList;

public class Inventory {
    
    private ArrayList<Item> inventory;

    public Inventory(){
        this.inventory = new ArrayList<Item>();
    }
    
    public void addItem(String name){
        //Look through premade item arraylist, 
        //if string name.equals premadeArrayList.premadeitem.getname
        //equals the item with the same name 
        //this.inventory.add(String name);
    }

    public String printInventory(){
        String entireInventory = "Empty + ";
        for (int i = 0; i < this.inventory.size(); i++){
            entireInventory += this.inventory.get(i).getName();
        }
        return entireInventory;
    }
    

    public static void main(String[] args) {
       Inventory myInv = new Inventory();
       myInv.addItem("name");
       myInv.inventory.get(0);
       System.out.println(myInv.printInventory());
    }
}