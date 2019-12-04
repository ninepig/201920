package company.oracle.mianjing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=558259&extra=page%3D2%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B2%5D%3D2%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D7%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline

合并K个Sort过的Array。 提出几种不同的solution，再聊一聊优化，分析时间复杂度等。
解出来了但代码有瑕疵，过程中也有卡壳。感谢国人小哥哥手下留情，全程follow着我得思路1小时也没掉线的Guide到最后。
想上岸真不容易啊。
 */
public class mergeKsortedArray {
    // NLOGN N is the length of array
    public static List<Integer> mergeKsortedA(int[][] target) {
        if (target == null || target.length == 0) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        for (int[] row : target) {
            for (int number : row) {
                res.add(number);
            }
        }
        Collections.sort(res);
        return res;
    }

    public static void main(String... args) {
        int[][] res = new int[][]{
                {1, 2, 3, 4, 2, 2, 2},
                {2, 3, 2, 2, 2, 2, 2}
        };

        for (int c : mergeKsortedA(res)) {
            System.out.println(c);
        }
    }

    class Node {
        int val;
        int x;
        int y;
    }


    public static List<Integer> mergeKsortedB(int[][] target) {
        if (target == null || target.length == 0){
            return new ArrayList<>();
        }

    }
}