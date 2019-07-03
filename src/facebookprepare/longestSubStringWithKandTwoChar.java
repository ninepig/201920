package facebookprepare;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangw on 2019/6/30.
 */
public class longestSubStringWithKandTwoChar {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int start = 0;
        int maxLen = 0;
        // Key: letter; value: the index of the last occurrence.
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int i;
        for (i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
             if (map.size() == 2 && !map.containsKey(c)) {
            // Pick the character with the leftmost last occurrence.
            char charEndsMostLeft = ' ';
            int minLast = s.length();
            for (char ch : map.keySet()) {
                int last = map.get(ch);
                if (last < minLast) {
                    minLast = last;
                    charEndsMostLeft = ch;
                }
            }
            map.remove(charEndsMostLeft);
            start = minLast + 1;
        }
        map.put(c, i);
        maxLen = Math.max(maxLen, i - start + 1);
    }
    return maxLen;
}


    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int start = 0;
        int maxLen = 0;
        // Key: letter; value: the number of occurrences.
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int i;
        for (i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1); }
                else {
                map.put(c, 1);
                while (map.size() > k) {
                    char startChar = s.charAt(start++);
                    int count = map.get(startChar);
                    if (count > 1) {
                        map.put(startChar, count - 1);
                    } else {
                        map.remove(startChar);
                    }
                }
            }
            maxLen = Math.max(maxLen, i - start + 1);
        }
            return maxLen;
    }

}
