public class Person {

    //Attributes: currentLocation, inventory

    public Person (){
        //currentLocation is start
        //inventory is inventory class
    }

    public void look(){
        //if input is examine, look, look around
        //print description of location(if room is none)
        //else print room description
        //maybe add "look up,down,etc"
    }

    public void look(Item s){
        //if input is examine item, look at item, check item
        //check if item is in inventory or in the room
        //print description
    }

    public void look(Cat c){
        //if input is examine cat, look at cat, check cat
        //print of description of cat
        //Ex. x looks indifferent, annoyed, angry, happy, content, satisfied

    }

    public void walk(String direction){
        //check if can walk direction
        //walk in direction
        //call Cat.walk(direction)
    }

    public void pickUp(Item s){
        //check if item exists and can be picked up
        //call cat.pickUp(s) - chance for sabotage
        //pick up item
    }


}