/*
package machine;

import java.util.Scanner;

public class CoffeeMachine {

    static int currentCost = 550;
    static int currentWater = 400;
    static int currentMilk = 540;
    static int currentBean = 120;
    static int currentCup = 9;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String choose = "";

        while (!choose.equals("exit")) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            choose = scanner.next();
            switch (choose) {
                case "take":
                    System.out.println("I gave you $"+currentCost);
                    System.out.println();
                    currentCost = 0;
                    break;
                case "fill":
                    fill();
                    break;
                case "buy":
                    buy();
                    break;
                case "remaining":
                    System.out.println();
                    info();
                    break;
            }
        }
    }

    public static void fill(){
        System.out.println("Write how many ml of water you want to add:");
        currentWater += scanner.nextInt();

        System.out.println("Write how many ml of milk you want to add:");
        currentMilk += scanner.nextInt();

        System.out.println("Write how many grams of coffee beans you want to add:");
        currentBean += scanner.nextInt();

        System.out.println("Write how many disposable cups of coffee you want to add:");
        currentCup += scanner.nextInt();
        System.out.println();
    }

    public static void buy(){
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

    public static void info(){
        System.out.println("The coffee machine has:");
        System.out.println(currentWater+" ml of water");
        System.out.println(currentMilk+" ml of milk");
        System.out.println(currentBean+" g of coffee beans");
        System.out.println(currentCup+" disposable cups");
        System.out.println("$"+currentCost+" of money");
        System.out.println();
    }

    public static boolean checkWater(int necessary){
        return currentWater > necessary;
    }

    public static boolean checkMilk(int necessary){
        return currentMilk > necessary;
    }

    public static boolean checkBean(int necessary){
        return currentBean > necessary;
    }

    public static boolean checkCup(){
        return currentCup > 0;
    }

}
*/
