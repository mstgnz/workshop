import java.util.InputMismatchException;
import java.util.Scanner;

public class PratikNotOrtalamasi {

    // https://app.patika.dev/moduller/java101/pratik-not-ortalamasi
    // https://app.patika.dev/moduller/java101/pratik-sinif-gecme
    public static void main(String[] args) {

        NotOrtalamasi notOrtalamasi = new NotOrtalamasi(55);

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Matemaik Ders Notunuz : ");
            notOrtalamasi.setMath(scanner.nextInt());

            System.out.print("Fizik Ders Notunuz : ");
            notOrtalamasi.setPhysics(scanner.nextInt());

            System.out.print("Kimya Ders Notunuz : ");
            notOrtalamasi.setChemistry(scanner.nextInt());

            System.out.print("Tarih Ders Notunuz : ");
            notOrtalamasi.setHistory(scanner.nextInt());

            System.out.print("Müzik Ders Notunuz : ");
            notOrtalamasi.setMusic(scanner.nextInt());

            System.out.print("Türkçe Ders Notunuz : ");
            notOrtalamasi.setTurkish(scanner.nextInt());

            notOrtalamasi.hesapla();

        }catch (InputMismatchException e){
            System.out.println("Lütfen sadece Integer veri tipinde değerler giriniz.");
        }
    }

}
