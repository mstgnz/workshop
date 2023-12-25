import java.util.Arrays;
import java.util.Scanner;

public class Matris {

    // https://app.patika.dev/moduller/java101/2D-array
    public static void main(String[] args) {

        matris1();

    }

    public static void matris1(){
        int[][] matris = new int[3][4];

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < matris.length; i++) {
            for (int j = 0; j < matris[i].length; j++) {
                System.out.print("["+i+"]["+j+"] : ");
                matris[i][j] = scanner.nextInt();
            }
        }

    }
}
