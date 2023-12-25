import java.util.Scanner;

public class VucutKitle {
    // https://app.patika.dev/moduller/java101/odev-vucut-kitle-hesaplama
    public static void main(String[] args) {
        int kilo;
        double boy;

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Lütfen kilonuzu giriniz : ");
            kilo = scanner.nextInt();

            System.out.print("Lütfen boyunuzu (metre cinsinde) giriniz : ");
            boy = scanner.nextDouble();

            System.out.println("Vücut kitle enteksiniz : "+ (kilo / (boy *boy)));
        }catch (Exception e){
            System.out.println("Lütfen bilgileri doğru giriniz!");
        }
    }
}
