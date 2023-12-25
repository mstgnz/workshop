package game;

import armor.Armor;
import character.*;
import player.Player;
import weapon.Weapon;

import java.util.Scanner;

public class Game {

    private final Scanner scanner = new Scanner(System.in);
    private Player player;

    public void start(){
        // initialize
        this.initialize();
        // choose character
        //this.chooseCharacter();
        // choose weapon
        //this.chooseWeapon();
        // choose armor
        //this.chooseArmor();

    }

    private void initialize(){
        System.out.println("Welcome to Adventure Game!");
        System.out.print("Enter the Name Please: ");
        String playerName = this.scanner.nextLine();
        this.player = new Player(playerName);
        System.out.println("Dear " + this.player.getName() + ", Let's Get Started.");
    }

    private void chooseCharacter(){
        String[] gameChars = {Hunter.getString(), Paladin.getString(), Rogue.getString(), Warlock.getString()};
        System.out.println("Character Lists");
        int row = 1;
        for (String gameChar: gameChars) {
            System.out.println(row+": "+gameChar);
            row++;
        }
        System.out.print("Enter the Character ID: ");
        int num = this.scanner.nextInt();
        switch (num) {
            case 1 -> this.player.setGameChar(new Hunter());
            case 2 -> this.player.setGameChar(new Paladin());
            case 3 -> this.player.setGameChar(new Rogue());
            case 4 -> this.player.setGameChar(new Warlock());
            default -> {this.player.setGameChar(new Hunter());}
        }
    }

    private void chooseWeapon(){
        System.out.println("Weapon Lists");
        for (Weapon weapon: Weapon.getWeapons()) {
            System.out.format("%-8s%-20s%-15s%-10s%n","ID: "+weapon.getId(), "Name: "+weapon.getName(), "Damage: "+weapon.getDamage(), "Money: "+weapon.getMoney());
        }
        System.out.print("Enter the Weapon ID: ");
        int num = this.scanner.nextInt();
        switch (num) {
            case 1 -> this.player.setWeapon(Weapon.getWeapons()[0]);
            case 2 -> this.player.setWeapon(Weapon.getWeapons()[1]);
            case 3 -> this.player.setWeapon(Weapon.getWeapons()[2]);
            case 4 -> this.player.setWeapon(Weapon.getWeapons()[3]);
            default -> {this.player.setWeapon(Weapon.getWeapons()[0]);}
        }
    }

    private void chooseArmor(){
        System.out.println("Armor Lists");
        for (Armor armor: Armor.getArmors()) {
            System.out.format("%-8s%-20s%-15s%-10s%n","ID: "+armor.getId(), "Name: "+armor.getName(), "Absorb: "+armor.getAbsorb(), "Money: "+armor.getMoney());
        }
        System.out.print("Enter the Armor ID: ");
        int id = this.scanner.nextInt();
        switch (id) {
            case 1 -> this.player.setArmor(Armor.getArmors()[0]);
            case 2 -> this.player.setArmor(Armor.getArmors()[1]);
            case 3 -> this.player.setArmor(Armor.getArmors()[2]);
            case 4 -> this.player.setArmor(Armor.getArmors()[3]);
            default -> {this.player.setArmor(Armor.getArmors()[0]);}
        }
    }
}
