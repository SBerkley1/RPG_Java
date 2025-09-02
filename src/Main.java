import java.util.*;

public class Main {
    private static Map<String, Ability> abilities = new HashMap<>();

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        Player player = new Player(typeChoice(scnr), name(scnr));

        Inventory manaRestore = new Inventory("Mana Restore", Inventory.ItemType.mana,  1, 1);
        Inventory smallHealPotion = new Inventory("Small Heal Potion", Inventory.ItemType.heal, 3, 4);
        player.addItem(smallHealPotion);
        player.addItem(manaRestore);

        // will be getting stats from 5e(2014) Monster Manual
        Monster goblin = new Monster("Goblin", 7, 5, 50);
        Monster duergar = new Monster("Duergar", 26, 6, 200);
        Monster flameskull = new Monster("FlameSkull", 40, 10, 1100);

        combatSystem(player, goblin, scnr);
        combatSystem(player, duergar, scnr);
        combatSystem(player, flameskull, scnr);





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

    public static void putAbility(Player player) {
        Ability fireball = new Ability(player, "fireball", Ability.AbilityType.attack, 1, 12, 1);
        Ability lvl2Spell = new Ability(player, "lvl2spell", Ability.AbilityType.attack, 2, 24, 1);

        if (fireball.getIsAbilityUnlock()) {
            abilities.put(fireball.getAbilityName(), fireball);
        }
        if (lvl2Spell.getIsAbilityUnlock()) {
            abilities.put(lvl2Spell.getAbilityName(), lvl2Spell);
        }
    }


    // Combat System ----------------------------------------------------

    public static void combatMenu() {
        // Options available during combat
        System.out.println("What would you like to do?");
        System.out.println("\t1. Attack");
        System.out.println("\t2. Use Ability");
        System.out.println("\t3. Use Item from Inventory");
        System.out.println("\t4. Check Inventory");
        System.out.println("\t5. Check your stats");
        System.out.println("\t6. Check Monster's stats");
        System.out.println();
    }

    public static void visualStatBlock(Player player, Monster npc) {
        System.out.print("[" + player.getName() + ": HP " + player.getCurrentHP() + "/" + player.getMaxHP() + "]");
        System.out.print("\t");player.printManaSlots();

        System.out.println("<" + npc.getName() + ": HP " + npc.getCurrentHP() + "/" + npc.getMaxHP() + ">");
        System.out.println();
    }

    public static void endOfBattle(Player player, Monster npc) {
        if (!npc.isAlive()) {
            System.out.println(player.getName() + " has killed the " + npc.getName() + "!");
            player.gainXP(npc.getGivenXP());
        }

        if (!player.isAlive()) {
            System.out.println(player.getName() + " has died. I'm sorry adventurer!");
        }
    }

    public static void choseItem(Player player, Scanner scnr) {
        // displays Inventory, asks if player wants to use an item, Player needs to type in the key name correctly to use it
        // I know my UI sucks for this, but I'm in early stages
        player.printInventory();
        System.out.println();

        // need to add code to show a message if nothing in inventory.
        if (player.inventory.isEmpty()) {
            System.out.println("You're inventory is empty...");
            return;
        }

        System.out.print("Would you like to use an item? (y/n): ");
        String userAnswer;
        userAnswer = scnr.nextLine().trim();

        if (!userAnswer.equals("y")) {
            return;
        }

        System.out.print("Which item would you like to use?: ");
        String userChoise;
        userChoise = scnr.nextLine();

        Inventory chosenItem = null;
        for (Inventory item : player.getInventory()) {
            if (item.getItemName().equalsIgnoreCase(userChoise)) {
                chosenItem = item;
                break;
            }
        }

        player.useItem(chosenItem);  // when hp is full and you use heal potion, it still consumes a potion and displays that you were healed by 6, which should be 4


    }

    public static Ability choseAbility(Player player) {
        Ability fireball = new Ability(player, "fireball", Ability.AbilityType.attack, 1, 12, 1);
        Ability lvl2Spell = new Ability(player, "lvl2spell", Ability.AbilityType.attack, 2, 24, 1);

        // don't know how I'm going to implement this yet.
        System.out.println(fireball);

        return fireball;

    }

    public static void baseAttack(Player player, Monster npc) {
        System.out.println("You attacked the " + npc.getName() + " and did " + player.getBaseDamage() + " damage!");
        npc.takeDamage(player.getBaseDamage());
        if (npc.isAlive()) {
            System.out.println("The " + npc.getName() + " attacked you and did " + npc.getDamage() + " damage!");
            player.takeDamage(npc.getDamage());
        }
    }

    public static void useAbility(Player player, Monster npc) {
        if (player.getManaSlots() <= 0) {   // Player has no mana
            System.out.println("You do not have enough Mana Slots. Pick another option or use a Mana Restore Potion!");
            return;
        }

        npc.takeDamage(player.useAbility(choseAbility(player)));
        if (npc.isAlive()) {
            System.out.println("The " + npc.getName() + " attacked you and did " + npc.getDamage() + " damage!");
            player.takeDamage(npc.getDamage());
        }
    }

    public static void combatSystem(Player player, Monster npc, Scanner scnr) {

        if (player.isAlive()) {
            combatMenu();   // list combat options
        }

        while (player.isAlive() && npc.isAlive()) {
            visualStatBlock(player, npc);

            System.out.print(">");
            int userInput;
            userInput = scnr.nextInt();
            scnr.nextLine();

            switch (userInput) {
                case 1: {  // base attack
                    baseAttack(player, npc);
                    break;
                }
                case 2: { // use ability
                    useAbility(player, npc);
                    break;
                }
                case 3: { // use item
                    choseItem(player, scnr);
                    break;
                }
                case 4: { // check inventory
                    // FIXME: actually I think I can remove this because use item will show inventory
                    player.printInventory();
                    break;
                }
                case 5: {   // check player stats
                    player.print();
                    break;
                }
                case 6: {   // check monster's stats
                    npc.print();
                    break;
                }
                default:
                    System.out.println("Invalid input!");
            }

            System.out.println();
            endOfBattle(player, npc);
        }
    }
}
