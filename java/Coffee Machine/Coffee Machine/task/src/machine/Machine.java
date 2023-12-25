package machine;

import java.util.Scanner;

public class Machine {

    private int currentCost;
    private int currentWater;
    private int currentMilk;
    private int currentBean;
    private int currentCup;
    private final Scanner scanner;

    public Machine(int currentCost, int currentWater, int currentMilk, int currentBean, int currentCup, Scanner scanner) {
        this.currentCost = currentCost;
        this.currentWater = currentWater;
        this.currentMilk = currentMilk;
        this.currentBean = currentBean;
        this.currentCup = currentCup;
        this.scanner = scanner;
    }

    public void take(){
        System.out.println("I gave you $"+this.currentCost);
        System.out.println();
        this.currentCost = 0;
    }

    public void buy(){
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String choose = scanner.next();
        System.out.println();
        switch (choose) {
            case "1":
                if (!checkWater(250)) {
                    System.out.println("Sorry, not enough water!");
                    System.out.println();
                    return;
                }
                if (!checkBean(16)) {
                    System.out.println("Sorry, not enough bean!");
                    System.out.println();
                    return;
                }
                if (!checkCup()) {
                    System.out.println("Sorry, not enough cup!");
                    System.out.println();
                    return;
                }
                currentWater -= 250;
                currentBean -= 16;
                currentCup -= 1;
                currentCost += 4;
                System.out.println("I have enough resources, making you a coffee!");
                break;
            case "2":
                if (!checkWater(350)) {
                    System.out.println("Sorry, not enough water!");
                    System.out.println();
                    return;
                }
                if (!checkMilk(75)) {
                    System.out.println("Sorry, not enough milk!");
                    System.out.println();
                    return;
                }
                if (!checkBean(20)) {
                    System.out.println("Sorry, not enough bean!");
                    System.out.println();
                    return;
                }
                if (!checkCup()) {
                    System.out.println("Sorry, not enough cup!");
                    System.out.println();
                    return;
                }
                currentWater -= 350;
                currentMilk -= 75;
                currentBean -= 20;
                currentCup -= 1;
                currentCost += 7;
                System.out.println("I have enough resources, making you a coffee!");

                break;
            case "3":
                if (!checkWater(200)) {
                    System.out.println("Sorry, not enough water!");
                    System.out.println();
                    return;
                }
                if (!checkMilk(100)) {
                    System.out.println("Sorry, not enough milk!");
                    System.out.println();
                    return;
                }
                if (!checkBean(12)) {
                    System.out.println("Sorry, not enough bean!");
                    System.out.println();
                    return;
                }
                if (!checkCup()) {
                    System.out.println("Sorry, not enough cup!");
                    System.out.println();
                    return;
                }
                currentWater -= 200;
                currentMilk -= 100;
                currentBean -= 12;
                currentCup -= 1;
                currentCost += 6;
                System.out.println("I have enough resources, making you a coffee!");
                break;
            default:
                break;
        }
        System.out.println();
    }

    public void fill(){
        System.out.println("Write how many ml of water you want to add:");
        this.currentWater += this.scanner.nextInt();

        System.out.println("Write how many ml of milk you want to add:");
        this.currentMilk += this.scanner.nextInt();

        System.out.println("Write how many grams of coffee beans you want to add:");
        this.currentBean += this.scanner.nextInt();

        System.out.println("Write how many disposable cups of coffee you want to add:");
        this.currentCup += this.scanner.nextInt();
        System.out.println();
    }

    public boolean checkWater(int necessary){
        return this.currentWater > necessary;
    }

    public boolean checkMilk(int necessary){
        return this.currentMilk > necessary;
    }

    public boolean checkBean(int necessary){
        return this.currentBean > necessary;
    }

    public boolean checkCup(){
        return this.currentCup > 0;
    }

    public void info(){
        System.out.println("The coffee machine has:");
        System.out.println(this.currentWater+" ml of water");
        System.out.println(this.currentMilk+" ml of milk");
        System.out.println(this.currentBean+" g of coffee beans");
        System.out.println(this.currentCup+" disposable cups");
        System.out.println("$"+this.currentCost+" of money");
        System.out.println();
    }
}
