import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
                return new StatBlock(8, 16, 12, 10, 12, 14);
            case Barbarian:
                return new StatBlock(16, 8, 10, 14, 12, 12);
            case Rogue:
                return new StatBlock(10, 10, 14, 12, 12, 14);
            case Hunter:
                return new StatBlock(12, 12, 16, 10, 8, 8);
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



    public void gainXP(int amountXP) {
        /* gainXP from combat, can gain multiple levels is received enough xp at once */
        int levelsGained = levelSystem.gainXP(amountXP);
        for(int i=0; i < levelsGained; ++i) {
            int lvlHP = calculateHPIncrease();
            hp.setMaxHP(lvlHP);
        }
        // figure out stats increase at certain lvls
    }

    public void printInventory() {
        for (Inventory item : inventory) {
            System.out.println(item);
        }
    }

    public void print() {
        //System.out.println("Class: " + type);
        //System.out.println("Name: " + name);
        //System.out.println("Level: " + levelSystem.getLevel());
        //levelSystem.printLvl();
        //hp.printHP();
        //stats.printStats();
        printInventory();
    }

    public void addItem(Inventory item) {
        boolean itemExists = false;

        if (inventory.isEmpty()) {
            // just here for first item added to inventory
            inventory.add(new Inventory(item.getItemName(), item.getItemDescription(), item.getQuanity(),
                    item.getIncreaseFromItem()));
        }
        else {
            for (int i = 0; i < inventory.size(); ++i) {
                if (item.getItemName().equals(inventory.get(i).getItemName()))
                {
                    int updateQuantity = inventory.get(i).getQuanity() + item.getQuanity();
                    // if already in inventory, increase quantity
                    inventory.get(i).setQuanity(updateQuantity);

                    itemExists = true;  // there was a match in our inventory
                    break;
                }
            }
            // if not in Inventory, add item
            if (!itemExists)
                inventory.add(new Inventory(item.getItemName(), item.getItemDescription(), item.getQuanity()
                             , item.getIncreaseFromItem()));
        }
    }
}
