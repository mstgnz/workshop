import java.util.Scanner;

public class UcakBileti {
    // https://app.patika.dev/moduller/java101/odev-ucak-bileti

    static int km, age, type;
    static double unitPrice = 0.10;
    static double ticketPrice;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Mesafeyi km türünden giriniz : ");
            km = scanner.nextInt();

            System.out.print("Yaşınızı giriniz : ");
            age = scanner.nextInt();

            System.out.print("Yolculuk tipini giriniz (1 => Tek Yön , 2 => Gidiş Dönüş ) : ");
            type = scanner.nextInt();

            if(km < 1 || age < 1 || type < 1 || type > 2){
                System.out.println("Hatalı Veri Girdiniz !");
                System.exit(0);
            }

            hesapla();

        }catch (Exception e){
            System.out.println("Lütfen doğru bilgi giriniz!");
        }

    }

    public static void hesapla(){
        ticketPrice = km * unitPrice * type;
        System.out.println("Bilet Tutarı : "+ ticketPrice);

        if(type == 2){
            ticketPrice -= ticketPrice * 0.20;
            System.out.println("Gidiş Dönüş İndirimi -" + ticketPrice * 0.20);
        }
        if(age < 12){
            ticketPrice -= ticketPrice * 0.50;
            System.out.println("Yaş İndirimi (12) -"+ ticketPrice * 0.50);
        }else if(age >= 12 && age <= 24) {
            ticketPrice -= ticketPrice * 0.10;
            System.out.println("Yaş İndirimi (12-24) -" + ticketPrice * 0.10);
        }else if(age > 65) {
            ticketPrice -= ticketPrice * 0.30;
            System.out.println("Yaş İndirimi (65) -" + ticketPrice * 0.30);
        }

        System.out.println("Ödenecek Bilet Tutarı : "+ ticketPrice);

    }
}
