import java.util.Scanner;

public class EbobEkok {

    // https://app.patika.dev/moduller/java101/pratik-ebob-ekok
    static int numberOne = 0;
    static int numberTwo = 0;
    static int ebob = 0;
    static int ekok = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Birinci Sayıyı giriniz : ");
            numberOne = scanner.nextInt();
            System.out.print("İkinci Sayıyı giriniz : ");
            numberTwo = scanner.nextInt();

        }catch (Exception e){
            System.out.println("Lütfen sayı giriniz");
        }

        if (numberOne <= 0 || numberTwo<=0){
            System.out.println("Lütfen pozitif bir sayıo giriniz");
            System.exit(0);
        }

        int i = 1;
        int loop = numberOne > numberTwo ? numberOne : numberTwo;
        while (i < loop){
            if(numberOne % i == 0 && numberTwo % i == 0){
                ebob = i;
            }
            i++;
        }
        ekok = numberOne * numberTwo / ebob;

        System.out.println(numberOne +" ile "+numberTwo+ " sayılarının \n" +
                "EBOB değeri : "+ ebob + "\n" +
                "EKOK değeri : "+ ekok);
    }
}
