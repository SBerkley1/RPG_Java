public class Ability {
    public enum AbilityType {
        attack, buff, debuff, heal
    }

    private Player player;
    private String abilityName;
    private AbilityType abilityType;
    private int abilityLevel;
    private int abilityEffect; // could be how many rounds ability last, or ability damage
    private boolean isAbilityUnlocked; // is player the correct level to use ability



    public Ability(Player player, String name, AbilityType abilityType, int level, int effect) {
        this.player = player;
        this.abilityName = name;
        this.abilityType = abilityType;
        this.abilityLevel = level;
        this.abilityEffect = effect;
    }


    public String getAbilityName() { return abilityName; }
    public AbilityType getAbilityType() { return abilityType; }
    public int getAbilityLevel() { return abilityLevel; }
    public int getAbilityEffect() { return abilityEffect; }
    public boolean getIsAbilityUnlock() { return player.getLevel() >= abilityLevel; }

    @Override
    public String toString() {
        return this.abilityName + ": " + "\t" + "Effect: " + this.abilityEffect;
    }
}
