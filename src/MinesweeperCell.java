public class MinesweeperCell {
    public int touching = 0; //represents number of bombs touching cell, if -1 cell contains bomb
    int x;
    int y;

    public MinesweeperCell(int paramX, int paramY){
        x = paramX;
        y = paramY;
    }

    protected void setBomb(){
        touching = -1;
    }

    protected void setTouching(MinesweeperCell[][] board){
        if(touching == -1){
            return;
        }
        if(x == 0 && y == 0){
            checkSurroundingTopLeft(board);
        }
        else if(x == 0 && y == 9){
            checkSurroundingBottomLeft(board);
        }
        else if(x == 9 && y == 0){
            checkSurroundingTopRight(board);
        }
        else if(x == 9 && y == 9){
            checkSurroundingBottomRight(board);
        }
        else if(x == 0){
            checkSurroundingLeftEdge(board);
        }
        else if(x == 9){
            checkSurroundingRightEdge(board);
        }
        else if(y == 0){
            checkSurroundingTopEdge(board);
        }
        else if(y == 9){
            checkSurroundingBottomEdge(board);
        }
        else{
            checkSurrounding(board);
        }
    }

    private void checkSurroundingTopLeft(MinesweeperCell[][] board){
        if(board[x + 1][y].touching == -1){
            touching++;
        }
        if(board[x + 1][y + 1].touching == -1){
            touching++;
        }
        if(board[x][y + 1].touching == -1){
            touching++;
        }
    }

    private void checkSurroundingBottomLeft(MinesweeperCell[][] board){
        if(board[x][y - 1].touching == -1){
            touching++;
        }
        if(board[x + 1][y - 1].touching == -1){
            touching++;
        }
        if(board[x + 1][y].touching == -1){
            touching++;
        }
    }

    private void checkSurroundingTopRight(MinesweeperCell[][] board){
        if(board[x -1][y].touching == -1){
            touching++;
        }
        if(board[x -1][y + 1].touching == -1){
            touching++;
        }
        if(board[x][y +1].touching == -1){
            touching++;
        }
    }

    private void checkSurroundingBottomRight(MinesweeperCell[][] board){
        if(board[x][y - 1].touching == -1){
            touching++;
        }
        if(board[x - 1][y - 1].touching == -1){
            touching++;
        }
        if(board[x - 1][y].touching == -1){
            touching++;
        }
    }

    private void checkSurroundingLeftEdge(MinesweeperCell[][] board){
        if(board[x][y + 1].touching == -1){
            touching++;
        }
        if(board[x + 1][y + 1].touching == -1){
            touching++;
        }
        if(board[x + 1][y].touching == -1){
            touching++;
        }
        if(board[x + 1][y - 1].touching == -1){
            touching++;
        }
        if(board[x][y - 1].touching == -1){
            touching++;
        }
    }

    private void checkSurroundingRightEdge(MinesweeperCell[][] board){
        if(board[x][y+1].touching == -1){
            touching++;
        }
        if(board[x - 1][y +1].touching == -1){
            touching++;
        }
        if(board[x -1][y].touching == -1){
            touching++;
        }
        if(board[x - 1][y -1].touching == -1){
            touching++;
        }
        if(board[x][y - 1].touching == -1){
            touching++;
        }
    }

    private void checkSurroundingTopEdge(MinesweeperCell[][] board){
        if(board[x-1][y].touching == -1){
            touching++;
        }
        if(board[x-1][y+1].touching == -1){
            touching++;
        }
        if(board[x][y+1].touching == -1){
            touching++;
        }
        if(board[x+1][y+1].touching == -1){
            touching++;
        }
        if(board[x+1][y].touching == -1){
            touching++;
        }
    }

    private void checkSurroundingBottomEdge(MinesweeperCell[][] board){
        if(board[x-1][y].touching == -1){
            touching++;
        }
        if(board[x-1][y-1].touching == -1){
            touching++;
        }
        if(board[x][y-1].touching == -1){
            touching++;
        }
        if(board[x+1][y-1].touching == -1){
            touching++;
        }
        if(board[x+1][y].touching == -1){
            touching++;
        }
    }

    private void checkSurrounding(MinesweeperCell[][] board){
        if(board[x +1][y].touching == -1){
            touching++;
        }
        if(board[x+1][y+1].touching == -1){
            touching++;
        }
        if(board[x][y+1].touching == -1){
            touching++;
        }
        if(board[x-1][y+1].touching == -1){
            touching++;
        }
        if(board[x-1][y].touching == -1){
            touching++;
        }
        if(board[x-1][y-1].touching == -1){
            touching++;
        }
        if(board[x][y-1].touching == -1){
            touching++;
        }
        if(board[x+1][y-1].touching == -1){
            touching++;
        }
    }
}
