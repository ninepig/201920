package company.oracle;

import java.lang.reflect.Array;
import java.util.*;

/*
自己做的！
 */
public class BrickWall554 {
    public int leastBricks(List<List<Integer>> wall) {
        if (wall == null || wall.size() == 0) return 0;

        HashMap<Integer , Integer> count = new HashMap<>();
        for (List<Integer> row : wall){
            int sum = row.get(0);
            count.put(sum, count.getOrDefault(sum,0) + 1);
            for (int i = 1 ; i < row.size() ; i++) {
                sum += row.get(i);
                count.put(sum, count.getOrDefault(sum, 0) + 1);
            }
        }

        int biggest = 0 , second = 0;
        if (count.values().size() == 1) return wall.size();
        for (int value : count.values()){
            if (value > biggest){
                second = biggest;
                biggest = value;
            }else if (value > second){
                second = value;
            }
        }
        return wall.size() - second;
    }

// 别人的 如果不把最后一段加上。 就不用考虑最大第二大的问题了！
    public int leastBricks2(List<List<Integer>> wall) {
        if(wall.size() == 0) return 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(List<Integer> list : wall){
            int length = 0;
            for(int i = 0; i < list.size() - 1; i++){
                length += list.get(i);
                map.put(length, map.getOrDefault(length, 0) + 1);
                count = Math.max(count, map.get(length));
            }
        }
        return wall.size() - count;
    }
}
