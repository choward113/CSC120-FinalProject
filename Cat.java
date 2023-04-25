public class Cat {

    //attributes: personality, name, sabotageChance 

    public Cat(String name){
        //base attributes: neutral, name, 33%
    }

    private boolean sabotage(){
        //if sabotageChance above 50, return true and subtract 30
        //else return false, and add 10-20(depends on personality)
        return true;
    }

    public void walk(String direction){
        //cat walks in same direction of person
        //based on sabotageChance. 
        //if sabotage then:
        //  a) standing still(prevent player from moving) 
        //  b)walking in opposite direction(prevent player from moving)
        //else change location to ()
    }

    public void pickUp(Item s){
        //if this.sabotage() true
        //sout (name + "knocks the " + s + out of your hands...)
    }
}