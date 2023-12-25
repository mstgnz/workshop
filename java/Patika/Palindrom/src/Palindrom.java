import java.util.Scanner;

public class Palindrom {

    // https://app.patika.dev/moduller/java101/pratik-palindrom

    static int base, number, reversed;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Bir sayı giriniz : ");
            number = scanner.nextInt();
            base = number;

            if(number <= 0){
                System.out.println("Lütfen pozitif bir sayı giriniz.");
                System.exit(0);
            }

            for(;number != 0; number /= 10) {
                int digit = number % 10;
                reversed = reversed * 10 + digit;
            }

            if(base == reversed){
                System.out.println("Girilen sayı palindrom bir sayıdır");
            }else{
                System.out.println("Girilen sayı palindrom bir sayı değildir");
            }

        }catch (Exception e){
            System.out.println("Lütfen bir sayı giriniz!");
            System.exit(0);
        }

    }


}
