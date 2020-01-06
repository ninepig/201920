package company.oracle.onsiteMianjing;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*

calculate the number of click times in the last x minutes. implement click(delta), get_clicks(x_minutes).
 Follow up: if we keep adding more clicks, memory usage will go up. How do we deal with this? (We can delete clicks that happen 1 day ago)
 1 queue remove time period.
 2 fix time period, using cycle array !
 */
public class clickAndGetClicks {
    // Simple version
    HashMap<Integer, Integer> map = new HashMap<>();
    public void click(int deltaMins){
        // t + delteMin . get timestamp.
        map.put(deltaMins,map.getOrDefault(deltaMins,0)+1);
    }

    public int getClicks(int x){
        int res = 0;
        for (int key : map.keySet()){
            if (key <= x){
                res += map.get(key);
            }
        }
        return  res;
    }
    // Using queue , if time is more than a time perind , remove the head node
}
