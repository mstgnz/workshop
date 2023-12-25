import java.util.Scanner;

public class Artikyil {

    // https://app.patika.dev/moduller/java101/odev-artik-yil
    public static void main(String[] args) {
        int year;

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Yıl giriniz : ");
            year = scanner.nextInt();
            year = year < 0 ? year *-1: year;

            if(year % 4 == 0 && year % 100 == 0 && year % 400 == 0){
                System.out.println(year + " artık bir yıldır.");
            }else{
                System.out.println(year + " artık bir yıl değildir!");
            }
        }catch (Exception e){
            System.out.println("Geçersiz yıl");
        }
    }
}
