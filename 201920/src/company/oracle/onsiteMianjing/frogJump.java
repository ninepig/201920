package company.oracle.onsiteMianjing;

import java.util.HashMap;
import java.util.HashSet;
/*
Using a hashmap to store each stone and steps it could jump
current step will be the previous step + 1 or step -1 or step
so it will depends previous step
reach mean step plus it current stone location
what we want is to check if we can arrive last stone.

 */
public class frogJump {
    public boolean canReach(int[] stones){
        if (stones == null || stones.length == 0) return false;
        HashMap<Integer , HashSet<Integer>> map = new HashMap<>();
        for (int i = 0 ; i < stones.length ; i ++){
            map.put(stones[i] , new HashSet<>());
        }
        // By default , it will jump from 0 -- 1.
        map.get(0).add(1);
        // We don't need do in last stone.
        for (int i = 0 ; i < stones.length - 1; i++){
            int stone = stones[i];
            for (int step : map.get(stone)){
                int reach = step + stone;
                // Reach last stone.
                if (reach == stones[stones.length -1]){
                    return true;
                }
                // there exist that new reach in our map.
                HashSet<Integer> set = map.get(reach);
                // put previous step with 3 more chance into new stone 's step set.
                if (set != null){
                    set.add(step);
                    set.add(step+1);
                    if (step - 1 > 0) set.add(step - 1);
                }
            }
        }
        return false;
    }
}
