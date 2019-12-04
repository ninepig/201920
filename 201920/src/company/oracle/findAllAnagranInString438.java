package company.oracle;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
fix template for finding subString problem (anagram)
 */
public class findAllAnagranInString438 {
    public List<Integer> findAnagrams(String s, String t) {
        if (s == null || t == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        HashMap<Character , Integer> map = new HashMap<>();
        for (char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        int count = map.size();
        int left = 0 , right = 0;
        while (right < s.length()){
            char cur = s.charAt(right);
            if (map.containsKey(cur)){
                map.put(cur, map.get(cur) - 1);
                if (map.get(cur) == 0){
                    count--;
                }
            }
            right++;
            while (count == 0){
                char leftChar = s.charAt(left);
                if (map.containsKey(leftChar)){
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) > 0){
                        count++;
                    }
                }
                if (right - left == t.length()){
                    res.add(left);
                }
                left++;
            }
        }
        return res;
    }

}