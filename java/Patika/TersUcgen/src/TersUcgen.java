import java.util.Scanner;

public class TersUcgen {

    // https://app.patika.dev/moduller/java101/odev-ters-ucgen
    public static void main(String[] args) {
        int number;

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Bir sayı giriniz : ");
            number = scanner.nextInt();

            if(number <= 0){
                System.out.println("pozitif bir sayı giriniz");
                System.exit(0);
            }

            for (int i = number; i >= 0; i--) {
                for (int j = (number - i); j > 0; j--) {
                    System.out.print(" ");
                }
                for (int j = (2 * i +1); j > 1; j--) {
                    System.out.print("*");
                }
                System.out.println(" ");
            }

        }catch (Exception e){
            System.out.println("lütfen sadece sayı giriniz");
        }
    }
}
