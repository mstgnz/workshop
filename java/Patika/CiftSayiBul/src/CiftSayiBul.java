import java.util.Scanner;

public class CiftSayiBul {
    // https://app.patika.dev/moduller/java101/pratik-cift-sayi-toplam
    public static void main(String[] args) {
        int number = 0;
        int result = 0;
        int loop = 0;

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Bir Sayı giriniz : ");
            number = scanner.nextInt();
            if(number < 1){
                System.out.println("Lütfen 1'den büyük bir sayı giriniz!");
                System.exit(0);
            }

            // For ile
            for (int i = 0; i <= number ; i++) {
                if(i % 3 == 0 && i % 4 == 0){
                    result += i;
                    loop += 1;
                }
            }

            // While ile
            int i = 0;
            while (i <= number){
                if(i % 3 == 0 && i % 4 == 0){
                    result += i;
                    loop += 1;
                }
                i++;
            }

            System.out.println("3 ve 4'e tam bölünen sayıların ortalaması : "+ (result / loop));

        }catch (Exception e){
            System.out.println("Lütfen sadece bir sayı giriniz");
        }
    }
}
