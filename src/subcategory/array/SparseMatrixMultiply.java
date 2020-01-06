package subcategory.array;

/**
 * Created by yangw on 2019/7/5.
 * A * B ===> 3* 2 2*3 ==》 3*3 key forumlar
 */
public class SparseMatrixMultiply {
    public int[][] multiply(int[][] A, int[][] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0) return A;

        int[][] c = new int[A.length][B[0].length];
        for (int i = 0 ; i < c.length ; i++){
            for (int k = 0 ; k < A[0].length ; k++){
                if (A[i][k] != 0){
                    for (int j = 0 ; j< c[0].length ; j++){
                        c[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }
        return c;
    }
}
