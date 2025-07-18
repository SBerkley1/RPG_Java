import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Player player = new Player(typeChoice(), name());

        player.print();

        player.gainXP(300);
        System.out.println("----");
        player.print();
        System.out.println("----");

        Inventory manaRestore = new Inventory("Mana restore", "Recovers 1 spell slot", 1, 1);
        Inventory smallHealPotion = new Inventory("Small Heal Potion", "Heals for 4 hp", 3, 4);
        player.addItem(smallHealPotion);

        player.takeDamage(5);
        player.print();

        System.out.println("----");
        player.addItem(smallHealPotion);
        player.takeDamage(13);
        player.print();

        System.out.println("---");
        player.addItem(manaRestore);
        player.print();
        System.out.println("----");
        player.addItem(smallHealPotion);
        player.addItem(manaRestore);
        player.print();
        System.out.println("----");
        player.addItem(smallHealPotion);
        player.addItem(manaRestore);
        player.print();

    }

    public static Player.Type typeChoice() {
        Scanner scnr = new Scanner(System.in);  // will need to pass in scnr
        System.out.print("What class do you want? (e.g., Wizard, Barbarian, Rogue, Hunter): ");
        String typeChoice;
        typeChoice = scnr.nextLine();

        switch(typeChoice) {
            case "Wizard":
                return Player.Type.Wizard;
            case "Barbarian":
                return Player.Type.Barbarian;
            case "Rogue":
                return Player.Type.Rogue;
            case "Hunter":
                return Player.Type.Hunter;
            default:
                throw new RuntimeException("Invalid class!");

        }
    }

    public static String name() {
        Scanner scnr = new Scanner(System.in); // will need to pass in scnr
        System.out.print("What is your name?: ");
        String name;
        name = scnr.nextLine();

        return name;
    }
}
