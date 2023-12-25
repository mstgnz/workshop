import java.util.Scanner;

public class MinMax {
    // https://app.patika.dev/moduller/java101/odev-min-max
    public static void main(String[] args) {
        int number;
        int count = 0;
        int min = 0;
        int max = 0;

        Scanner scanner = new Scanner(System.in);

        try {

            System.out.print("Kaç tane sayı gireceksiniz : ");
            count = scanner.nextInt();

            if(count <= 0){
                System.out.println("lütfen pozitif bir sayı giriniz");
                System.exit(0);
            }

            int i = 0;
            while (i < count){
                System.out.print("Sayı giriniz : ");
                number = scanner.nextInt();
                if(min > number){
                    min = number;
                }
                if(max < number){
                    max = number;
                }
                i++;
            }

            System.out.println("En küçük sayı : "+ min);
            System.out.println("En büyük sayı : "+ max);

        }catch (Exception e){
            System.out.println("Sadece sayı giriniz!");
        }
    }
}
