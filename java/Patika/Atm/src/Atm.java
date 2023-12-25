import java.util.Scanner;

public class Atm {

    // https://app.patika.dev/moduller/java101/pratik-atm

    static String username;
    static String password;
    static int loginTry = 3;
    static int money = 1500;
    static int choose;
    static int price;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while(loginTry > 0){
            System.out.print("Kullanıcı Adınız : ");
            username = scanner.nextLine();

            System.out.print("Şifreniz : ");
            password = scanner.nextLine();

            if(username.equals("patika") && password.equals("dev123")){
                System.out.println("Merhaba, Kodluyoruz Bankasına Hoşgeldiniz!");
                do {
                    System.out.println(
                            "1-Para yatırma\n" +
                            "2-Para Çekme\n" +
                            "3-Bakiye Sorgula\n" +
                            "4-Çıkış Yap"
                    );

                    try {
                        System.out.print("Lütfen yapmak istediğiniz işlemi seçiniz : ");
                        choose = scanner.nextInt();
                    }catch (Exception e){
                        System.out.println("Geçersiz işlem");
                        System.out.println("Kartınızı alınız.");
                        System.exit(0);
                    }

                    switch (choose){
                        case 1:
                            System.out.print("Para miktarı : ");
                            price = scanner.nextInt();
                            money += price;
                            System.out.println("Bakiyeniz : " + money);
                            break;
                        case 2:
                            System.out.print("Para miktarı : ");
                            price = scanner.nextInt();
                            if (price > money) {
                                System.out.println("Bakiye yetersiz.");
                                System.out.println("Bakiyeniz : " + money);
                            } else {
                                money -= price;
                                System.out.println("Bakiyeniz : " + money);
                            }
                            break;
                        case 3:
                            System.out.println("Bakiyeniz : " + money);
                            break;
                        default:
                            System.out.println("Sistemden çıkılıyor.");
                            System.exit(0);
                            break;
                    }

                }while (true);
            }else{
                if(loginTry == 1){
                    System.out.println("Hesabınız blocklandı!");
                    System.out.println("Kartınızı bankadan temin edebilirisinz.");
                }else{
                    System.out.println("Kullanıcı bilgileriniz hatalı!");
                }
                loginTry--;
            }
        }
    }
}
