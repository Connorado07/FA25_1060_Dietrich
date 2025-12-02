class Wizard extends CharacterClass {
    public Wizard(String name, Race race) {
        super(name, race);
    }
    
    @Override
    protected void initializeClass() {
        // Wizards have lower HP
        this.maxHitPoints = 6 + getModifier(constitution);
        this.hitPoints = maxHitPoints;
        
        // Add starting weapon
        addWeapon(new Weapon("Quarterstaff", "Staff", new Dice(6, 1)));
        addWeapon(new Weapon("Dagger", "Dagger", new Dice(4, 1)));
        
        // Add wizard spells
        addAbility(new Ability("Magic Missile", "Auto-hit spell that deals 3d4+3 force damage",
            character -> {
                Dice damageDice = new Dice(4, 3);
                int damage = damageDice.roll() + 3;
                System.out.println(character.getName() + " casts Magic Missile for " + 
                                 damage + " force damage!");
            }));
        
        addAbility(new Ability("Fireball", "Explosive spell dealing 8d6 fire damage",
            character -> {
                Dice damageDice = new Dice(6, 8);
                int damage = damageDice.roll();
                System.out.println(character.getName() + " casts Fireball for " + 
                                 damage + " fire damage!");
            }));
        
        addAbility(new Ability("Shield", "Gain +5 AC until your next turn",
            character -> {
                System.out.println(character.getName() + " casts Shield! AC increased by 5.");
            }));
    }
    
    @Override
    public String getClassName() {
        return "Wizard";
    }
}