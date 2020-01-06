package company.oracle.onsiteMianjing;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

// Presum method.
public class subArraySumEqaulClosedToZero {
    class Pair{
        int sum;
        int index;
        public Pair(int val , int index){
            this.sum =val;
            this.index =index;
        }
    }

    public int[] findTargetArray(int[] arr){
        if (arr == null || arr.length == 0) return new int[]{-1,-1};
        Pair[] pairs = new Pair[arr.length + 1];
        pairs[0] = new Pair(0,0);

        int preSum = 0;
        for (int i = 1 ; i < pairs.length ; i++){
            pairs[i] = new Pair(preSum + arr[i - 1 ], i);
            preSum = pairs[i].sum;
        }

        Arrays.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.sum - o2.sum;
            }
        });

        int ans = Integer.MAX_VALUE;
        int[] res = new int[2];
        // Presum 's difference smallest is the one closest to zero.
        for (int i = 1; i <= pairs.length ; i++){
            if (ans > pairs[i].sum - pairs[i-1].sum){
                ans = pairs[i].sum - pairs[i-1].sum;
                int[] temp = new int[]{pairs[i].index - 1 , pairs[i-1].index - 1};
                Arrays.sort(temp);
                res[0] = temp[0] + 1;
                res[1] = temp[1];
            }
        }
        return res;
    }
}
