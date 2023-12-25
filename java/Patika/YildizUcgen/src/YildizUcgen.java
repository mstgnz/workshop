import java.util.Scanner;

public class YildizUcgen {

    // https://app.patika.dev/moduller/java101/pratik-yildiz-ucgen
    public static void main(String[] args) {
       int number;

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("bir sayı giriniz : ");
            number = scanner.nextInt();

            if(number <= 0){
                System.out.println("pozitif bir sayı giriniz.");
                System.exit(0);
            }

            for (int i = 0; i < number; i++) {
                for (int j = 0; j < (number - i); j++) {
                    System.out.print(" ");
                }
                for (int j = 1; j < (2 * i +1); j++) {
                    System.out.print("*");
                }
                System.out.println(" ");
            }

            for (int i = number; i > 0; i--) {
                for (int j = (number - i); j > 0; j--) {
                    System.out.print(" ");
                }
                for (int j = (2 * i +1); j > 1; j--) {
                    System.out.print("*");
                }
                System.out.println(" ");
            }



        }catch (Exception e){
            System.out.println("Sayı giriniz!");
        }
    }
}
