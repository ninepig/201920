package company.oracle.mianjing;

import java.util.ArrayList;
import java.util.List;
/*
https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=548427&extra=page%3D2%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B2%5D%3D2%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D7%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline

leetcode 969, 不但要写完，还要跑几个测试例子确认正确，不要求优化但是可以讨论一下思路。时间还是有一点紧的。
russian
 */
public class pancakeSorting969 {
    public List<Integer> pancakeSort(int[] A) {
        // Found the largest
        // Flip twice to add that to the tail
        List<Integer> res = new ArrayList<>();
        int n = A.length , max = n;
        for (int i = 0 ; i < A.length ; i++){
            int maxIndex = find(A, max);
            flip(A, maxIndex);
            flip(A, max - 1);
            // First time , we flip to maxIndex, so we flip maxIndex + 1
            res.add(maxIndex + 1);
            // Second time, we flip max times , from head to tail , so right now is max times!
            // Next round will be max--
            res.add(max--);
        }
        return res;
    }

    private int find(int[] a, int max) {
        for (int i = 0 ; i < a.length ; i++){
            if (max == a[i]) return i;
        }
        return -1;
    }

    private void flip(int[] A, int index) {
        int i = 0, j = index;
        while (i < j) {
            int temp = A[i];
            A[i++] = A[j];
            A[j--] = temp;
        }
    }
}
