package DP;

import java.util.ArrayList;
import java.util.List;

/*
转换一下思路，定义 f[i][j] 为以 A[i - 1] 和 B[j - 1] 为结尾的LCS的长度，这样就可以记忆连续的公共子字符串。

定义状态转移函数：由以上定义，A[i - 1] == B[j - 1] 时，则有 f[i][j] = f[i - 1][j - 1] + 1 ；A[i - 1] != B[j - 1] 时，f[i][j] = 0 。
定义起点：当 A 为空或 B 为空时，对应的状态函数 f 为 0，考虑到整数数组默认初始化为 0 ，也可以不显式初始化。
定义终点：在 f[0 ~ n][0 ~ m] 中取最大值即为最终结果。
 */
public class longestCommonSubString {
    public static int longestCommonSubstring(String A, String B) {
            if (A == null || B == null) return 0;

            // state[x][y] means how long the lcs is when it is  A[x-1] b [y-1].
            // initial state will be 0 for each cell.
            int[][] state = new int[A.length()+1][B.length()+1];

            int max = 0;

            for (int i = 1 ; i < A.length()+1 ; i++){
                for (int j = 1 ; j < B.length() +1 ; j++){
                    // State transfer.
                    if (A.charAt(i-1) != B.charAt(i-1)){
                        state[i][j] = 0;
                    }else{
                        state[i][j] = state[i-1][j-1] + 1;
                    }
                    max = Math.max(max, state[i][j]);
                }
            }
            return max;
    }


    public static void main(String ... ars){
        List<String> a = new ArrayList<>();
        List<String> b = new ArrayList<>();
        a.add("start");
        a.add("account");
        a.add("a");
        a.add("b");
        a.add("notification");
        b.add("start");
        b.add("a");
        b.add("b");
        System.out.println(longestCommonActions(a,b));
    }

    // For wayfair question, we need get real action list.
    // We need set A as longer input , while b is shorter.
    public static int longestCommonActions(List<String> A, List<String> B) {
        if (A == null || B == null) return 0;

        // state[x][y] means how long the lcs is when it is  A[x-1] b [y-1].
        // initial state will be 0 for each cell.
        int[][] state = new int[A.size()+1][B.size()+1];
        int begin = 0 ;
        int end = 0;

        int max = 0;

        for (int i = 1 ; i < A.size() + 1 ; i++){
            for (int j = 1 ; j < B.size() +1 ; j++){
                // State transfer.
                if (A.get(i-1) != B.get(j-1)){
                    state[i][j] = 0;
                }else{
                    state[i][j] = state[i-1][j-1] + 1;
                }
                if (max < state[i][j]){
                    max = state[i][j];
                    end = i;
                }
            }
        }

        System.out.println("last position" + end);
        for (int i = end - max   ; i < end ; i++){
            System.out.println(A.get(i));
        }
        return max;
    }

}
