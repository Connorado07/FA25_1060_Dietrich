import java.util.Scanner;

public class Main {
    
    /*
    public static void clearConsole() {
        try {
            String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // If clearing fails, just print some blank lines
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }*/
    
    public static void pauseBeforeClear(Scanner scanner) {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
        //clearConsole();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Welcome to D&D Character Creator ===\n");
        
        // Get character name
        System.out.print("Enter your character's name: ");
        String name = scanner.nextLine();
        
        // Choose race
        System.out.println("\nChoose your race:");
        System.out.println("1. Human");
        System.out.println("2. Elf");
        System.out.println("3. Dwarf");
        System.out.println("4. Halfling");
        System.out.print("Enter choice (1-4): ");
        int raceChoice = scanner.nextInt();
        
        Race race = switch (raceChoice) {
            case 1 -> new Human();
            case 2 -> new Elf();
            case 3 -> new Dwarf();
            case 4 -> new Halfling();
            default -> new Human();
        };
        
        // Choose class
        System.out.println("\nChoose your class:");
        System.out.println("1. Fighter");
        System.out.println("2. Wizard");
        System.out.println("3. Rogue");
        System.out.println("4. Cleric");
        System.out.print("Enter choice (1-4): ");
        int classChoice = scanner.nextInt();
        
        CharacterClass character = switch (classChoice) {
            case 1 -> new Fighter(name, race);
            case 2 -> new Wizard(name, race);
            case 3 -> new Rogue(name, race);
            case 4 -> new Cleric(name, race);
            default -> new Fighter(name, race);
        };
        
        // Display character sheet
        System.out.println("\n" + "=".repeat(50));
        character.displayCharacterSheet();
        System.out.println("=".repeat(50));
        
        // Game loop
        boolean playing = true;
        scanner.nextLine(); // consume newline
        
        while (playing) {
            System.out.println("\n--- Actions ---");
            System.out.println("1. Attack with weapon");
            System.out.println("2. Use ability/spell");
            System.out.println("3. View character sheet");
            System.out.println("4. Roll dice");
            System.out.println("5. Exit");
            System.out.print("Choose action: ");
            
            int action = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (action) {
                case 1 -> {
                    character.attackWithWeapon();
                    pauseBeforeClear(scanner);
                }
                case 2 -> {
                    character.useAbility();
                    pauseBeforeClear(scanner);
                }
                case 3 -> {
                    character.displayCharacterSheet();
                    pauseBeforeClear(scanner);
                }
                case 4 -> {
                    System.out.print("Enter number of sides: ");
                    int sides = scanner.nextInt();
                    System.out.print("Enter number of rolls: ");
                    int rolls = scanner.nextInt();
                    scanner.nextLine();
                    Dice dice = new Dice(sides, rolls);
                    System.out.println("Rolling " + rolls + "d" + sides + "...");
                    int result = dice.roll();
                    System.out.println("Result: " + result);
                    pauseBeforeClear(scanner);
                }
                case 5 -> {
                    //clearConsole();
                    System.out.println("Thanks for playing!");
                    playing = false;
                }
                default -> {
                    System.out.println("Invalid action!");
                    pauseBeforeClear(scanner);
                }
            }
        }
        
        scanner.close();
    }
}