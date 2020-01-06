package company.oracle.mianjing.array;

import java.util.HashSet;

/**
 * Created by yangw on 2019/12/16.
 */
public class sudoku {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0)
            return;
        solve(board);
    }

    public boolean solve(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){//trial. Try 1 through 9
                        if(isValid(board, i, j, c)){
                            board[i][j] = c; //Put c for this cell

                            if(solve(board))
                                return true; //If it's the solution return true
                            else
                                board[i][j] = '.'; //Otherwise go back
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c){
        for(int i = 0; i < 9; i++) {
            if(board[i][col] != '.' && board[i][col] == c) return false; //check row
            if(board[row][i] != '.' && board[row][i] == c) return false; //check column
            if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' &&
                    board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
        }
        return true;
    }


    /*
    TIP Now,remember how we convert 1D matrix to 2D matrix? If we have a 1D matrix of size 9 and we want to convert it into i x j 2D matrix (consider 3x3 matrix here, i = 3 and j = 3):
    Element at position i in the 1D array can be found at position [ i / 3 ] [i % 3] in 2D array.

    Now that we have cube position, let's say 4. How do we find the co-ordinates of this cube in terms of Sudoku? Acc to the TIP : Cube is at [4/3][4%3] position in Sudoku. How to get the top left corner of this cube? Just have to multiply positions by 3. i.e [3*(4/3)] [3* (4%3)]
    topLeftI = 3*(4/3);
    topLeftJ = 3* (4%3)
    At this point we have the access of the top left corner of the cube, that is 0th item of the cube 4. Now how to get jth item in the cube? Similar to the TIP:
    positionI = topLeftI + (j / 3);
    positionJ = topLeftJ + (j % 3);
     */

    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0) return false;

        for (int i = 0; i < 9; i++) {
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> columns = new HashSet<>();
            HashSet<Character> cubes = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !rows.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !columns.add(board[j][i])) {
                    return false;
                }
                int RowIndex = 3 * (i / 3);
                int ColIndex = 3 * (i % 3);
                if (board[RowIndex + j / 3][ColIndex + j % 3] != '.' && !cubes.add(board[RowIndex + j / 3][ColIndex + j % 3]))
                    return false;
            }
        }
        return true;
    }

}
