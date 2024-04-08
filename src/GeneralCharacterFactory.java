import java.util.Scanner;

class GeneralCharacterFactory implements CharacterFactory {
    @Override
    public Character createCharacter(String name, int strength, int intelligence, int agility) {
        System.out.println("Creating character...");

        // Determine the type of character based on provided parameters
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose the race for the character:");
        System.out.println("1. Human");
        System.out.println("2. Elf");
        System.out.println("3. Dwarf");
        System.out.println("4. Troll");
        System.out.println("5. DarkElf");
        System.out.println("6. Undead");

        int raceChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Choose the class for the character:");
        System.out.println("1. Warrior");
        System.out.println("2. Mage");
        System.out.println("3. Scout");

        int classChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Modify attributes based on race
        switch (raceChoice) {
            case 1: // Human
                strength += 3;
                intelligence += 3;
                agility += 4;
                break;
            case 2: // Elf
                intelligence += 6;
                agility += 4;
                break;
            case 3: // Dwarf
                strength += 7;
                agility += 3;
                break;
            case 4: // Troll
                strength += 10;
                break;
            case 5: // DarkElf
                intelligence += 4;
                agility += 6;
                break;
            case 6: // Undead
                intelligence += 10;
                break;
            default:
                System.out.println("Invalid choice. Creating a default character...");
        }

        // Modify attributes based on class
        switch (classChoice) {
            case 1: // Warrior
                strength += 3;
                break;
            case 2: // Mage
                intelligence += 3;
                break;
            case 3: // Scout
                agility += 3;
                break;
            default:
                System.out.println("Invalid choice. Creating a default character...");
        }

        return new GameCharacter(name, strength, intelligence, agility);
    }
}
