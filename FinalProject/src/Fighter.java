class Fighter extends CharacterClass {
    public Fighter(String name, Race race) {
        super(name, race);
    }
    
    @Override
    protected void initializeClass() {
        // Fighters have high HP
        this.maxHitPoints = 10 + getModifier(constitution);
        this.hitPoints = maxHitPoints;
        
        // Add starting weapons
        addWeapon(new Weapon("Longsword", "Sword", new Dice(8, 1)));
        addWeapon(new Weapon("Shortbow", "Bow", new Dice(6, 1)));
        
        // Add fighter abilities
        addAbility(new Ability("Second Wind", "Heal yourself for 1d10 + fighter level", 
            character -> {
                Dice healDice = new Dice(10, 1);
                int healing = healDice.roll() + character.level();
                System.out.println(character.getName() + " uses Second Wind and heals " + 
                                 healing + " HP!");
            }));
        
        addAbility(new Ability("Action Surge", "Take an additional action on your turn",
            character -> {
                System.out.println(character.getName() + " uses Action Surge!");
            }));
    }
    
    @Override
    public String getClassName() {
        return "Fighter";
    }
}