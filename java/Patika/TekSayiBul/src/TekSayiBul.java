import java.util.Scanner;

public class TekSayiBul {

    // https://app.patika.dev/moduller/java101/pratik-tek-sayi-toplam
    public static void main(String[] args) {
        int total = 0;
        int number;
        boolean single = false;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Çıkmak için negatif bir sayı giriniz.");

        try {
            do {
                System.out.print("Çift sayı giriniz : ");
                number = scanner.nextInt();

                if(number % 2 == 1){
                    single = true;
                }
                if(!single && number % 4 == 0){
                    System.out.println(number);
                    total += number;
                }

            }while(!single);

            System.out.println("Girilen çift ve 4'ün katı sayıların toplamı : "+ total);

        }catch (Exception e){
            System.out.println("Lütfen sadece sayı giriniz");
        }
    }
}
