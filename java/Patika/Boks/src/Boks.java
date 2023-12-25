import java.util.Random;

public class Boks {

    // https://app.patika.dev/moduller/java101/pratik-boks
    public static void main(String[] args) {
        Fighter marc = new Fighter("Marc" , 15 , 100, 90, 40);
        Fighter alex = new Fighter("Alex" , 10 , 95, 100, 40);

        Random random = new Random();
        int rand = random.nextInt(2);

        Ring r;
        if(rand == 1){
            r = new Ring(marc, alex, 90, 100);
        }else{
            r = new Ring(alex, marc, 90, 100);
        }
        r.run();
    }
}
