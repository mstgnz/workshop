package weapon;

public class Weapon {
    private int id;
    private String name;
    private int damage;
    private int money;

    public Weapon(int id, String name, int damage, int money) {
        this.id = id;
        this.name = name;
        this.damage = damage;
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

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    /*public static String getWeapons() {
        return (
            String.format("%-8s%-20s%-15s%-10s%n", "ID: 1", "Name: Sword", "Damage: 4", "Money: 6") +
            String.format("%-8s%-20s%-15s%-10s%n", "ID: 2", "Name: Hatchet", "Damage: 5" ,"Money: 8") +
            String.format("%-8s%-20s%-15s%-10s%n", "ID: 3", "Name: Arrow", "Damage: 4", "Money: 8") +
            String.format("%-8s%-20s%-15s%-10s%n", "ID: 4", "Name: Gun", "Damage: 6", "Money: 10")
        );
    }*/

    public static Weapon[] getWeapons(){
        Weapon[] weapons = new Weapon[4];
        weapons[0] = new Weapon(1, "Sword", 4, 6);
        weapons[1] = new Weapon(2, "Hatchet", 5, 8);
        weapons[2] = new Weapon(3, "Arrow", 4, 8);
        weapons[3] = new Weapon(4, "Gun", 6, 10);
        return weapons;
    }
}
