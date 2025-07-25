import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        Player player = new Player(typeChoice(scnr), name(scnr));

        player.print();

        player.gainXP(50);
        System.out.println("----");
        player.print();
        System.out.println("----");

        Inventory manaRestore = new Inventory("Mana Restore", Inventory.ItemType.restore,  1, 1);
        Inventory smallHealPotion = new Inventory("Small Heal Potion", Inventory.ItemType.heal, 3, 4);

        HashMap<String, Ability> abilities = new HashMap<>();
        Ability fireball = new Ability(player, "fireball", Ability.AbilityType.attack, 1, 12);
        Ability lvl2Spell = new Ability(player, "lvl2spell", Ability.AbilityType.attack, 2, 24);



        if (fireball.getIsAbilityUnlock()) {
            abilities.put(fireball.getAbilityName(), fireball);
        }
        if (lvl2Spell.getIsAbilityUnlock()) {
            abilities.put(lvl2Spell.getAbilityName(), lvl2Spell);
        }

        System.out.println(abilities);
        player.addItem(smallHealPotion);

        player.takeDamage(fireball.getAbilityEffect());
        player.print();

        System.out.println("----");
        player.gainXP(0);

        if (lvl2Spell.getIsAbilityUnlock()) {
            abilities.put(lvl2Spell.getAbilityName(), lvl2Spell);
        }

        player.useItem(smallHealPotion);
        player.print();
        player.useItem(smallHealPotion);
        player.print();
        System.out.println("----");
        player.useItem(smallHealPotion);
        player.print();



        System.out.println("----");
        System.out.println(abilities);
        player.takeDamage(5);
        player.useItem(smallHealPotion);

        player.print();
        System.out.println("----");
        player.gainXP(100);
        if (fireball.getIsAbilityUnlock()) {
            abilities.put(fireball.getAbilityName(), fireball);
        }
        if (lvl2Spell.getIsAbilityUnlock()) {
            abilities.put(lvl2Spell.getAbilityName(), lvl2Spell);
        }

        System.out.println(abilities);
        player.print();




        scnr.close();

    }

    public static Player.Type typeChoice(Scanner scnr) {
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

    public static String name(Scanner scnr) {
        System.out.print("What is your name?: ");
        String name;
        name = scnr.nextLine();

        return name;
    }

}
