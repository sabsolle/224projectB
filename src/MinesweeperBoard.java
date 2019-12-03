import java.util.Random;

public class MinesweeperBoard {

    MinesweeperCell[][] board = new MinesweeperCell[10][10];

    public MinesweeperBoard(){
        for(int x = 0; x < 10; x++){
            for(int y = 0; y < 10; y++){
                board[x][y] = new MinesweeperCell(x, y);
            }
        }
        placeBombs();
        setTouching();
    }

    private void placeBombs(){
        Random random = new Random();
        int randX;
        int randY;
        for(int i = 0; i < 10; i++) {
            randX = random.nextInt(10);
            randY = random.nextInt(10);
            while(board[randX][randY].touching == -1) {
                randX = random.nextInt(10);
                randY = random.nextInt(10);
            }
            board[randX][randY].setBomb();
        }
    }

    private void setTouching(){
        for(int x = 0; x < 10; x++){
            for(int y = 0; y < 10; y++){
                board[x][y].setTouching(board);
            }
        }
    }

    public void print(){
        for(int x = 0; x < 10; x++){
            for(int y = 0; y < 10; y++){
                System.out.print(board[x][y].touching + "        ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        MinesweeperBoard newBoard = new MinesweeperBoard();
        newBoard.print();
    }

    public String getNumber(int x, int y){
        return String.valueOf(board[x][y].touching);
    }
}
