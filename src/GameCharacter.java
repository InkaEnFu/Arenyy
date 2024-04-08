class GameCharacter implements Character {
    private String name;
    private int strength;
    private int intelligence;
    private int agility;

    public GameCharacter(String name, int strength, int intelligence, int agility) {
        this.name = name;
        this.strength = strength;
        this.intelligence = intelligence;
        this.agility = agility;
    }

    @Override
    public void displayStats() {
        System.out.println("Name: " + name);
        System.out.println("Strength: " + strength);
        System.out.println("Intelligence: " + intelligence);
        System.out.println("Agility: " + agility);
    }

    public void allocateAttributePoints(int strengthPoints, int intelligencePoints, int agilityPoints) {
        this.strength += strengthPoints;
        this.intelligence += intelligencePoints;
        this.agility += agilityPoints;
    }
}