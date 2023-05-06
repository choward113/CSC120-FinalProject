import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
    A Cat class represents a cat with a name, personality, and the ability to sabotage various actions.
    */
public class Cat {

    private String name; // The name of the cat.
    private double sabotageChance; // The chance the cat will sabotage various actions.
    private Personality personality; // The personality of the cat.
    private boolean isFed; // Whether or not the cat has been fed.
    private boolean isHappy; // Whether or not the cat is happy
    private boolean isPet; // Whether or not the cat has been pet.
    private ArrayList<String> nameList = new ArrayList<String>(){{
        add("Whiskers");
        add("Mittens");
        add("Sir Paxton");
        add("Kitty");
        add("Rat");
     }}; // Possible names for cat
    

    /*Default constructor, initializes a Cat with random personality, name, and sabotage chance*/
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

    /* Full constructor */
    public Cat(String name, double sabotageChance, Personality personality){
        this.name = name;
        this.sabotageChance = sabotageChance;
        this.personality = personality;
        this.isFed = false;
        this.isHappy = false;
        this.isPet = false;
    }
    
    /**
    * Accessor for name
    * @return The name of the cat
    */
    public String getName(){
        return this.name;
    }

    /**
     * Accessor for isFed
     * @return Whether or not the cat has been fed
     */
    public boolean getIsFed(){
        return this.isFed;
    }

    /**
     * Accessor for isHappy
     * @return Whether or not the cat is happy
     */
    public boolean getIsHappy(){
        if (this.isFed && this.isPet){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Mutator for sabotageChance
     * @param newSabotageChance The new value for sabotageChance
     */
    public void setSabotageChange(double newSabotageChance){
        this.sabotageChance = newSabotageChance;
    }

    /**
     * Mutator for isPet
     * @param bool The new value for isPet
     */
    public void setIsPet(boolean bool){
        this.isPet = bool;
    }

    /**
     * Feeds cat a given food
     * @param food The food to feed the cat
     */
    public void feed(String food){
        if (food.equals("cat food")) {
            System.out.println(this.name+" looks pleased.");
            sabotageChance = 0;
            isFed = true;
        } else if (food.equals("stone")) {
            System.out.println("Why are you trying to feed a stone to a cat? "+this.name+" looks displeased.");
            sabotageChance = 0.9;
        } else {
            System.out.println("Your cat looks displeased.");
            sabotageChance = 0.9;
        }
    }

    /**
     * If the sabotage chance is greater than or equal to 0.5, it subtracts 0.3, otherwise it adds a value based on personality to sabotageChance 
     * @return True if the cat sabotages, false otherwise.
     */
    public boolean sabotage(){
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

    /**
     * Calculates the sabotage boost based on the cat's personality.
     * @param personality The personality of the cat
     * @return  A double value representing the sabotage boost.
     */
    private double getSabotageBoost(Personality personality){
        if (this.personality == Personality.NEUTRAL){
            return 0.1;
        } else if (this.personality == Personality.SLY) {
            return 0.15;
        } else if (this.personality == Personality.KIND) {
            return 0.05;
        } else if (this.personality == Personality.MEAN) {
            return 0.2;
        } else if (this.personality == Personality.SHY) {
            return 0.05;
        } else {
            return 0.1;
        }
    }

    /**
    * Calls the sabotage method and if it returns true, it prints a message indicating that the Cat is blocking the owner's way.
    * Otherwise, it prints a message saying that the Cat is walking with the owner in the given direction.
    * @param direction The direction in which the owner is walking
    * @return True if the cat sabotages, false otherwise.
    */
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

    /**
     * Calls the sabotage method and if it returns true, returns true
     * @param s The item the Person is trying to pick up
     * @return True if the cat sabotages, false otherwise.
     */
    public boolean sabotagePickUp(Item s){
       return sabotage();
    }
}
