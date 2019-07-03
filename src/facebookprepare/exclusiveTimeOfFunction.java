package facebookprepare;

import java.util.List;
import java.util.Stack;

/**
 * Created by yangw on 2019/7/1.
 */
public class exclusiveTimeOfFunction {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(logs == null || logs.size() == 0) return new int[n];

        int res[] = new int[n];

        int prevTime = 0;

        Stack<Integer> s = new Stack();

        for (String log : logs){
            String[] parts = log.split(":");
            if(!s.isEmpty()) res[s.peek()] += Integer.parseInt(parts[2]) -prevTime ;
            prevTime = Integer.parseInt(parts[2]);
            if(parts[1].equals("start")){
                s.push(Integer.parseInt(parts[0]));
            }else{
                res[s.pop()]++;
                prevTime++;
            }
        }
        return res;
    }
}
