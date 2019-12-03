import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    View view = new View();
    MinesweeperBoard board = new MinesweeperBoard();

    public Controller(){
        addListeners();
    }

    public void addListeners(){
        for(int x=0; x<10; x++){
            for(int y=0; y<10; y++){
                final int X = x;
                final int Y = y;

                view.boardButtons[x][y].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {

                        view.boardButtons[X][Y].setEnabled(false);
                        if(board.board[X][Y].touching == -1){
                            //set image of button to bomb
                            //play explosion sound
                            //dialog box to notify you lose, ask if want to play again
                            //update stats (model)
                            int choice = JOptionPane.showConfirmDialog(view, "You have hit a bomb and lost :( Do you" +
                                    " want to play again?", "Play Again?", JOptionPane.YES_NO_OPTION);
                            if(choice == JOptionPane.NO_OPTION) {
                                System.exit(0);
                            }
                            if(choice == JOptionPane.YES_OPTION){
                                for(int x=0; x<10; x++){
                                    for(int y=0; y<10; y++){
                                        view.boardButtons[x][y].setEnabled(true);
                                        view.boardButtons[x][y].setText(" ");
                                        board = new MinesweeperBoard();
                                    }
                                }
                                return;
                            }
                        }
                        view.boardButtons[X][Y].setText(board.getNumber(X,Y));//String.valueOf(board.board[X][Y].touching));
                        if(board.board[X][Y].touching == 0){
                            checkSurrounding(board.board);
                        }
                    }
                    private void checkSurrounding(MinesweeperCell[][] board) {
                        if (board[X + 1][Y].touching == 0) {
                            view.boardButtons[X+1][Y].setEnabled(false);
                            view.boardButtons[X+1][Y].setText("0");
                        }
                        if (board[X + 1][Y + 1].touching == 0) {
                            view.boardButtons[X+1][Y+1].setEnabled(false);
                            view.boardButtons[X+1][Y+1].setText("0");
                        }
                        if (board[X][Y + 1].touching == 0) {
                            view.boardButtons[X][Y+1].setEnabled(false);
                            view.boardButtons[X][Y+1].setText("0");
                        }
                        if (board[X - 1][Y + 1].touching == 0) {
                            view.boardButtons[X-1][Y+1].setEnabled(false);
                            view.boardButtons[X-1][Y+1].setText("0");
                        }
                        if (board[X - 1][Y].touching == 0) {
                            view.boardButtons[X-1][Y].setEnabled(false);
                            view.boardButtons[X-1][Y].setText("0");
                        }
                        if (board[X - 1][Y - 1].touching == 0) {
                            view.boardButtons[X-1][Y-1].setEnabled(false);
                            view.boardButtons[X-1][Y-1].setText("0");
                        }
                        if (board[X][Y - 1].touching == 0) {
                            view.boardButtons[X][Y-1].setEnabled(false);
                            view.boardButtons[X][Y-1].setText("0");
                        }
                        if (board[X + 1][Y - 1].touching == 0) {
                            view.boardButtons[X+1][Y-1].setEnabled(false);
                            view.boardButtons[X+1][Y-1].setText("0");
                        }
                    }
                });
            }
        }
        view.menuItem3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for(int x=0; x<10; x++){
                    for(int y=0; y<10; y++){
                        view.boardButtons[x][y].setEnabled(true);
                        view.boardButtons[x][y].setText(" ");
                        board = new MinesweeperBoard();
                    }
                }
            }
        });
    }

}

