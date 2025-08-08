import java.util.*;

public class Main {
    private static List<Inventory> inventory = new ArrayList<>();
    private static Map<String, Ability> abilities = new HashMap<>();

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        Player player = new Player(typeChoice(scnr), name(scnr));

        // will be getting stats from 5e(2014) Monster Manual
        Monster goblin = new Monster("Goblin", 7, 5, 50);

        goblin.print();



        Inventory manaRestore = new Inventory("Mana Restore", Inventory.ItemType.mana,  1, 1);
        Inventory smallHealPotion = new Inventory("Small Heal Potion", Inventory.ItemType.heal, 3, 4);
        Ability fireball = new Ability(player, "fireball", Ability.AbilityType.attack, 1, 12, 1);
        Ability lvl2Spell = new Ability(player, "lvl2spell", Ability.AbilityType.attack, 2, 24, 1);


        scnr.close();
    }

    public static Player.Type typeChoice(Scanner scnr) {
        String typeChoice;

        while (true) {
            System.out.print("What class do you want? (e.g., Wizard, Barbarian, Rogue, Hunter): ");

            typeChoice = scnr.nextLine();
            String choiceCaps = typeChoice.toUpperCase();
            try {
                switch (choiceCaps) {
                    case "WIZARD":
                        return Player.Type.Wizard;
                    case "BARBARIAN":
                        return Player.Type.Barbarian;
                    case "ROGUE":
                        return Player.Type.Rogue;
                    case "HUNTER":
                        return Player.Type.Hunter;
                    default:
                        throw new RuntimeException(typeChoice + " is an invalid class! Try again.");
                }
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
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
