package company.oracle;

public class setMatrixZero73 {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        boolean fr = false , fc = false;
        int m = matrix.length , n = matrix[0].length;

        for (int i = 0 ; i < m; i++){
            for (int j = 0 ; j < n ; j++){
                if (matrix[i][j] == 0){
                    if (i == 0) fr = true;
                    if (j == 0) fc = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // it should be 1 instead 0!!
        for (int i = 1 ; i < m; i++){
            for (int j = 1 ; j < n ; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if (fr){
            for (int i = 0 ; i < n ; i++){
                matrix[0][i] = 0;
            }
        }

        if (fc){
            for (int i = 0 ; i < m ; i++){
                matrix[i][0] = 0;
            }
        }
    }
}
