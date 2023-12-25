import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BuyuktenKucuge {
    // https://app.patika.dev/moduller/java101/pratik-sayi-siralama
    public static void main(String[] args) {

        ArrayList<Double> sayilar = new ArrayList<Double>();

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("1. Sayıyı giriniz : ");
            sayilar.add(scanner.nextDouble());

            System.out.print("2. Sayıyı giriniz : ");
            sayilar.add(scanner.nextDouble());

            System.out.print("3. Sayıyı giriniz : ");
            sayilar.add(scanner.nextDouble());

            sirala(sayilar);

            Collections.sort(sayilar);
            System.out.println("Sağlama -> küçükten büyüğe sıralanışı : "+ sayilar);

        }catch (Exception e){
            System.out.println("Lütfen bilgileri doğru giriniz!");
        }
    }

    public static void sirala(ArrayList<Double> sayilar){
        if(sayilar.get(0) > sayilar.get(1) && sayilar.get(0) > sayilar.get(2)){
            if(sayilar.get(1) > sayilar.get(2)){
                System.out.println(sayilar.get(0)+" > "+sayilar.get(1)+" > "+sayilar.get(2));
            }else{
                System.out.println(sayilar.get(0)+" > "+sayilar.get(2)+" > "+sayilar.get(1));
            }
        }else if(sayilar.get(1) > sayilar.get(0) && sayilar.get(1) > sayilar.get(2)){
            if(sayilar.get(0) > sayilar.get(2)){
                System.out.println(sayilar.get(1)+" > "+sayilar.get(0)+" > "+sayilar.get(2));
            }else{
                System.out.println(sayilar.get(1)+" > "+sayilar.get(2)+" > "+sayilar.get(0));
            }
        }else{
            if(sayilar.get(1) > sayilar.get(2)){
                System.out.println(sayilar.get(2)+" > "+sayilar.get(1)+" > "+sayilar.get(0));
            }else{
                System.out.println(sayilar.get(2)+" > "+sayilar.get(0)+" > "+sayilar.get(1));
            }
        }
    }
}
