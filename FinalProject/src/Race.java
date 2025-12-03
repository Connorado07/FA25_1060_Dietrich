// Race.java - Base abstract class
public abstract class Race {
    protected String raceName;
    protected String traits;
    
    public abstract void applyBonuses(CharacterClass character);
    
    public String getRaceName() {
        return raceName;
    }
    
    public String getTraits() {
        return traits;
    }
}


class Human extends Race {
    public Human() {
        this.raceName = "Human";
        this.traits = "+1 to all ability scores, Extra feat at 1st level";
    }
    
    @Override
    public void applyBonuses(CharacterClass character) {
        character.modifyAbilityScore("strength", 1);
        character.modifyAbilityScore("dexterity", 1);
        character.modifyAbilityScore("constitution", 1);
        character.modifyAbilityScore("intelligence", 1);
        character.modifyAbilityScore("wisdom", 1);
        character.modifyAbilityScore("charisma", 1);
    }
}

class Elf extends Race {
    public Elf() {
        this.raceName = "Elf";
        this.traits = "+2 Dexterity, Darkvision, Keen Senses, Fey Ancestry, Trance";
    }
    
    @Override
    public void applyBonuses(CharacterClass character) {
        character.modifyAbilityScore("dexterity", 2);
    }
}

class Dwarf extends Race {
    public Dwarf() {
        this.raceName = "Dwarf";
        this.traits = "+2 Constitution, Darkvision, Dwarven Resilience, Stonecunning";
    }
    
    @Override
    public void applyBonuses(CharacterClass character) {
        character.modifyAbilityScore("constitution", 2);
    }

}

class Halfling extends Race {
    public Halfling() {
        this.raceName = "Halfling";
        this.traits = "+2 Dexterity, Lucky, Brave, Halfling Nimbleness";
    }
    
    @Override
    public void applyBonuses(CharacterClass character) {
        character.modifyAbilityScore("dexterity", 2);
    }
}