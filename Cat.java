import java.util.ArrayList;
public class Cat {

    //attributes: personality, name, sabotageChance 

    private final String name;
    private double sabotageChance;
    private Personality personality;
    private ArrayList<String> nameList;

    public Cat(String name){
        //base attributes: neutral, name, 33%
        this.name = name;
        this.sabotageChance = 0.33;
        this.personality = Personality.NEUTRAL;
    }
    
    public String getName(){
        return this.name;
    }

    public Cat(String name, double sabotageChance, Personality personality){
        //constructor with full attributes
        this.name = name;
        this.sabotageChance = sabotageChance;
        this.personality = personality;
    }

    private boolean sabotage(){
        //if sabotageChance above .50, return true and subtract 30
        //else return false, and add .10-.20(depends on personality)
        if (this.sabotageChance >= 0.5){
            this.sabotageChance -= 0.3;
            return true;
        }
        else{
            this.sabotageChance += getSabotageBoost(this.personality);
            return false;
        }
    }

    private double getSabotageBoost(Personality personality){
        if (this.personality == Personality.NEUTRAL){
            return 0.1;
        } else if (this.personality == Personality.SLY) {
            return 0.15;
        } else if (this.personality == Personality.KIND){
            return 0.05;
        } else if (this.personality == Personality.AGGRESSIVE){
            return 0.2;
        } else {
        return 0;
        }
    }

    public boolean walk(String direction){
        if (sabotage()){
            System.out.println(name + " is blocking your way and preventing you from moving.");
            return false;
        }
        else {
            System.out.println(name + " walks with you towards the " + direction + ".");
            return true;
        }
    }

    public boolean pickUp(Item s){
        //if this.sabotage() true
        //sout (name + "knocks the " + s + " out of your hands...")
        //return false to indicate sabotage happened
        //else return true to indicate successful pickup
        if (sabotage()){
            System.out.println(name + " knocks the " + s.getName() + " out of your hands...");
            return false;
        }
        else {
            return true;
        }
    }
}
