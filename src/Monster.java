public class Monster {
    private String name;
    private HP hp;
    private StatBlock statBlock;
    private Ability ability;    // will dive deeper into this. when I figure out random
    private Mana mana;
    private int damage;     // my goal is to be dynamic like a player, but for now just a constant amount
    private int givenXP;

    public Monster(String name, int hp, int damage, int xp) {
        setName(name);
        setHP(hp, hp);
        setDamage(damage);
        setGivenXP(xp);
    }

    // Getters... still need StatBlock, Ability, and Mana
    public String getName() { return name; };
    public int getHP() { return hp.getCurrentHP(); }
    public int getDamage() { return damage; }
    public int getGivenXP() { return givenXP; }

    // setters
    public void setName(String name) {
        this.name = name;
    }
    public void setHP(int currentHP, int maxHP) {
        this.hp = new HP(currentHP, maxHP);
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public void setGivenXP(int xp) {
        this.givenXP = xp;
    }

    public void print() {
        System.out.println("Type: " + name);
        hp.printHP();
        System.out.println("Damage: " + damage);
        System.out.println("XP amount: +" + givenXP);
        // levelSystem.printLvl();

        // stats.printStats();
        // printInventory();

    }

}
