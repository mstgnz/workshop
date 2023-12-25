import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ArrayFrequency {

    // https://app.patika.dev/moduller/java101/odev-array-count
    public static void main(String[] args) {
        // frequency();
        // game();
        int[] game = {0,1,0};
        System.out.println( (canWin(3, game, 0)) ? "YES" : "NO" );
    }

    // https://www.hackerrank.com/challenges/java-1d-array/problem
    /*
        Let's play a game on an array! You're standing at index 0 of an n-element array named game.
        From some index  i(where 0 ≤ i < n), you can perform one of the following moves:
        Move Backward: If cell i-1 exists and contains a 0, you can walk back to cell i-1.
        Move Forward:
        If cell i+1 contains a zero, you can walk to cell i+1.
        If cell i+leap contains a zero, you can jump to cell i+leap.
        If you're standing in cell n-1 or the value of i + leap ≥ n, you can walk or jump off the end of the array and win the game.
     */
    public static void game(){
        Scanner scan = new Scanner(System.in);
        System.out.print("q : ");
        int q = scan.nextInt();
        while (q-- > 0) {
            System.out.print("n : ");
            int n = scan.nextInt();
            System.out.print("leap : ");
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                System.out.print(i +"/"+n+" : ");
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game, 0)) ? "YES" : "NO" );
        }
        scan.close();
    }

    public static boolean canWin(int leap, int[] game, int index) {
        if(index == game.length -1){
            return true;
        }

        if(index+leap < game.length && (game[index+leap] == 0 || index+leap == game.length -1)){
            return canWin(leap,game,index + leap);
        }
        if(index-1 > 0 && game[index-1] == 0){
            return canWin(leap,game,index -1);
        }
        if(index+1 < game.length && (game[index+1] == 0 || index+1 == game.length -1)){
            return canWin(leap,game,index + 1);
        }
        return false;
    }

    public static void frequency(){
        int[] array = {20,30,40,30,55,20,60,5,10,10,30,55,60,5};

        Map<Integer,Integer> myMap = new HashMap<Integer,Integer>();

        for (int i = 0; i < array.length; i++) {
            if(myMap.containsKey(array[i])){
                myMap.replace(array[i], myMap.get(array[i]) +1);
            }else{
                myMap.put(array[i], 1);
            }
        }

        for(Map.Entry<Integer,Integer> m: myMap.entrySet()){
            System.out.println(m.getKey()+" sayısı "+ m.getValue()+" kere tekrar edildi");
        }
    }
}
