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

    public List<Integer> spiralOrderSecond(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0) return res;

        int left = 0 , top = 0 , right = matrix[0].length - 1 , bottom = matrix.length - 1;
        while(left <= right && top <= bottom){
            // Travel from left to right.
            for(int i = left ; i <= right  ; i++){
                res.add(matrix[top][i]);
            }
            top++;

            // Travel from top to down.
            for(int i = top ; i <= bottom ; i++){
                res.add(matrix[i][right]);
            }
            right--;

            // Travel from right to left.
            if(left <= right){
                for(int i = right ; i >= left ; i-- ){
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Travel from bottom to top.
            if(top <= bottom){
                for(int i = bottom ; i >= top ; i--){
                    res.add(matrix[left][i]);
                }
                left++;
            }
        }
        return res;
    }

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int value = 1;
        int left = 0 , right = n-1, top = 0 , bottom = n-1;
        while(left < right && top < bottom){
            for(int i = left ; i < right ; i++) res[top][i] = value++;
            for(int i = top ; i < bottom ; i++) res[i][right] = value++;
            for(int i = right ; i > left ; i-- ) res[bottom][i] = value++;
            for(int i = bottom; i > top ; i--) res[i][left] = value++;
            left++;
            right--;
            top++;
            bottom--;
        }
        if(n%2 != 0) res[n/2][n/2] = value;
        return res;
    }
}
