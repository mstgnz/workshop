public class AsalSayi {

    // https://app.patika.dev/moduller/java101/odev-asal-sayi
    public static void main(String[] args) {


        for (int i = 2; i <= 100; i++) {
            if(check(i)){
                System.out.print(i + " ");
            }
        }
    }

    public static boolean check(int number){
        for (int i = 2; i < number; i++) {
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
}
