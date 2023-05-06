import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Cat {

    //attributes: personality, name, sabotageChance 
    private String name;
    private double sabotageChance;
    private Personality personality;
    private boolean isFed;
    private boolean isHappy;
    private boolean isPet;
    private ArrayList<String> nameList = new ArrayList<String>(){{
        add("Whiskers");
        add("Mittens");
        add("Sir Paxton");
        add("Kitty");
        add("Rat");
     }};
    

    //Randomized cat
    public Cat(){
        Random rand = new Random();
        int randomIndex = rand.nextInt(5);
        this.name = nameList.get(randomIndex);
        this.sabotageChance = ThreadLocalRandom.current().nextDouble(0.3, 0.7);
        int personalityRand = rand.nextInt(5);
        Personality[] values = Personality.values();
        this.personality = values[personalityRand];
        this.isFed = false;
        this.isHappy = false;
        this.isPet = false;
    }
    public Cat(String name, double sabotageChance, Personality personality){
        //constructor with full attributes
        this.name = name;
        this.sabotageChance = sabotageChance;
        this.personality = personality;
    }
    
    public String getName(){
        return this.name;
    }

    public boolean getIsFed(){
        return this.isFed;
    }

    public boolean getIsHappy(){
        if (this.isFed && this.isPet){
            return true;
        } else {
            return false;
        }
    }

    public void setSabotageChange(double newSabotageChance){
        this.sabotageChance = newSabotageChance;
    }
    public void feed(String food){
        if (food.equals("cat food")) {
            System.out.println(this.name+" looks pleased.");
            sabotageChance = 0;
            isFed = true;
        } else if (food.equals("stone")) {
            System.out.println("Why are you trying to feed a stone to a cat? "+this.name+" looks displeased.");
            sabotageChance += 0.9;
        } else {
            System.out.println("Your cat looks displeased.");
            sabotageChance += 0.9;
        }
    }

    public void setIsPet(boolean bool){
        this.isPet = bool;
    }

    public boolean sabotage(){
        //if sabotageChance above .50, return true and subtract 30
        //else return false, and add .10-.20(depends on personality)
        System.out.println("Current sabotage chance: "+this.sabotageChance);
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
