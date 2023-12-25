import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int myNumber = scanner.nextInt();

        if(myNumber % 2 == 0){
            System.out.println(myNumber + 2);
        }else{
            System.out.println(myNumber + 1);
        }
    }
}