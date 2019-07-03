package facebookprepare;

import java.util.HashMap;

/**
 * Created by yangw on 2019/6/30.
 */
public class MinimumWindowSubString {
    public String minWindow(String s, String t) {
        if(t == null || t.length() == 0 || s == null || s.length() == 0){
            return "";
        }
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0 , right = 0 , head = 0 , len = Integer.MAX_VALUE;

        for(char c : t.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        // Maintains how many characters in map.
        int count = map.size();

        while (right < s.length()) {
            char rightPoint = s.charAt(right);
            if (map.containsKey(rightPoint)) {
                map.put(rightPoint, map.get(rightPoint) - 1);
                if (map.get(rightPoint) == 0) {
                    count--;
                }
            }
            right++;
            while (count == 0) {
                char leftPoint = s.charAt(left);
                if (map.containsKey(leftPoint)) {
                    map.put(leftPoint, map.get(leftPoint) + 1);
                    if (map.get(leftPoint) > 0) count++;
                }
                if (len > right - left) {
                    len = right - left;
                    head = left;
                }
                left++;
            }
        }
        if(len == Integer.MAX_VALUE) return  "";

        return s.substring(head,head+len);
    }
}
