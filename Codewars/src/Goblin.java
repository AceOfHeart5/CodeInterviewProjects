public class Goblin {
    final private String NAME_DEFAULT = "Nameless";
    final private int HEIGHT_DEFAULT = 40;
    final private int HEALTH_DEFAULT = 100;

    private String name;
    private int height;
    private int health;

    private static int numOfGolbins = 0;

    public Goblin() {
        setName(NAME_DEFAULT);
        setHeight(HEIGHT_DEFAULT);
        setHealth(HEALTH_DEFAULT);
        announceCreation();
        numOfGolbins++;
    }

    public Goblin(String name, int height, int health) {
        this.name = name;
        this.height = height;
        this.health = health;
        announceCreation();
        numOfGolbins++;
    }

    private void announceCreation() {
        System.out.println(this.name + " is my name! I'm " + this.height +
                " inches high and I have " + health + " hit points!");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public static int getNumOfGolbins() {
        return numOfGolbins;
    }
}
