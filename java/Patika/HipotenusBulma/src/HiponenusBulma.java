import java.util.Scanner;

public class HiponenusBulma {

    // https://app.patika.dev/moduller/java101/pratik-hipotenus-bulma
    public static void main(String[] args) {
        int a,b,c;

        Scanner scanner = new Scanner(System.in);

        try{
            System.out.print("A Kenarı değeri : ");
            a = scanner.nextInt();

            System.out.print("B Kenarı değeri : ");
            b = scanner.nextInt();

            hipotenusBul(a,b);

            System.out.print("C Kenarı değeri : ");
            c = scanner.nextInt();

            cevreHesapla(a,b,c);
            alanHesapla(a,b,c);

        }catch (Exception e){
            System.out.println("Lütfen sadece (int) değerleri giriniz!");
        }
    }
    public static void hipotenusBul(int a, int b){
        System.out.println("Hipotenüs değer : " + Math.sqrt((a*a)+(b*b)));
    }

    public static void cevreHesapla(int a, int b, int c){
        System.out.println("Üçgenin çevresi : " + (a+b+c));
    }

    public static void alanHesapla(int a, int b, int c){
        System.out.println("Üçgenin alanı : " + (a*b/2));
    }
}
