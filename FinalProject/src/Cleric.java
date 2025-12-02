class Cleric extends CharacterClass {
    public Cleric(String name, Race race) {
        super(name, race);
    }
    
    @Override
    protected void initializeClass() {
        // Clerics have medium HP
        this.maxHitPoints = 8 + getModifier(constitution);
        this.hitPoints = maxHitPoints;
        
        // Add starting weapons
        addWeapon(new Weapon("Mace", "Mace", new Dice(6, 1)));
        addWeapon(new Weapon("Warhammer", "Hammer", new Dice(8, 1)));
        
        // Add cleric spells
        addAbility(new Ability("Cure Wounds", "Heal a creature for 1d8 + Wisdom modifier",
            character -> {
                Dice healDice = new Dice(8, 1);
                int healing = healDice.roll() + character.getModifier(character.wisdom());
                System.out.println(character.getName() + " casts Cure Wounds and heals " + 
                                 healing + " HP!");
            }));
        
        addAbility(new Ability("Sacred Flame", "Deal 1d8 radiant damage",
            character -> {
                Dice damageDice = new Dice(8, 1);
                int damage = damageDice.roll();
                System.out.println(character.getName() + " casts Sacred Flame for " + 
                                 damage + " radiant damage!");
            }));
        
        addAbility(new Ability("Bless", "Grant allies +1d4 to attack rolls and saving throws",
            character -> {
                System.out.println(character.getName() + " casts Bless on the party!");
            }));
    }
    
    @Override
    public String getClassName() {
        return "Cleric";
    }
}