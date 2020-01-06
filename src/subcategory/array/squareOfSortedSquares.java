package subcategory.array;

/**
 * Created by yangw on 2019/7/6.
 */
public class squareOfSortedSquares {

    public int[] sortedSquares(int[] A) {
        if (A == null || A.length == 0) return A;
        int n = A.length ;
        int[] res = new int[n];
        int i = 0 , j = n-1;
        for (int p = n - 1 ; p >= 0 ; p--){
            if (Math.abs(A[i]) > Math.abs(A[j])){
                res[p] = A[i] * A[i];
                i++;
            }else {
                res[p] = A[j] * A[j];
                j--;
            }
        }
        return res;
    }
}
