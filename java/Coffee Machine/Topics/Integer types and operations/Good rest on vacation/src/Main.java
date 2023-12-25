import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int day = scanner.nextInt();
        int food = scanner.nextInt();
        int flight = scanner.nextInt();
        int hotel = scanner.nextInt();

        int result = (day * (food + hotel)) + (flight * 2) - hotel;

        System.out.println(result);
    }
}
