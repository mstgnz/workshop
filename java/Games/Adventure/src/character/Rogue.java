package character;

public class Rogue extends GameChar {

    public Rogue() {
        super("Rogue",15, 14, 15);
    }

    public static String getString() {
        return String.format("%-30s%-15s%-15s%-15s", "Character Name: Rogue", "Damage: 11","Health: 14","Money: 15");
    }

}
