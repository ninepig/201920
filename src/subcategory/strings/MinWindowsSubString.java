package subcategory.strings;

import java.util.HashMap;

/**
 * Created by yangw on 2019/7/4.
 * 经典题
 */
public class MinWindowsSubString {
    public String minWindow(String s, String t) {
        if (s == null || t==null||s.length() == 0|| t.length() ==0){
            return null;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for ( Character c : t.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int count = map.size();
        int l = 0 , r = 0;
        int len = Integer.MAX_VALUE, head = 0;
        while (r < s.length()){
            char rightPoint = s.charAt(r);
            if (map.containsKey(rightPoint)){
                map.put(rightPoint,map.get(rightPoint) - 1);
                if (map.get(rightPoint) == 0){
                    count--;
                }
            }
            r++;
            while (count == 0){
                char leftPoint = s.charAt(l);
                if (map.containsKey(leftPoint)){
                    map.put(leftPoint,map.get(leftPoint) + 1);
                    if (map.get(leftPoint) > 0) count++;
                }
                if(len > r - l){
                    len = r - l;
                    head = l;
                }
                l++;
            }
        }
        if (len == Integer.MAX_VALUE ) return "";
        return s.substring(head,head + len);
    }
}