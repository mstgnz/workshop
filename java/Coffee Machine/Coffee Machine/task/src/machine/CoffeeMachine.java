package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Machine machine = new Machine(550,400,540,120,9, scanner);

        String choose = "";

        while (!choose.equals("exit")) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            choose = scanner.next();
            switch (choose) {
                case "take":
                    machine.take();
                    break;
                case "fill":
                    machine.fill();
                    break;
                case "buy":
                    machine.buy();
                    break;
                case "remaining":
                    machine.info();
                    break;
            }
        }
    }

}
