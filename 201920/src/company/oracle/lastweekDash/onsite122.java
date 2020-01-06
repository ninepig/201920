package company.oracle.lastweekDash;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by yangw on 2020/1/6.
 * https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=574827&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B3%5D%3D3%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D7%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
 *
 */
public class onsite122 {
    // 1. 白人小哥，系统设计，设计一个类似instgram的系统，答得还不错 + bq

    /*
    老中大哥，直接上中文，很亲和，很注重思路，给一个url list，设计算法查询一个url是否在这个list里面
    这个要谈
     */
    public boolean ifExist(String list , String url){
        // Hashset
        // o(n), one by one.
        // String ?
        return false;
    }

    /*
    青蛙过河
    关键是 step 的理解
     */
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0){
            return false;
        }
        HashMap<Integer , HashSet<Integer>> map = new HashMap<>();
        map.put(0, new HashSet<>());
        map.get(0).add(1);
        for (int i = 1 ; i < stones.length ; i++){
            map.put(i , new HashSet<>());
        }

        for (int i = 0 ; i < stones.length - 1 ; i++){
            int stone = stones[i];
            for (int step : map.get(stone)){
                int reach = step + stone;
                if (reach == stones[stones.length - 1]){
                    return true;
                }
                HashSet<Integer> set  = map.get(reach);
                if (set != null){
                    set.add(step);
                    set.add(step + 1);
                    if (step - 1 > 0){
                        set.add(step - 1);
                    }
                }
            }
        }
        return false;
    }

}
