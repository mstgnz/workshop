import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] group = new int[3];

        group[0] = scanner.nextInt();
        group[1] = scanner.nextInt();
        group[2] = scanner.nextInt();

        int result = 0;
        for (int i = 0; i < group.length; i++) {
            if (group[i] % 2 == 0) {
                result += group[i] / 2;
            } else {
                result += (group[i] / 2) + (group[i] - (group[i] / 2 * 2) <= 2 ? 1 : 2);
            }
        }


        System.out.println(result);
    }
}
