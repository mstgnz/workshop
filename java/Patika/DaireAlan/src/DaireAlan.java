import java.util.Scanner;

public class DaireAlan {
    // https://app.patika.dev/moduller/java101/pratik-daire-alan-cevre

    static final double PI = 3.14;

    public static void main(String[] args) {
        int radius;
        int angle;

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Dairenin yarı çapını giriniz : ");
            radius = scanner.nextInt();

            double cevre = cevreHesapla(radius);
            double alan = alanHesapla(radius);

            System.out.print("Merkez açısı ölçüsü \uD835\uDEFC değeri giriniz : ");
            angle = scanner.nextInt();

            System.out.println("Daire dilimi alanı : "+ (PI * (radius * radius) * angle) / 360);

        }catch (Exception e){
            System.out.println("Lütfen sadece (int) türünde bir değer giriniz!");
        }
    }

    public static double cevreHesapla(int radius){
        double cevre = 2 * PI * radius;
        System.out.println("Dairenin Çevresi : "+ cevre);
        return cevre;
    }

    public static double alanHesapla(int radius){
        double alan = PI * radius * radius;
        System.out.println("Dairenin Alanı : "+ alan);
        return alan;
    }
}
