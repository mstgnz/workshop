import java.util.Scanner;

public class CinZodyagi {

    // https://app.patika.dev/moduller/java101/odev-cin-zodyagi
    public static void main(String[] args) {
        int birthYear;
        String[] zodyak = {"Maymun","Horoz","Köpek","Domuz","Fare","Öküz","Kaplan","Tavşan","Ejderha","Yılan","At","Koyun"};

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Doğum yılınız : ");
            birthYear = scanner.nextInt();

            if(birthYear < 1){
                System.out.println("Lütfen geçerli bir tarih giriniz!");
                System.exit(0);
            }

            for (int i = 0; i < zodyak.length; i++) {
                if(birthYear % 12 == i){
                    System.out.println("Çin Zodyağı Burcunuz :"+ zodyak[i]);
                }
            }


        }catch (Exception e){
            System.out.println("Lütfen sadece integer bir değer giriniz!");
        }


    }
}
