public class Weapon {
    private String name;
    private String weaponType;
    private Dice damageDice;
    
    public Weapon(String name, String weaponType, Dice damageDice) {
        this.name = name;
        this.weaponType = weaponType;
        this.damageDice = damageDice;
    }
    
    public int rollDamage() {
        return damageDice.roll();
    }
    
    public String getName() {
        return name;
    }
    
    public String getWeaponType() {
        return weaponType;
    }
    
    public Dice getDamageDice() {
        return damageDice;
    }
    
    @Override
    public String toString() {
        return name + " (" + weaponType + ") - Damage: " + 
               damageDice.getNumRolls() + "d" + damageDice.getNumSides();
    }
}