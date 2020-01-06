package subcategory.dfs;

/**
 * Created by yangw on 2019/7/7.
 */
public class sudokuSolver {
    public void solveSudoku(char[][] board) {
        slove(board);
    }
    private boolean slove(char[][] board){
        for(int i = 0 ; i < 9 ; i++){
            for(int j = 0 ; j < 9 ; j++){
                if(board[i][j] == '.'){
                    for(char c = '1' ; c <= '9' ; c++){
                        // Test from '1' -- '9'
                        // Test column, row , 3*3 square if contains C.
                        if(isValid(board,i,j,c)){
                            board[i][j] = c;
                            // If new board can be slove by next try.
                            if(slove(board)){
                                return true;
                            }else{
                                // If not, replace back '.'.
                                board[i][j] = '.';
                            }
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
}
