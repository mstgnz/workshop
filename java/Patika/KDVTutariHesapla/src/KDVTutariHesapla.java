import java.util.Scanner;

public class KDVTutariHesapla {
    // https://app.patika.dev/moduller/java101/pratik-kdv-hesaplama
    public static void main(String[] args) {
        double vatRate = 0.18;
        double priceWithoutVat;
        double priceWithVat;

        Scanner scanner = new Scanner(System.in);

        try{
            System.out.print("Fiyat Giriniz : ");
            priceWithoutVat = scanner.nextDouble();

            vatRate = priceWithoutVat > 1000 ? 0.08 : 0.18;

            priceWithVat = priceWithoutVat * vatRate + priceWithoutVat;

            System.out.println("KDV'siz fiyat : " + priceWithoutVat);
            System.out.println("KDV'li fiyat : " + priceWithVat);
            System.out.println("KDV tutarı : " + (priceWithVat - priceWithoutVat));
        }catch (Exception e){
            System.out.println("Lütfen double türünde bir değer giriniz!");
            scanner.nextDouble();
        }
    }
}
