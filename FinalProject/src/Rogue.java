class Rogue extends CharacterClass {
    public Rogue(String name, Race race) {
        super(name, race);
    }
    
    @Override
    protected void initializeClass() {
        // Rogues have medium HP
        this.maxHitPoints = 8 + getModifier(constitution);
        this.hitPoints = maxHitPoints;
        
        // Add starting weapons
        addWeapon(new Weapon("Rapier", "Sword", new Dice(8, 1)));
        addWeapon(new Weapon("Shortbow", "Bow", new Dice(6, 1)));
        addWeapon(new Weapon("Dagger", "Dagger", new Dice(4, 1)));
        
        // Add rogue abilities
        addAbility(new Ability("Sneak Attack", "Deal extra 1d6 damage when you have advantage",
            character -> {
                Dice sneakDice = new Dice(6, 1);
                int damage = sneakDice.roll();
                System.out.println(character.getName() + " performs a Sneak Attack for an extra " + 
                                 damage + " damage!");
            }));
        
        addAbility(new Ability("Cunning Action", "Dash, Disengage, or Hide as a bonus action",
            character -> {
                System.out.println(character.getName() + " uses Cunning Action!");
            }));
    }
    
    @Override
    public String getClassName() {
        return "Rogue";
    }
}
