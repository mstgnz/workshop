import java.util.Scanner;

public class RacursiveAsal {

    // https://app.patika.dev/moduller/java101/odev-recursive-prime
    public static void main(String[] args) {
        int number;

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Bir sayı giriniz : ");
            number = scanner.nextInt();

            if (number <= 0){
                System.out.println("lütfen pozitif bir sayı girin");
                System.exit(0);
            }

            if(checkRecursive(number, 2)){
                System.out.println("Girdiğiniz sayı asal bir sayıdır");
            }else{
                System.out.println("Girilen sayı asal bir sayı değildir.");
            }

        }catch (Exception e){
            System.out.println("Lütfen sayı girin");
        }
    }

    public static boolean checkRecursive(int number, int loop){
        if (number == 2) return true;
        if (number % loop == 0) return false;
        if(loop < number -1){
            return checkRecursive(number, loop+1);
        }
        return true;
    }
}
