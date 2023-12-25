import java.util.Scanner;

public class HavaDurumunaGoreEtkinlik {
    // https://app.patika.dev/moduller/java101/pratik-etkinlik-onerme
    public static void main(String[] args) {
        int heat;
        String oneri;

        Scanner scanner = new Scanner(System.in);

       try {
           System.out.print("Hava Sıcaklığı : ");
           heat = scanner.nextInt();

           // oneri = heat >= 15 && heat <= 25 ? "Piknik" : "";
           // oneri = heat >= 5 && heat < 15 ? "Sinema" : "";
           // oneri = heat > 25 ? "Yüzme" : "Kayak";

           oneri = heat >= 15 && heat <= 25 ? "Piknik" : heat >= 5 && heat < 15 ? "Sinema" : heat > 25 ? "Yüzme" : "Kayak";

           System.out.println(oneri);
       }catch (Exception e){
           System.out.println("Lütfen sadece int türünde bir veri giriniz!");
       }

    }
}
