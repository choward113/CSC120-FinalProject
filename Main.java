import java.util.Scanner;
import com.google.common.collect.ImmutableMap;

public class Main {
    public static void main(String[] args) {
        //Creates 3 main locations
        Location kitchen = new Location("kitchen", "You are in a large, modern kitchen. There's some cat food on the counter and some strawberries on the table. There is a door to the north.", null);
        Location livingRoom = new Location("living room", "You are in a spacious living room. There is a door to the south.", null);
        Location bedRoom = new Location("bed room", "You're in your bedroom. It has a bed and you at the moment.", null);

        //Sets the exists of the locations
        kitchen.setExits(ImmutableMap.of("north", livingRoom));
        livingRoom.setExits(ImmutableMap.of("south", kitchen));
        bedRoom.setExits(ImmutableMap.of("down", livingRoom));
        
        //Add items to kitchen location
        Item strawberry = new Item("A strawberry, it looks fresh.","strawberry", true);
        Item catFood = new Item("A can of cat food. It looks old...", "cat food", true);
        Item bowl = new Item("A plastic bowl. It's empty.", "bowl", true);
        kitchen.addItem(strawberry);
        kitchen.addItem(bowl);
        kitchen.addItem(catFood);

        //Add items to living room location
        Item collar = new Item("A small red collar. It looks small enough for a cat. ", "collar", true);
        Item leash = new Item("A black leash.", "leash", true);
        Item bell = new Item("A small bell", "bell", true);//if used with collar, tells user where cat is
        livingRoom.addItem(leash);
        livingRoom.addItem(collar);
        livingRoom.addItem(bell);

        //Add items to bed room location
        Item stone = new Item("A small stone.", "stone",false) ;
        Item stick = new Item("A stick.", "stick", true);
        Item grass = new Item("A patch of grass.", "grass", true);
        bedRoom.addItem(stone);
        bedRoom.addItem(stick);
        bedRoom.addItem(grass);

        // Booleans for quest
        boolean catIsFed = false;
        boolean catIsHappy = false;

        //Initialize cat and person
        Cat cat = new Cat();
        Person person = new Person(bedRoom, cat);
        
        Scanner scanner = new Scanner(System.in);
        String input;

        //Starting text
        System.out.print("You wake up with your cat, "+person.getCatName()+", staring at you. " + person.getCatName() + " wants food. Maybe you should go downstairs.");
        System.out.println(" You are in the " + person.getCurrentLocation().getName() + ".");

        //Main game loop
        while (true) {
            System.out.print("> ");
            input = scanner.nextLine().toLowerCase().trim();

            if (input.equals("quit")) {
                System.out.println("Goodbye!");
                break;
            }

            if (input.equals("help")){
                System.out.println(">To move type \"go\" + north, south, east, west, up, or down.\n>To get a description of the room type \"look around\".\n>To pick up an item type \"take\" + the name of the item");
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

            if (input.startsWith("pick up ")) {
                String name = input.substring(8);
                person.pickUpItem(name);
            }

            if (input.startsWith("drop")) {
                String name = input.substring(5);
                person.dropItem(name);
            }

            if (input.startsWith("walk")) {
                String direction = input.substring(5);
                person.walk(direction);
            }

            if (input.startsWith("go")) {
                String direction = input.substring(3);
                person.walk(direction);
            }

            if (input.startsWith("inventory")) {
                System.out.println(person.entireInventory());
            }

            if (input.startsWith("use")) {
                String itemName = input.substring(4);
                person.use(itemName);
                catIsFed = cat.getIsFed();
                catIsHappy = cat.getIsHappy();
            }

            if (input.startsWith("pet")) {
                person.petCat();
                catIsHappy = cat.getIsHappy();
            }

            if (catIsHappy){
                System.out.println("You win! (until the next time you need to feed your cat)");
                break;
            }
        }
        scanner.close();
    }
}
