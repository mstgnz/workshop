import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BurcBul {

    // https://app.patika.dev/moduller/java101/pratik-burclar
    public static void main(String[] args) {
        int month, day;
        int code;

        Map<String, int[]> burclar = new HashMap<String, int[]>();

        // Koç Burcu : 21 Mart - 20 Nisan
        int[] koc = {321, 420};
        burclar.put("Koç Burcu", koc);
        // Boğa Burcu : 21 Nisan - 21 Mayıs
        int[] boga = {421, 521};
        burclar.put("Boğa Burcu", boga);
        // İkizler Burcu : 22 Mayıs - 22 Haziran
        int[] ikizler = {522, 622};
        burclar.put("İkizler Burcu", ikizler);
        // Yengeç Burcu : 23 Haziran - 22 Temmuz
        int[] yengec = {623, 722};
        burclar.put("Yengeç Burcu", yengec);
        // Aslan Burcu : 23 Temmuz - 22 Ağustos
        int[] aslan = {723, 822};
        burclar.put("Aslan Burcu", aslan);
        // Başak Burcu : 23 Ağustos - 22 Eylül
        int[] basak = {823, 922};
        burclar.put("Başak Burcu", basak);
        // Terazi Burcu : 23 Eylül - 22 Ekim
        int[] terazi = {923, 1022};
        burclar.put("Terazi Burcu", terazi);
        // Akrep Burcu : 23 Ekim - 21 Kasım
        int[] akrep = {1023, 1121};
        burclar.put("Akrep Burcu", akrep);
        // Yay Burcu : 22 Kasım - 21 Aralık
        int[] yay = {1122, 1221};
        burclar.put("Yay Burcu", yay);
        // Kova Burcu : 22 Ocak - 19 Şubat
        int[] kova = {122, 219};
        burclar.put("Kova Burcu", kova);
        // Balık Burcu : 20 Şubat - 20 Mart
        int[] balik = {220, 320};
        burclar.put("Balık Burcu", balik);
        // Oğlak Burcu : 22 Aralık - 21 Ocak
        //int[] oglak = {1222, 121};
        //burclar.put("Oğlak Burcu", oglak);

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Doğduğunuz ay : ");
            month = scanner.nextInt();

            System.out.print("Doğduğunuz gün : ");
            day = scanner.nextInt();

            if((month > 12 || month < 0) || (day > 31 || day < 0)){
                System.out.println("Lütfen doğru bilgi giriniz!");
                System.exit(0);
            }

            code = Integer.parseInt(Integer.toString(month) + Integer.toString(day));

            burcBul(code, burclar);

        }catch (Exception e){
            System.out.println("Lütfen bilgileri doğru giriniz!");
        }
    }

    public static void burcBul(int code, Map<String, int[]> burclar){
        String getBurcName = "";
        for (Map.Entry<String, int[]> burc: burclar.entrySet()) {
            if(code >= burc.getValue()[0] && code <= burc.getValue()[1]){
                getBurcName = burc.getKey();
            }
        }
        if(getBurcName.length() > 0){
            System.out.println(getBurcName);
        }else{
            // Oğlak burcu kurulan sisteme uymadığı için map içersinde bulunmuyor. Hiç bir koşul sağlanmadıysa burç oğlaktır.
            System.out.println("Oğlak Burcu");
        }
    }
}
