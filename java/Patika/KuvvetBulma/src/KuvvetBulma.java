import java.util.Scanner;

public class KuvvetBulma {

    // https://app.patika.dev/moduller/java101/pratik-two-power
    public static void main(String[] args) {
        int sayi = 0;

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Bir sayı giriniz : ");
            sayi = scanner.nextInt();

            if(sayi <= 0){
                System.out.println("Lütfen pozitif bir sayı giriniz.");
                System.exit(0);
            }

        }catch (Exception e){
            System.out.println("Lütfen bir sayı giriniz!");
            System.exit(0);
        }

        for (int i = 1; i <= sayi; i*=4, i*=5) {
            System.out.println(i);
        }

    }
}
