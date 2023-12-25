import java.util.Arrays;
import java.util.Scanner;

public class ArrayTranspose {

    // https://app.patika.dev/moduller/java101/odev-array-transpose

    static int[] input;
    static int loop;

    public static void main(String[] args) {

        transpose();

        // negatif toplam içeren alt kümelerin sayısını verir.
        //subArrayInit();

    }

    public static void subArrayInit(){
        Scanner scanner = new Scanner(System.in);

        // n değerini al
        input = new int[scanner.nextInt()];

        // diziyi oluştur
        for(int i = 0; i < input.length; i++){
            input[i] = scanner.nextInt();
        }

        // alt diziler içinden negatifler kombinasyonlarını bul
        loop = subArray(0);

        System.out.println(loop);
    }

    public static int subArray(int index){
        int sum = 0;
        for(int i = index; i < input.length; i++){
            sum += input[i];
            if(sum < 0){
                loop++;
            }
        }
        if(index < input.length){
            return subArray(index +1);
        }
        return loop;
    }

    public static void transpose(){
        int[][] myArray = {
                {2,3,4},
                {5,6,4}
        };

        int[][] transpose = new int[myArray[0].length][myArray.length];

        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < transpose.length; j++) {
                transpose[j][i] = myArray[i][j];
            }
        }

        for (int i = 0; i < transpose.length; i++) {
            System.out.println(Arrays.toString(transpose[i]));
        }
    }
}
