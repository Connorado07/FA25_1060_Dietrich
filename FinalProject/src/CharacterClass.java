import java.util.ArrayList;
import java.util.List;

public abstract class CharacterClass {
    protected String name;
    protected Race race;
    protected int level;
    protected int hitPoints;
    protected int maxHitPoints;
    protected List<Weapon> weapons;
    protected List<Ability> abilities;
    
    // Ability scores
    protected int strength;
    protected int dexterity;
    protected int constitution;
    protected int intelligence;
    protected int wisdom;
    protected int charisma;
    
    public CharacterClass(String name, Race race) {
        this.name = name;
        this.race = race;
        this.level = 1;
        this.weapons = new ArrayList<>();
        this.abilities = new ArrayList<>();
        
        // Initialize base stats (will be modified by race and class)
        rollAbilityScores();
        applyRacialBonuses();
        initializeClass();
    }
    
    protected void rollAbilityScores() {
        // Roll 4d6, drop lowest for each ability
        strength = rollAbility();
        dexterity = rollAbility();
        constitution = rollAbility();
        intelligence = rollAbility();
        wisdom = rollAbility();
        charisma = rollAbility();
    }
    
    private int rollAbility() {
        @SuppressWarnings("unused")
        Dice d6 = new Dice(6, 4);
        int[] rolls = new int[4];
        int min = 6;
        int total = 0;
        
        for (int i = 0; i < 4; i++) {
            rolls[i] = new Dice(6, 1).roll();
            total += rolls[i];
            if (rolls[i] < min) min = rolls[i];
        }
        
        return total - min;
    }
    
    protected void applyRacialBonuses() {
        race.applyBonuses(this);
    }
    
    protected abstract void initializeClass();
    
    public void addWeapon(Weapon weapon) {
        weapons.add(weapon);
    }
    
    public void addAbility(Ability ability) {
        abilities.add(ability);
    }
    
    public void attackWithWeapon() {
        if (weapons.isEmpty()) {
            System.out.println(name + " has no weapons!");
            return;
        }
        
        System.out.println("\nAvailable weapons:");
        for (int i = 0; i < weapons.size(); i++) {
            System.out.println((i + 1) + ". " + weapons.get(i).getName() + 
                             " (" + weapons.get(i).getWeaponType() + ")");
        }
        
        // For simplicity, attack with first weapon
        Weapon weapon = weapons.get(0);
        int damage = weapon.rollDamage();
        System.out.println(name + " attacks with " + weapon.getName() + 
                         " for " + damage + " damage!");
    }
    
    public void useAbility() {
        if (abilities.isEmpty()) {
            System.out.println(name + " has no abilities!");
            return;
        }
        
        System.out.println("\nAvailable abilities:");
        for (int i = 0; i < abilities.size(); i++) {
            System.out.println((i + 1) + ". " + abilities.get(i).getName());
        }
        
        // For simplicity, use first ability
        Ability ability = abilities.get(0);
        ability.use(this);
    }
    
    public void displayCharacterSheet() {
        System.out.println("\n=== Character Sheet ===");
        System.out.println("Name: " + name);
        System.out.println("Race: " + race.getRaceName());
        System.out.println("Class: " + getClassName());
        System.out.println("Level: " + level);
        System.out.println("HP: " + hitPoints + "/" + maxHitPoints);
        System.out.println("\n--- Ability Scores ---");
        System.out.println("Strength: " + strength + " (+" + getModifier(strength) + ")");
        System.out.println("Dexterity: " + dexterity + " (+" + getModifier(dexterity) + ")");
        System.out.println("Constitution: " + constitution + " (+" + getModifier(constitution) + ")");
        System.out.println("Intelligence: " + intelligence + " (+" + getModifier(intelligence) + ")");
        System.out.println("Wisdom: " + wisdom + " (+" + getModifier(wisdom) + ")");
        System.out.println("Charisma: " + charisma + " (+" + getModifier(charisma) + ")");
        
        System.out.println("\n--- Weapons ---");
        for (Weapon w : weapons) {
            System.out.println("- " + w.getName() + " (" + w.getWeaponType() + ")");
        }
        
        System.out.println("\n--- Abilities/Spells ---");
        for (Ability a : abilities) {
            System.out.println("- " + a.getName() + ": " + a.getDescription());
        }
        
        System.out.println("\n--- Racial Traits ---");
        System.out.println(race.getTraits());
    }
    
    protected int getModifier(int abilityScore) {
        return (abilityScore - 10) / 2;
    }
    
    public abstract String getClassName();
    
    // Getters and setters
    public void modifyAbilityScore(String ability, int modifier) {
        switch (ability.toLowerCase()) {
            case "strength" -> strength += modifier;
            case "dexterity" -> dexterity += modifier;
            case "constitution" -> constitution += modifier;
            case "intelligence" -> intelligence += modifier;
            case "wisdom" -> wisdom += modifier;
            case "charisma" -> charisma += modifier;
        }
    }
    
    public String getName() { return name; }
    public int getStrength() { return strength; }
    public int getDexterity() { return dexterity; }
    public int getIntelligence() { return intelligence; }
    public int level() { return level; }
    public int wisdom() { return wisdom; }
}