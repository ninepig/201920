package facebookprepare;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangw on 2019/6/28.
 */
public class nqueen {
    List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n <= 0) return  result;

        search(result,new ArrayList<Integer>(),n);

        return result;
    }

    private void search(List<List<String>> result, ArrayList<Integer> cols, int n) {
       if (cols.size() == n ){
           result.add(drawChessboard(cols));
           return;
       }
       for ( int colIndex = 0 ; colIndex < n ; colIndex++){
           if (!isValid(cols,colIndex)){
               continue;
           }
           cols.add(colIndex);
           search(result,cols,n);
           cols.remove(cols.size() - 1);
       }

    }

    private List<String> drawChessboard(ArrayList<Integer> cols) {
        List<String> chessboard = new ArrayList<>();
        for (int i = 0; i < cols.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < cols.size(); j++) {
                sb.append(j == cols.get(i) ? 'Q' : '.');
            }
            chessboard.add(sb.toString());
        }
        return chessboard;
    }

    private boolean isValid(ArrayList<Integer> cols, int colIndex) {
        int row = cols.size();
        for (int rowIndex = 0; rowIndex < cols.size(); rowIndex++) {
            if (cols.get(rowIndex) == colIndex) {
                return false;
            }
            // matrix 对角线位置
            if (rowIndex + cols.get(rowIndex) == row + colIndex) {
                return false;
            }
            // 写对角线
            if (rowIndex - cols.get(rowIndex) == row - colIndex) {
                return false;
            }
        }
        return true;
    }

}
