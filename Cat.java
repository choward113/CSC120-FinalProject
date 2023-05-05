import java.util.ArrayList;
import java.util.Random;

public class Cat {

    //attributes: personality, name, sabotageChance 

    private String name;
    private double sabotageChance;
    private Personality personality;
    private ArrayList<String> nameList = new ArrayList<String>(){{
        add("Whiskers");
        add("Mittens");
        add("Sir Paxton");
        add("Kitty");
        add("Rat");
     }};

    public Cat(){
        //Randomized cat
        Random rand = new Random();
        int randomIndex = rand.nextInt(5);
        this.name = nameList.get(randomIndex); //random name from nameList
        this.sabotageChance = rand.nextDouble()* 0.3;
        int personalityRand = rand.nextInt(5);
        Personality[] values = Personality.values();
        this.personality = values[personalityRand];
    }

    public Cat(String name){
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

    public boolean sabotageWalk(String direction){
        if (sabotage()){
            System.out.println(name + " is blocking your way and preventing you from moving.");
            return true;
        }
        else {
            System.out.println(name + " walks "+direction+" with you.");
            return false;
        }
    }

    public boolean sabotagePickUp(Item s){
        if (sabotage()){
            System.out.println(name + " knocks the " + s.getName() + " out of your hands...");
            return true;
        }
        else {
            return false;
        }
    }
}
