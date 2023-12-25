import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArraySort {

    // https://app.patika.dev/moduller/java101/odev-array-order

    static int arrayLenght;
    static ArrayList<Integer> myArray = new ArrayList<Integer>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Dizi boyutu giriniz : ");
            arrayLenght = scanner.nextInt();

            for (int i = 1; i <=arrayLenght; i++) {
                System.out.print(i+". Eleman : ");
                myArray.add(scanner.nextInt());
            }

            Collections.sort(myArray);
            System.out.println(myArray.toString());

        }catch (Exception e){
            System.out.println("bir şeyler ter gitti sanırım :) ");
        }
    }
}
