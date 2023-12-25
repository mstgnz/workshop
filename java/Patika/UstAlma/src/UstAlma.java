import java.util.Scanner;

public class UstAlma {

    // https://app.patika.dev/moduller/java101/pratik-uslu-sayi
    public static void main(String[] args) {
        int number = 0;
        int coefficient = 0;
        int total = 1;

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Üst alınacak sayıyı giriniz : ");
            number = scanner.nextInt();

            System.out.print("Sayının üssünü giriniz : ");
            coefficient = scanner.nextInt();

        }catch (Exception e){
            System.out.println("Lütfen doğru bilgi giriniz!");
            System.exit(0);
        }

        if(number <=0 || coefficient <= 0){
            System.out.println("Lütfen pozitif bir sayı girirniz!");
            System.exit(0);
        }

        for (int i = 1; i <= coefficient; i++) {
            total *= number;
        }

        System.out.println("Girilen sayının üst hesabı : "+ total);

    }
}
