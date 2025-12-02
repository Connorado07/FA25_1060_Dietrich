import java.util.function.Consumer;

public class Ability {
    private String name;
    private String description;
    private Consumer<CharacterClass> effect;
    
    public Ability(String name, String description, Consumer<CharacterClass> effect) {
        this.name = name;
        this.description = description;
        this.effect = effect;
    }
    
    public void use(CharacterClass character) {
        System.out.println("\n" + character.getName() + " uses " + name + "!");
        effect.accept(character);
    }
    
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    @Override
    public String toString() {
        return name + ": " + description;
    }
}