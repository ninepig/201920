package company.oracle;

import java.util.ArrayList;
import java.util.List;

public class spiralMatrix54 {
    public List<Integer> spiralOrder(int[][] matrix) {
            if(matrix == null || matrix.length == 0){
                return new ArrayList<>();
            }
            List<Integer> res = new ArrayList<>();
            int rowBegin = 0 , rowEnd = matrix.length - 1 , colBegin = 0 , colEnd = matrix[0].length - 1 ;
            while (rowBegin <= rowEnd && colBegin <= colEnd){
                for (int i = colBegin ; i <= colEnd ; i++){
                    res.add(matrix[rowBegin][i]);
                }
                rowBegin++;
                for (int i = rowBegin ; i <= rowEnd ; i++){
                    res.add(matrix[i][colEnd]);
                }
                colEnd--;
                // Travel to left!
                if (rowBegin <= rowEnd) {
                    for (int i = colEnd; i >= colBegin; i--) {
                        res.add(matrix[rowEnd][i]);
                    }
                }
                rowEnd--;

                // Travel to up!
                if (colBegin <= colEnd) {
                    for (int i = rowEnd; i >= rowBegin; i--) {
                        res.add(matrix[i][colBegin]);
                    }
                    colBegin++;
                }
            }
            return res;
    }
}
