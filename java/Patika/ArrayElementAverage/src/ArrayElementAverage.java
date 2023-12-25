import java.util.Scanner;

public class ArrayElementAverage {

    // https://app.patika.dev/moduller/java101/pratik-array-ortalama
    public static void main(String[] args) {

        int[][] matris = new int[2][3];
        double harmonic = 0;

        Scanner scanner = new Scanner(System.in);

        try {
            for (int i = 0; i < matris.length; i++) {
                for (int j = 0; j < matris[i].length; j++) {
                    System.out.print("["+i+"]["+j+"] : ");
                    matris[i][j] = scanner.nextInt();
                    harmonic += (1 / (double)matris[i][j]);
                }
            }
        }catch (Exception e){
            System.out.println("Sınırı aştınız");
        }

        System.out.println("Dizinin harmonic değeri : " + harmonic);
    }
}
