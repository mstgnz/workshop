package armor;

public class Armor {
    private int id;
    private String name;
    private int absorb;
    private int money;

    public Armor(int id, String name, int absorb, int money) {
        this.id = id;
        this.name = name;
        this.absorb = absorb;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAbsorb() {
        return absorb;
    }

    public void setAbsorb(int absorb) {
        this.absorb = absorb;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public static Armor[] getArmors(){
        Armor[] armors = new Armor[4];
        armors[0] = new Armor(1, "DeathBone", 4,5);
        armors[1] = new Armor(2, "LightForged", 5,7);
        armors[2] = new Armor(3, "TerrorBlade", 6,9);
        armors[3] = new Armor(4, "Ancestral", 7,10);
        return armors;
    }
}
