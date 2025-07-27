import java.util.ArrayList;

public class Player {
    public enum Type {
        Wizard("Wizard"),
        Barbarian("Barbarian"),
        Rogue("Rogue"),
        Hunter("Hunter");

        Type(String type) {
        }
    }

    // attributes that define a player
    private Type type;
    private String name;
    private StatBlock stats;
    private LevelSystem levelSystem;
    private HP hp;

    public ArrayList<Inventory> inventory = new ArrayList<>();

    // premade statblock for class types
    private StatBlock stats(Type type) {
        switch (type) {
            case Wizard:
                return new StatBlock(8, 16, 12, 10, 12, 14, 4);
            case Barbarian:
                return new StatBlock(16, 8, 10, 14, 12, 12, 1);
            case Rogue:
                return new StatBlock(10, 10, 14, 12, 12, 14, 2);
            case Hunter:
                return new StatBlock(12, 12, 16, 10, 8, 8, 3);
            default:
                return null;
        }
    }

    private int calculateHPIncrease() {
        /* increase by increaseHP + Con modifier */
        int increaseHP = 5;     // just a number to test. can change
        int conMod = stats.getConModifier();

        return increaseHP + conMod;
    }
// Public:
    public Player(Type type, String name) {
        /* create premade characters stats depending on Type */
        this.type = type;
        this.name = name;
        this.stats = stats(type);
        this.levelSystem = new LevelSystem();
        this.hp = new HP(10, 10);
    }

    public void setType(Type type) {
        this.type = type;
        this.stats = stats(type);
    }

    public Type getType() {
        return type;
    }
    public String getName() {
        return name;
    }

    public void takeDamage(int damage) {
        hp.receiveDamage(damage);
    }
    public int getLevel() { return this.levelSystem.getLevel(); }


    public void gainXP(int amountXP) {
        /* gainXP from combat, can gain multiple levels is received enough xp at once */
        int levelsGained = levelSystem.gainXP(amountXP);
        for(int i=0; i < levelsGained; ++i) {
            int lvlHP = calculateHPIncrease();
            hp.setMaxHP(lvlHP);
        }
        // figure out stats increase at certain lvls
    }

    public void addItem(Inventory item) {
        boolean itemExists = false;

        if (inventory.isEmpty()) {
            // just here for first item added to inventory
            inventory.add(new Inventory(item.getItemName(), item.getItemType(), item.getItemQuantity(),
                    item.getIncreaseFromItem()));
        }
        else {
            for (int i = 0; i < inventory.size(); ++i) {
                if (item.getItemName().equals(inventory.get(i).getItemName()))
                {
                    int updateQuantity = inventory.get(i).getItemQuantity() + item.getItemQuantity();
                    // if already in inventory, increase quantity
                    inventory.get(i).setQuantity(updateQuantity);

                    itemExists = true;  // there was a match in our inventory
                    break;
                }
            }
            // if not in Inventory, add item
            if (!itemExists)
                inventory.add(new Inventory(item.getItemName(), item.getItemType(), item.getItemQuantity()
                        , item.getIncreaseFromItem()));
        }
    }

    public void useItem(Inventory item) {
    /* use item from inventory. Removes item from inventory when quantity is 0 */
        boolean itemFound = false;

        for (int i = 0; i < inventory.size(); ++i) {
            if (item.getItemName().equals(inventory.get(i).getItemName())) {
                itemFound = true;   // there's a match in our inventory
                switch (inventory.get(i).getItemType()) { // need to figure out type of item and how to use it properly
                    case heal:
                        hp.heal(item.getIncreaseFromItem());
                        break;
                    case mana:
                        stats.restore(item.getIncreaseFromItem());
                        break;
                    default:
                        throw new RuntimeException("That item type is not in the game");
                }
                int updateQuantity = inventory.get(i).getItemQuantity() - 1;

                if (updateQuantity < 1) {
                    // remove from inventory if Quantity is 0
                    inventory.remove(i);
                    break;
                } else {
                    // decreases quantity by one
                    inventory.get(i).setQuantity(updateQuantity);
                }
                break;
            }
        }
        if (!itemFound) {
            System.out.println("You don't have a " + item.getItemName() + " in your inventory");
        }
    }

    private boolean isEnoughMana() {
        return stats.getManaSlots() > 0;
    }

    public int useAbility(Ability ability) {
        if (isEnoughMana()) {
            int cost = stats.getManaSlots() - ability.getManaCost();

            stats.setManaSlots(cost);

            return ability.getAbilityEffect();
        }
        else
            System.out.println("You don't have any mana!");

            return 0;
    }

    public void print() {
        System.out.println("Class: " + type);
        System.out.println("Name: " + name);
        System.out.println("Level: " + levelSystem.getLevel());
        levelSystem.printLvl();
        hp.printHP();
        //stats.printStats();
        printInventory();

    }

    public void printInventory() {
        for (Inventory item : inventory) {
            System.out.println(item);
        }
    }

    public void printManaSlots() {
        System.out.print("[Mana Slots: ");

        char character = 'o';
        for (int i=1; i <= stats.getManaSlots(); ++i)
            System.out.print(character + " ");

        System.out.println("]");
    }
}
