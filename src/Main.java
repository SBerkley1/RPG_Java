import java.util.*;

public class Main {
    private static List<Inventory> inventory = new ArrayList<>();
    private static Map<String, Ability> abilities = new HashMap<>();

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        Player player = new Player(typeChoice(scnr), name(scnr));

        Inventory manaRestore = new Inventory("Mana Restore", Inventory.ItemType.mana,  1, 1);
        Inventory smallHealPotion = new Inventory("Small Heal Potion", Inventory.ItemType.heal, 3, 4);
        Ability fireball = new Ability(player, "fireball", Ability.AbilityType.attack, 1, 12, 1);
        Ability lvl2Spell = new Ability(player, "lvl2spell", Ability.AbilityType.attack, 2, 24, 1);

        putAbility(player, abilities);
        player.printManaSlots();


        System.out.println();
        System.out.println("You just used fireball and it costed 1 mana");
        player.useAbility(fireball);
        player.printManaSlots();
        player.gainXP(0);

        System.out.println();
        System.out.println("You just used fireball and it costed 1 mana");
        player.useAbility(fireball);
        player.printManaSlots();
        player.gainXP(0);

        System.out.println();
        System.out.println("You just used fireball and it costed 1 mana");
        player.useAbility(fireball);
        player.printManaSlots();
        player.gainXP(0);


        player.addItem(manaRestore);
        player.addItem(manaRestore);
        player.addItem(manaRestore);
        player.addItem(manaRestore);

        System.out.println();
        System.out.println("You just received 4 Mana Restores.");
        player.printInventory();
        player.printManaSlots();
        player.gainXP(0);

        System.out.println();
        System.out.println("You just used a Mana Restore");
        player.useItem(manaRestore);
        player.printInventory();
        player.printManaSlots();

        System.out.println();
        System.out.println("You just used a Mana Restore");
        player.useItem(manaRestore);
        player.printInventory();
        player.printManaSlots();

        System.out.println();
        System.out.println("You just used a Mana Restore");
        player.useItem(manaRestore);
        player.printInventory();
        player.printManaSlots();

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

    public static void putAbility(Player player, Map<String, Ability> abilities) {
        Ability fireball = new Ability(player, "fireball", Ability.AbilityType.attack, 1, 12, 1);
        Ability lvl2Spell = new Ability(player, "lvl2spell", Ability.AbilityType.attack, 2, 24, 1);

        if (fireball.getIsAbilityUnlock()) {
            abilities.put(fireball.getAbilityName(), fireball);
        }
        if (lvl2Spell.getIsAbilityUnlock()) {
            abilities.put(lvl2Spell.getAbilityName(), lvl2Spell);
        }
    }
}
