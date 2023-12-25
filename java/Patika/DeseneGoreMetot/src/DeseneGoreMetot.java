import java.util.Scanner;

public class DeseneGoreMetot {

    // https://app.patika.dev/moduller/java101/odev-recursive-pattern
    /*
        Java dilinde kullanıcıdan alınan n değerine göre aşağıdaki kurala uyan döngü kullanmadan bir "Recursive" metot yazın.

        Kural : Girilen sayı 0 veya negatif olduğu yere kadar girilen sayıdan 5 rakamını çıkarın. Her çıkarma işlemi sırasında ekrana son değeri yazdırın. Sayı negatif veya 0 olduktan sonra tekrar 5 ekleyin. Yine her ekleme işleminde sayının son değerini ekrana yazdırın.

        Örnek : N Sayısı : 16
                Çıktısı : 16 11 6 1 -4 1 6 11 16
     */

    static int increment = 5;

    public static void main(String[] args) {
        int number, base, type;

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Bir salyı girin : ");
            number = scanner.nextInt();
            number = number < 0 ? number * -1 : number;
            number = number == 0 ? 16 : number;

            System.out.print("Adım sayısı : ");
            increment = scanner.nextInt();
            increment = increment < 0 ? increment * -1 : increment;
            increment = increment == 0 ? 5 : increment;

            base = number;

            if(number > 0){
                type = 1;
            }else{
                type = -1;
            }

            recursive(number, base, type);

        }catch (Exception e){
            System.out.println("lütfen sadece sayı girin");
        }
    }

    public static void recursive(int number, int base, int type){
        if(type == 1){
            if(number > -increment){
                System.out.print(number + " ");
                recursive(number - increment, base, 1);
            }else{
                recursive(number + 2 * increment, base, -1);
            }
        }else if(type == -1){
            if(number < base){
                System.out.print(number + " ");
                recursive(number + increment, base, -1);
            }else{
                recursive(number, base, 0);
            }
        }else{
            System.out.print(number + " ");
            return;
        }
    }

    /*public static int positiveRecursive(int number, int base){
        System.out.print(number + " ");
        number -= increment;
        if(number > -increment){
            return positiveRecursive(number, base);
        }
        return number;
    }

    public static int negativeRecursive(int number, int base){
        System.out.print(number + " ");
        number += increment;
        if(number < base){
            return negativeRecursive(number, base);
        }
        return number;
    }*/

}
