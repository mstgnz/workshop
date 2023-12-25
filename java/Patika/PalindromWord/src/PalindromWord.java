import java.util.Scanner;

public class PalindromWord {

    // https://app.patika.dev/moduller/java101/pratik-palindrom-string

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String word;

        System.out.print("Bir kelime giriniz : ");
        // sadece ilk kelimeyi al
        word = scanner.next();

        try {
            Integer.parseInt(word);
        }catch (Exception e){
            // iki ayrı kontrol mekanizması
            if(isPalindrome(word) && isPalindrome2(word)){
                System.out.println(word + " palindrom bir kelimedir.");
            }else{
                System.out.println(word + " palindrom değildir.");
            }
        }
        System.out.println("Sadece kelime giriniz");

    }

    static boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    static boolean isPalindrome2(String str) {
        String reverse = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reverse += str.charAt(i);
        }

        if (str.equals(reverse))
            return true;
        else
            return false;
    }
}
