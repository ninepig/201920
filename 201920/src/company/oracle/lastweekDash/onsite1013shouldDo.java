package company.oracle.lastweekDash;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/*
https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=559494&extra=page%3D2%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B3%5D%3D3%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D7%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
 */
public class onsite1013shouldDo {
    /*
    第一轮是system design: 设计一个类似于Dropbox的系统
    第二轮是午饭轮，和HM在楼下吃了饭，期间主要聊了一些我的项目，和他手下的一些情况，职业发展以及一些BQ，印象深的是如果和同事有conflict怎么办，以及如果老板突然有一个priority比较高的活让你做你会怎么办
    第三轮是Coding，问了一个问题是subarray sum closest to zero，还有一些follow up。当时总感觉刷过，以为是原题，后来发现好像也没找到这道题。
    第四轮是System Design: 问如何在云上部署一个应用，比较关注具体的知识点，比如LB和consistent hashing
    第五轮是Bar Raiser，也是问了一些BQ和项目细节，然后问我是要一道design还是一道coding。我想了想还是选了一道coding。问了一个HashSet数据结构以及一道利扣呜呜呜
     */

    class solutionForSubArrayProblem{
        class presum{
            int sum;
            int index;

            public presum(int sum, int index) {
                this.sum = sum;
                this.index = index;
            }
        }

        public int[] sunArraySumClosedToZero(int[] arr){
            if (arr == null || arr.length == 0){
                return new int[]{};
            }
            presum[] preSum = new presum[arr.length + 1];
            preSum[0] = new presum(0,0);
            int pre = 0;
            for(int i = 1 ; i < preSum.length ; i++){
                preSum[i] = new presum(pre + arr[i-1], i);
                pre = preSum[i].sum;
            }

            Arrays.sort(preSum, new Comparator<presum>() {
                @Override
                public int compare(presum o1, presum o2) {
                    return o1.sum - o2.sum;
                }
            });

            int ans = Integer.MAX_VALUE;
            int[] res = new int[2];
            for (int i = 1 ; i < preSum.length ; i++){
                if (ans > preSum[i].sum - preSum[i-1].sum) {
                    ans = preSum[i].sum - preSum[i-1].sum;
                    res[0] = preSum[i-1].index - 1;
                    res[1] = preSum[i].index - 1;
                    Arrays.sort(res);
                    res[0] +=1;
                }
            }
            return res;
        }

    }


    class solution555 {

        public String splitLoopedString(String[] strs) {
            if (strs == null || strs.length == 0) return "";
            // Reversed first, get the biggest lexiorder first.
            for (int i = 0; i < strs.length; i++) {
                String rev = new StringBuilder(strs[i]).reverse().toString();
                if (strs[i].compareTo(rev) < 0) {
                    strs[i] = rev;
                }
            }

            String res = "";
            for (int i = 0; i < strs.length; i++) {
                String rev = new StringBuilder(strs[i]).reverse().toString();
                for (String cur : new String[]{strs[i], rev}) {
                    for (int k = 0; k < cur.length(); k++) {
                        StringBuilder t = new StringBuilder(cur.substring(k));
                        for (int j = i; j < strs.length; j++) {
                            t.append(strs[j]);
                        }
                        for (int j = 0; j < i; j++) {
                            t.append(strs[j]);
                        }
                        t.append(cur.substring(0, k));

                        if (t.toString().compareTo(res) > 0) {
                            res = t.toString();
                        }
                    }
                }
            }
            return res;
        }
    }
}
