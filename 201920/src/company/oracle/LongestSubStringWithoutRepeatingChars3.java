package company.oracle;

import java.util.HashSet;

/*
 两个指针的追逐战。 然后比较的是set的大小！
 这个题也要画图做。
 如果出现repeat 或者多少次 这样的情况 不是set 就是hashmap来做
 */
public class LongestSubStringWithoutRepeatingChars3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        HashSet<Character> set = new HashSet<>();
        int left = 0 , right = 0;
        int max = 0;
        int length = s.length();
        while (right < length){
            if (set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }else {
                set.add(s.charAt(right));
                max = Math.max(max, set.size());
                right++;
            }
        }
        return max;
    }
}
