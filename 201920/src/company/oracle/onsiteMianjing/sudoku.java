package company.oracle.onsiteMianjing;

import java.util.HashSet;

/**
 * Created by yangw on 2019/12/16.
 */
public class sudoku {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0)
            return;
        solve(board);
    }

    public boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {//trial. Try 1 through 9
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c; //Put c for this cell

                            if (solve(board))
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

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.' && board[i][col] == c) return false; //check row
            if (board[row][i] != '.' && board[row][i] == c) return false; //check column
            //这里的九宫就是代表 这个row 以及 col 所对应的九宫
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.' &&
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
    是左上角的sub 9宫 开始
    1 2 3
    4 5 6
    7 8 9 每一个数字代表一个小的九宫， 这是j < 9 的意义。 走这9个格子。
    所以用
     int RowIndex = 3 * (i / 3);
     int ColIndex = 3 * (i % 3);
     */

    /*
    第一轮，利口伞留一个白人CPP大神，非常扣细节，不要单单写普通的solution，而是要当作实际需要应用的api去写，
    中间讨论了空间O(1)情况下该怎么做（硬核每行每列每cube两两比较），或者空间够怎么优化（cache避免重复），
    以及遇到不合理的input怎么办？我提出抛出异常，然后继续讨论异常抛出的一些实际问题，还有如果不单单想知道valid or not，还想知道那个cell出问题了怎么办
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

    public boolean isValidSudoku2(char[][] board) {
        if (board == null || board.length == 0) return false;
        for (int i = 0; i < 9; i++) {
            HashSet<Character> rowSet = new HashSet<>();
            HashSet<Character> columnSet = new HashSet<>();
            HashSet<Character> matrixSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.' && !rowSet.add(board[j][i])) {
                    return false;
                }
                if (board[i][j] != '.' && !columnSet.add(board[i][j])) {
                    return false;
                }

                int leftCubeI = 3 * (i / 3);
                int leftCubeJ = 3 * (i % 3);
                if (board[leftCubeI + j / 3][leftCubeJ + j % 3] != '.' && !matrixSet.add(board[leftCubeI + j / 3][leftCubeJ + j % 3])) {
                    return false;
                }
            }
        }
        return true;
    }


    public boolean sudokuSolver2(char[][] board) {
        if (board == null || board.length == 0) return false;
        for (int i = 0 ; i < board.length; i++){
            for (int j = 0 ; j < board[0].length ; j++){
                if (board[i][j] == '.'){
                    for (char a = '1' ; a <= '9' ; a++){
                        board[i][j] = a;
                        if (helper(board,i,j,a)){
                            return true;
                        }
                        // Set it back;
                        board[i][j] = '.';
                    }
                }


            }
        }
        return false;
    }

    private boolean helper(char[][] board, int row, int col, char a) {
        for (int i = 0 ; i < 9 ; i++){
            if (board[row][i] == '.' || board[row][i] == a) return false;
            if (board[i][row] =='.' || board[i][row] == a) return false;
            if (board[3*(row/3) +  i/3][3*(col/3) + i % 3] == '.' ||
                    board[3*(row/3) +  i/3][3*(col/3) + i % 3] == a) return false;
        }
        return true;
    }
}