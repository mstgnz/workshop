import java.util.Scanner;

public class Recursive {

    // https://app.patika.dev/moduller/java101/odev-recursive-power
    public static void main(String[] args) {
        int taban, us;

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Taban değeri giriniz : ");
            taban = scanner.nextInt();

            System.out.print("Üs değerini giriniz : ");
            us = scanner.nextInt();

            System.out.println("Sonuç : "+ recursive(taban, us, 1));

        }catch (Exception e){
            System.out.println("Lütfen sayı girin");
        }
    }

    public static int recursive(int taban, int us, int result){
        if(us > 0){
            result *= taban;
            return recursive(taban, us-1, result);
        }
        return result;
    }
}
