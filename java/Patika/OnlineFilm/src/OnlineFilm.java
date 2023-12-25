import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OnlineFilm {

    public static void main(String[] args) {

        List<Film> appFilms = new ArrayList<Film>();
        List<Credit> appCredits = new ArrayList<Credit>();

        appFilms.add(new Film("Sherlock Holmes", 12,5));
        appFilms.add(new Film("Pirates of the caribbean", 22,2));
        appFilms.add(new Film("Avengers", 32,1));

        appCredits.add(new Credit("standart", 20,20));
        appCredits.add(new Credit("plus", 50,40));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Uygulamaya Hoşgeldiniz.");

        System.out.print("Adınız : ");
        String firstname = scanner.next();

        System.out.print("Soyadınız : ");
        String lastname = scanner.next();

        User user = new User(firstname, lastname);

        int choose = 0;
        while (true){
            System.out.println(
                    "1-Filmleri Listele\n" +
                    "2-Film Talep Et\n" +
                    "3-Kredi Satın Al\n" +
                    "4-Film Satın Al\n" +
                    "5-Film Kirala\n" +
                    "6-Abone Ol\n" +
                    "7-Para Yükle\n" +
                    "0-Çıkış"
            );
            try {
                choose = scanner.nextInt();
            }catch (Exception e){
                System.out.println("Geçersiz İşlem");
                scanner.next();
                continue;
            }
            if(choose==0){
                System.out.println("Hoşçakalın");
                break;
            }
            switch (choose){
                case 1:
                    System.out.println("film Listesi");
                    break;
                case 2:
                    System.out.println("Film Talep Et");
                    break;
                case 3:
                    System.out.println("Kredi Satın Al");
                    break;
                case 4:
                    System.out.println("Film Satın Al");
                    break;
                case 5:
                    System.out.println("Film Kirala");
                    break;
                case 6:
                    System.out.println("Abone Ol");
                    break;
                case 7:
                    System.out.println("Para Yükle");
                    break;
                default:
                    System.out.println("Geçersiz İşlem");
                    break;
            }
        }

    }
}
