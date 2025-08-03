public class StatBlock {
    private int strength;
    private int intelligence;
    private int dexterity;
    private int constitution;
    private int wisdom;
    private int charisma;

    public StatBlock(int strength, int intelligence, int dexterity
                    , int constitution, int wisdom, int charisma) {

        this.strength = strength;
        this.intelligence = intelligence;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }

    // standard getters
    public int getStrength() { return strength; }
    public int getIntelligence() { return intelligence; }
    public int getDexterity() { return  dexterity; }
    public int getConstitution() { return constitution; }
    public int getWisdom() { return wisdom; }
    public int getCharisma() { return charisma; }

    // setters
    public void setStrength(int strength) { this.strength = strength; }
    public void setIntelligence(int intelligence) { this.intelligence = intelligence; }
    public void setDexterity(int dexterity) { this.dexterity = dexterity; }
    public void setConstitution(int constitution) { this.constitution = constitution; }
    public void setWisdom(int wisdom) { this.wisdom = wisdom; }
    public void setCharisma(int charisma) {this.charisma = charisma; }

    // modifiers
    public int getStrModifier() { return (strength - 10) / 2; }
    public int getIntModifier() { return (intelligence - 10) / 2; }
    public int getDexModifier() { return (dexterity - 10) / 2; }
    public int getConModifier() { return (constitution - 10) / 2; }
    public int getWisModifier() { return (wisdom - 10) / 2; }
    public int getChaModifier() { return (charisma - 10) / 2; }


    public void printStats() {
        System.out.println("STR: " + strength + " (" + getStrModifier() + ")");
        System.out.println("INT: " + intelligence + " (" + getIntModifier() + ")");
        System.out.println("DEX: " + dexterity + " (" + getDexModifier() + ")");
        System.out.println("CON: " + constitution + " (" + getConModifier() + ")");
        System.out.println("WIS: " + wisdom + " (" + getWisModifier() + ")");
        System.out.println("CHA: " + charisma + " (" + getChaModifier() + ")");
    }

}
