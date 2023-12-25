import java.util.Scanner;

public class Taksimetre {
    // https://app.patika.dev/moduller/java101/pratik-taksimetre
    public static void main(String[] args) {
        final double unitPrice = 2.20;
        final int minPrice = 20;
        final int openPrice = 10;
        double km;
        double result;
        String unit = "TL";

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Taksi ile gidilen mesafe (km) : ");
            km = scanner.nextDouble();

            result = km * unitPrice + openPrice;
            result = result > minPrice ? result : minPrice;

            System.out.println("Gittiğiniz " + km + " km'nin taksimetre tutarı " + result + " " + unit + " dir.");


        }catch (Exception e){
            System.out.println("Lütfen (double) türünde bir değer giriniz!");
        }
    }
}
