import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        CharacterFactory characterFactory = new GeneralCharacterFactory();
        GameCharacter humanWarrior = (GameCharacter) characterFactory.createCharacter("Human Warrior", 0, 0, 0);
        GameCharacter elfMage = (GameCharacter) characterFactory.createCharacter("Elf Mage", 0, 0, 0);


        System.out.println("Human Warrior Stats:");
        humanWarrior.displayStats();

        System.out.println("Elf Mage Stats:");
        elfMage.displayStats();


        int remainingPoints = 100;
        int level = 1;
        int lives = level * 10;
        int experiencePoints = 0;

        // Game loop
        while (true) {
            System.out.println("Remaining points: " + remainingPoints);
            System.out.println("Level: " + level);
            System.out.println("Lives: " + lives);
            System.out.println("Experience Points: " + experiencePoints);

            System.out.println("1. Level up");
            System.out.println("2. Allocate attribute points");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (experiencePoints >= 100 * level) {
                        experiencePoints -= 100 * level;
                        remainingPoints += 3;
                        level++;
                        lives = level * 10;
                        System.out.println("Leveled up to level " + level);
                    } else {
                        System.out.println("Not enough experience points to level up.");
                    }
                    break;
                case 2:
                    if (remainingPoints > 0) {
                        System.out.println("Choose attribute to allocate points:");
                        System.out.println("1. Strength");
                        System.out.println("2. Intelligence");
                        System.out.println("3. Agility");

                        int attributeChoice = scanner.nextInt();
                        int attributePoints;

                        switch (attributeChoice) {
                            case 1:
                                System.out.println("Enter points to allocate for Strength:");
                                attributePoints = scanner.nextInt();
                                humanWarrior.allocateAttributePoints(attributePoints, 0, 0);
                                remainingPoints -= attributePoints;
                                break;
                            case 2:
                                System.out.println("Enter points to allocate for Intelligence:");
                                attributePoints = scanner.nextInt();
                                humanWarrior.allocateAttributePoints(0, attributePoints, 0);
                                remainingPoints -= attributePoints;
                                break;
                            case 3:
                                System.out.println("Enter points to allocate for Agility:");
                                attributePoints = scanner.nextInt();
                                humanWarrior.allocateAttributePoints(0, 0, attributePoints);
                                remainingPoints -= attributePoints;
                                break;
                            default:
                                System.out.println("Invalid choice.");
                        }
                    } else {
                        System.out.println("No remaining points to allocate.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting game...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}