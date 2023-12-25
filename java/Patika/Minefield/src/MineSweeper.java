import java.util.Arrays;
import java.util.Random;

public class MineSweeper {

    private final int rowCount;
    private final int columnCount;
    private final int mineCount;
    private final char[][] board;
    private final boolean[][] mine;
    private int opened;

    // Matris boyutunu yani satır ve sütun sayısını kullanıcı belirlemeli.
    public MineSweeper(int rowCount, int columnCount) {
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        this.board = new char[rowCount][columnCount];
        this.mine = new boolean[rowCount][columnCount];
        this.mineCount = rowCount * columnCount / 4;
        this.opened = this.mineCount;
    }

    /*
        Diziye ait eleman sayısının çeyreği (elemanSayisi / 4) kadar rastgele mayın yerleştirilmeli.
        Örneğin dizi 4x3 boyutunda ise eleman sayısı (satırSayısı * sütunSayısı) formülü ile hesaplanmalı ve boyutu 12 olmalı.
        Bu durumda mayın sayısı 12 / 4 = 3 adet olmalıdır. (ipucu : bu mayınların konumlarını tutacak ikinci bir dizi oluşturabilirsiniz.)
     */
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

    // Kullanıcı matris üzerinden bir nokta seçmeli. Nokta seçimi için satır ve sütun değerlerini girmeli.
    public void selectIndex( int row, int column){
        // kullanıcının seçtiği satır sütün 1 den başlar.
        row--;
        column--;
        // seçilen indisler matris sınırları içersindeyse ve daha önceden seçilmediyse
        if(this.isIndexAvailable(row,column)){
            this.isBomb(row, column);
            this.setBoard(row,column);
        }

    }

    // Seçilen noktanın dizinin sınırları içerisinde olup olmadığını kontrol edilmeli ve koşul sağlanmazsa tekrar nokta istenmeli.
    public boolean isIndexAvailable(int row, int column){
        if(this.rowCount > row && this.columnCount > column){
            if(this.board[row][column] == ' '){
                return true;
            }else{
                System.out.println("Daha önce bu alanı seçtiniz!");
            }
        }
        return false;
    }


    // Kullanıcının girdiği noktada mayın var ise oyunu kaybetmeli.
    public void isBomb(int row, int column){
        if(this.mine[row][column]){
            System.out.println("BOOOMMBBBBBB");
            System.out.println("GAME OVER!");
            System.exit(0);
        }
    }

    /*
        Mayın yok ise, ilgili noktaya değen tüm konumlarına bakılmalı
        (sağı,solu,yukarısı,aşağısı,sol üst çapraz,sağ üst çapraz,sağ alt çapraz,sol alt çapraz) ve etrafındaki mayınların sayısının toplamı ilgili noktaya yazılmalı.
        Noktaya değen herhangi bir mayın yok ise "0" değeri atanmalı.
     */
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

    // Kullanıcı hiç bir mayına basmadan tüm noktaları seçebilirse oyunu kazanmalı.
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
