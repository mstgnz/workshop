import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ArrayMaxMin {

    // https://app.patika.dev/moduller/java101/pratik-min-max
    public static void main(String[] args) {
        int[] list = {15,12,788,1,-1,-778,2,0};
        int number;
        int min = 0, max = 0;

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Bir sayı giriniz : ");
            number = scanner.nextInt();

            Arrays.sort(list);

            for (int value : list) {
                if(value > number){
                    max = value;
                    break;
                }
            }

            for (int i = list.length -1; i > 0 ; i--) {
                if(list[i] < number){
                    min = (list[i]);
                    break;
                }
            }


            System.out.println("Girilen Sayı :"+ number);
            System.out.println("Girilen sayıdan küçük en yakın sayı :"+ min);
            System.out.println("Girilen sayıdan büyük en yakın sayı :"+ max);

        }catch (Exception e){
            System.out.println("sayı giriniz!");
        }


    }

}
