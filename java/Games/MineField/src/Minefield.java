import java.util.Scanner;

public class Minefield {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int rowCount = 0, columnCount = 0, level = 4;

        System.out.println("""
                WELCOME TO MINEFIELD GAME
                - Set game board boundaries.
                - Give a value for the degree of difficulty.
                - The hardest value is 2.
                - Start the game by selecting the row and column value.""");

        try {
            System.out.print("Row Number : ");
            rowCount = scanner.nextInt();

            System.out.print("Column Number : ");
            columnCount = scanner.nextInt();

            System.out.print("Level Number : ");
            level = scanner.nextInt();

            if(rowCount <= 0 || columnCount <= 0 || level <= 0){
                System.out.println("Please just positive number");
                System.exit(0);
            }

            // max 20x20
            if(rowCount > 20 || columnCount > 20){
                rowCount = columnCount = 20;
            }

            // min 3x3
            if(rowCount < 3 || columnCount < 3){
                rowCount = columnCount = 3;
            }
        }catch (Exception e){
            System.out.println("Please just positive number");
            System.exit(0);
        }

        // Create Instance
        MineSweeper mineSweeper = new MineSweeper(rowCount, columnCount, level);

        mineSweeper.create();

        int row, column;

        while (true){
            if(mineSweeper.isWin()){
                System.out.println("Congratulations you are win");
                break;
            }

            mineSweeper.print();

            try {
                System.out.print("Row Number : ");
                row = scanner.nextInt();

                System.out.print("Column Number : ");
                column = scanner.nextInt();

                if(row <= 0 || column <= 0){
                    System.out.println("Please just positive number");
                    continue;
                }

            }catch (Exception e){
                System.out.println("Please just positive number");
                scanner.nextLine();
                continue;
            }

            mineSweeper.selectIndex(row,column);
        }

        scanner.close();

    }
}
