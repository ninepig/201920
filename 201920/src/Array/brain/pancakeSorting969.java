package Array.brain;

import java.util.ArrayList;
import java.util.List;

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
