package character;

public class Warlock extends GameChar {

    public Warlock() {
        super("Warlock",11, 21, 21);
    }

    public static String getString() {
        return String.format("%-30s%-15s%-15s%-15s", "Character Name: Warlock", "Damage: 7","Health: 21","Money: 21");
    }

}
