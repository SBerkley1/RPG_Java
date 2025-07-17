public class HP {
    private int currentHP;
    private int maxHP;

    public HP() {
        this.currentHP = 1;
        this.maxHP = 1;
    }

    public HP(int currentHP, int maxHP) {
        if (currentHP > maxHP)
            currentHP = maxHP;

        this.currentHP = currentHP;
        this.maxHP = maxHP;
    }

    // getters
    public int getCurrentHP() { return currentHP; }
    public int getMaxHP() {  return maxHP; }

    // setters
    public void setMaxHP(int addLvlUpHP) {
        this.maxHP += addLvlUpHP;
        this.currentHP = this.maxHP;
    }

    //public void receiveDamage(Ability damage)         coming later

    public void receiveDamage(int damage) {
        if(damage > currentHP)
            currentHP = 0;
        else
            currentHP -= damage;
    }

    public boolean isAlive() {
        /* returns true if still alive */
        if(currentHP <= 0)
            return false;

        return true;
    }

    public void heal(int healAmount) {
        if(healAmount + currentHP > maxHP)
            currentHP = maxHP;
        else
            currentHP += healAmount;
    }

    public void printHP() {
        System.out.println("HP: " + currentHP + "/" + maxHP);
    }
}
