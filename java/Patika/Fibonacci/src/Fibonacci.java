import java.util.ArrayList;
import java.util.Scanner;

public class Fibonacci {

    // https://app.patika.dev/moduller/java101/odev-fibo
    public static void main(String[] args) {
        int number;
        int n1 = 0, n2 = 1, n3;

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("bir salyı girin : ");
            number = scanner.nextInt();

            if(number <= 0) System.exit(0);


            for(int i = 2; i < number; i++) {
                n3 = n1 + n2;
                System.out.println(n1 + " + "+ n2 + " = "+ n3);
                n1 = n2;
                n2 = n3;
            }


        }catch (Exception e){
            System.out.println("lütfen sadece sayı girin");
        }
    }
}
