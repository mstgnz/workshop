import java.util.Scanner;

public class Harmonik {

    // https://app.patika.dev/moduller/java101/pratik-harmonic
    public static void main(String[] args) {

        int number;
        double result = 0;

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Bir sayı giriniz : ");
            number = scanner.nextInt();

            if(number <= 0){
                System.out.println("Lütfen pozitif bir sayı giriniz");
                System.exit(0);
            }

            for (double i = 1; i < number; i++) {
                result += (1/i);
            }

            System.out.println(number + " sayısının harmonik değeri : "+ result);

        }catch (Exception e){
            System.out.println("Lütfen sayı giriniz!");
        }


    }
}
