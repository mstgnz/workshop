import java.util.Arrays;
import java.util.Random;

public class MineSweeper {

    private final int rowCount;
    private final int columnCount;
    private final int mineCount;
    private final char[][] board;
    private final boolean[][] mine;
    private int opened;

    public MineSweeper(int rowCount, int columnCount, int level) {
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        this.board = new char[rowCount][columnCount];
        this.mine = new boolean[rowCount][columnCount];
        level = level < 2  ? 5 : level;
        this.mineCount = rowCount * columnCount / level;
        this.opened = this.mineCount;
    }

   // Create random bomb and board initialize
    public void create(){
        Random random = new Random();
        int mine = 0;
        int row, column;
        for (int i = 0; i < this.mineCount; i++) {
            row = random.nextInt(this.rowCount);
            column = random.nextInt(this.columnCount);
            if(!this.mine[row][column]){
                this.mine[row][column] = true;
                mine++;
            }else{
                if(mine != this.mineCount){
                    i--;
                }
            }
        }
        // set board
        for (char[] chars : this.board) {
            Arrays.fill(chars, ' ');
        }
    }

    // User select index
    public void selectIndex( int row, int column){
        // start index 1 for user
        row--;
        column--;
        // selected index is available and check bomb index
        if(this.isIndexAvailable(row,column)){
            this.isBomb(row, column);
            this.setBoard(row,column);
        }

    }

    // selected index is available
    public boolean isIndexAvailable(int row, int column){
        if(this.rowCount > row && this.columnCount > column){
            if(this.board[row][column] == ' '){
                return true;
            }else{
                System.out.println("Already choose this index!");
            }
        }
        return false;
    }

    // select index is bomb
    public void isBomb(int row, int column){
        if(this.mine[row][column]){
            System.out.println("BOOOMMBBBBBB");
            System.out.println("GAME OVER!");
            System.exit(0);
        }
    }

    // Count select index around bomb and opened
    public void setBoard(int row, int column){
        int mineCount = '0';
        int row1, column1, row2, column2;
        row1 = row > 0 ? row -1 : row;
        column1 = column > 0 ? column -1 : column;
        row2 = this.mine.length > row + 1 ? row + 1 : row;
        column2 = this.mine[0].length > column + 1 ? column + 1 : column;
        for (int i = row1; i <= row2; i++) {
            for (int j = column1; j <= column2; j++) {
                if(this.mine[i][j]){
                    mineCount++;
                }
            }
        }
        this.opened += 1;
        this.board[row][column] = (char)mineCount;
    }

    // Check win
    public boolean isWin(){
        return this.opened == (this.rowCount * this.columnCount);
    }

    // print board
    public void print(){
        for (char[] chars : this.board) {
            System.out.println(Arrays.toString(chars));
        }
    }
}
