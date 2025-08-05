public class Mana {
    private int currentMana;
    private int maxMana;

    public Mana() {
        this.currentMana = 0;
        this.maxMana = 0;
    }

    public Mana(int newPlayerMana) {

        this.currentMana = newPlayerMana;
        this.maxMana = newPlayerMana;
    }

    public int getCurrentMana() { return currentMana; }
    public int getMaxMana() { return maxMana; }

    public void setMaxMana(int addLvlUpMana) {
        // used when leveled.
        this.maxMana += addLvlUpMana;
        this.currentMana = this.maxMana;
    }

    public void setCurrentMana(int mana) {
        this.currentMana = mana;
    }

    public void restoreMana(int restoreAmount) {
        for (int i=0; i < restoreAmount; ++i) {
            if (this.currentMana >= this.maxMana)
                break;

            currentMana += restoreAmount;
        }
    }

    public void printManaSlots() {
        char character = 'o';
        for (int i=1; i <= this.currentMana; ++i)
            System.out.println(character + " ");
    }
}
