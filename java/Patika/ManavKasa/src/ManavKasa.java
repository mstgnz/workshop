import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ManavKasa {
    // https://app.patika.dev/moduller/java101/odev-manav-kasa
    public static void main(String[] args) {
        double amount;
        double total = 0;

        Scanner scanner = new Scanner(System.in);

        Map<String, Double> fruits = new HashMap<String, Double>();
        fruits.put("Pear", 2.14);
        fruits.put("Apple", 3.67);
        fruits.put("Tomato", 1.11);
        fruits.put("Banana", 0.95);
        fruits.put("Aubergine", 5.00);


        for ( Map.Entry<String, Double> fruit: fruits.entrySet()) {
            System.out.print(fruit.getKey() +" kaç kilo alacaksınız : ");
            amount = scanner.nextDouble();
            total += fruit.getValue() * amount;
            System.out.println(fruit.getKey() +" için "+ amount + " kilo = "+ (fruit.getValue() * amount) + " TL'dir");
        }
        System.out.println("Toplam manav tutarı : "+ total + " TL'dir.");

    }

}
