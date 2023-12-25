import java.util.Scanner;

public class Faktoriyel {

    // https://app.patika.dev/moduller/java101/pratik-faktoriyel
    public static void main(String[] args) {
        int n = 0;
        int r = 0;
        int nFak = 1;
        int rFak = 1;
        int nrFak = 1;

        Scanner scanner = new Scanner(System.in);

        try {

            System.out.print("N küme sayısını giriniz : ");
            n = scanner.nextInt();

            System.out.print("R küme sayısını giriniz : ");
            r = scanner.nextInt();

        }catch (Exception e){
            System.out.println("Lütsan bilgileri doğru giriniz!");
            System.exit(0);
        }

        if(r <= 0 || n <= 0){
            System.out.println("Lütfen pozitif bir sayı giriniz");
            System.exit(0);
        }

        if(r >= n){
            System.out.println("N kümesi R kümesinden büyük olmalıdır.");
            System.exit(0);
        }

        for (int i = 1; i <= n; i++) {
            nFak *= i;
        }
        for (int i = 1; i <= r; i++) {
            rFak *= i;
        }
        for (int i = 1; i <= n-r; i++) {
            nrFak *= i;
        }
        System.out.println("n faktoriyel : "+ nFak);
        System.out.println("r faktoriyel : "+ rFak);
        System.out.println("nr faktoriyel : "+ nrFak);
        System.out.println("C(n,r) = "+ (nFak / (rFak * nrFak)));


    }
}
