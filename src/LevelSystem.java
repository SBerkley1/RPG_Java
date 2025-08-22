public class LevelSystem {
    private int level = 1;
    private int xp = 0;

    public int gainXP(int amount) {
        xp += amount;
        int lvlGained = 0;

        while (xp >= xpToNextLevel()) {
            ++level;
            ++lvlGained;
            System.out.println("Leveled up to " + level);
        }

        return lvlGained;
    }

    public boolean isLvlUp() { return xp >= xpToNextLevel(); }

    public int xpToNextLevel() {
        return level * 100;     // generic right now. switch later
    }

    public int getLevel() {
        return level;
    }

    public int getXP() {
        return xp;
    }

    public void printLvl() {
        System.out.println("XP: " + xp + "/" + xpToNextLevel());
    }
}
