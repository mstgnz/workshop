import java.util.Scanner;

public class HesapMakinesi {
    // https://app.patika.dev/moduller/java101/pratik-hesap-mak-1

    static double sayi1;
    static double sayi2;
    static int islem;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Toplama İşlemi için (1'e basınız)");
            System.out.println("Çıkarma İşlemi için (2'e basınız)");
            System.out.println("Çarpma İşlemi için (3'e basınız)");
            System.out.println("Bölme İşlemi için (4'e basınız)");
            System.out.print("İşlem Seçiniz : ");
            islem = scanner.nextInt();

            System.out.print("1.Sayıyı giriniz : ");
            sayi1 = scanner.nextDouble();

            System.out.print("2.Sayıyı giriniz : ");
            sayi2 = scanner.nextDouble();

            islemYap();
        }catch (Exception e){
            System.out.println("Lütfen bilgileri doğru giriniz!");
        }

    }

    public static void islemYap(){
        switch (islem){
            case 1: // Toplama
                System.out.println("1.Sayı "+sayi1+"ile "+"2.Sayı "+sayi2+" toplamı : " + (sayi1 + sayi2));
                break;
            case 2:  // Çıkarma
                System.out.println("1.Sayı "+sayi1+"ile "+"2.Sayı "+sayi2+" farkı : " + (sayi1 - sayi2));
                break;
            case 3: // Çarpma
                System.out.println("1.Sayı "+sayi1+"ile "+"2.Sayı "+sayi2+" çarpımı : " + (sayi1 * sayi2));
                break;
            case 4: // Bölme
                if(sayi1 > 0){
                    System.out.println("1.Sayı "+sayi1+"ile "+"2.Sayı "+sayi2+" bölümü : " + (sayi1 / sayi2));
                }else{
                    System.out.println("1.sayı bölme işlemi için 0 dan büyük olmalıdır!");
                }
                break;
            default: // Geçersiz
                System.out.println("Geçersiz İşlem!");
                break;
        }
    }
}
