package character;

public class Hunter extends GameChar {

    public Hunter() {
        super("Hunter",11, 16, 22);
    }

    public static String getString() {
        return String.format("%-30s%-15s%-15s%-15s", "Character Name: Hunter", "Damage: 8","Health: 16","Money: 22");
    }
}
