package company.oracle.mianjing.StringRelated;

import java.util.ArrayList;
import java.util.HashMap;

/*
return longest substring contains input sequence
follow up return all substring contains input sequence 等等直到问不出来了
聊天，非常幽默的一小哥
 */
public class minimumSubStringContainInputSequence {
    public String minSubString(String str, String pattern) {
        if (str == null || str.length() == 0) return "";
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int minLength = 0;
        int head = 0;
        for (char c : pattern.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = map.size();
        while (right < str.length()) {
            char cur = str.charAt(right);
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) - 1);
                if (map.get(cur) == 0) {
                    count--;
                }
            }
            right++;
            while (count == 0) {
                char leftChar = str.charAt(left);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) > 0) {
                        count++;
                    }
                }
                if (minLength > right - left) {
                    minLength = right - left;
                    head = left;
                }
                left++;
            }
        }
        if (minLength == 0) return "";
        return str.substring(head, head + minLength);
    }

    //
    public static ArrayList<String> allSubString(String str, String pattern) {
        if (str == null || str.length() == 0) return null;
        ArrayList<String> res = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        for (char c : pattern.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = map.size();
        while (right < str.length()) {
            char cur = str.charAt(right);
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) - 1);
                if (map.get(cur) == 0) {
                    count--;
                }
            }
            right++;
            while (count == 0) {
                char leftChar = str.charAt(left);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) > 0) {
                        count++;
                    }
                }
                res.add(str.substring(left, right));
                left++;
            }
        }
        return res;
    }

    public static void main(String ... args){
        String test = "abcda";
        String pa = "abcd";
        for (String s : allSubString(test,pa)){
            System.out.println(s);
        }
    }
}