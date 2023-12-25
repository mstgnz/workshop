import java.util.Scanner;

public class MukemmelSayi {

    // https://app.patika.dev/moduller/java101/odev-mukemmel-sayi
    public static void main(String[] args) {
        int number;
        int result = 0;

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Bir sayı giriniz : ");
            number = scanner.nextInt();

            if (number <= 0){
                System.out.println("lütfen pozitif bir sayı girin");
                System.exit(0);
            }

            for (int i = 1; i < number ; i++) {
                if(number % i == 0){
                    result += i;
                }
            }

            if(result == number){
                System.out.println(number + " mükemmel bir sayıdır");
            }else{
                System.out.println(number + " mükemmel bir sayı değildir.");
            }

        }catch (Exception e){
            System.out.println("Lütfen sayı girin");
        }

    }
}
