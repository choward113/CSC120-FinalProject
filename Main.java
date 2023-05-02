import java.util.Scanner;
import com.google.common.collect.ImmutableMap;

public class Main {
    public static void main(String[] args) {
        //Creates 3 main locations
        Location kitchen = new Location("kitchen", "You are in a large, modern kitchen. There is a door to the north.", null);
        Location diningRoom = new Location("dining room", "You are in a spacious dining room. There is a door to the south.", null);
        Location bedRoom = new Location("bed room", "You're in your bedroom. It has a bed, and you at the moment.", null);

        //Sets the exists of the locations
        kitchen.setExits(ImmutableMap.of("north", diningRoom));
        diningRoom.setExits(ImmutableMap.of("south", kitchen));
        bedRoom.setExits(ImmutableMap.of("down", diningRoom));
        
        //Initialize cat and person
        Cat cat = new Cat("Whiskers");
        Person person = new Person(bedRoom, cat);
        
        Scanner scanner = new Scanner(System.in);
        String input;

        //Starting text
        System.out.println("You wake up with your cat staring at you. " + person.getCatName() + " wants food. Maybe you should go downstairs.");
        System.out.println("You are in the " + person.getCurrentLocation().getName() + ".");

        //Main game loop
        while (true) {
            System.out.print("> ");
            input = scanner.nextLine().toLowerCase().trim();

            if (input.equals("quit")) {
                System.out.println("Goodbye!");
                break;
            }

            //Three options for look: "look", "look at", and "look around".
            if (input.startsWith("look")) {
                if (input.equals("look around")) {
                    person.look();
                } else if (input.startsWith("look at ")) {
                    String name = input.substring(8);
                    person.lookAtItem(name);
                } else if (input.startsWith("look")) {
                    person.look();
                } else {
                    System.out.println("I don't understand what you want to look at.");
                }
            }

            if (input.startsWith("take")) {
                String name = input.substring(5);
                person.pickUpItem(name);
            }

            if (input.startsWith("walk")) {
                String direction = input.substring(5);
                person.walk(direction);
            }
        }
        scanner.close();
    }
}
