package character;

public class Paladin extends GameChar {

    public Paladin() {
        super("Paladin",13,15,19);
    }

    public static String getString() {
        return String.format("%-30s%-15s%-15s%-15s", "Character Name: Paladin", "Damage: 9","Health: 15","Money: 19");
    }

}
