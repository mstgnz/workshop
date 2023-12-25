import java.util.ArrayList;
import java.util.Scanner;

public class Armstrong {

    // https://app.patika.dev/moduller/java101/pratik-armstrong-1

    static int number;
    static int result = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Bir sayı giriniz : ");
            number = scanner.nextInt();

            if(number <= 0){
                System.out.println("Lütfen pozitif bir sayı giriniz!");
                System.exit(0);
            }

            basamakToplam();

        }catch (Exception e){
            System.out.println("Lütfen geçerli bir sayı giriniz!");
        }

    }

    public static void basamakToplam(){
        recursive(number);
        System.out.println(result);
    }

    public static void recursive(int number){
        result += number % 10;
        if(number > 10){
            recursive(number / 10);
        }
    }
}
