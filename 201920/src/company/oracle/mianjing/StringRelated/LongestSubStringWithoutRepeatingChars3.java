package company.oracle.mianjing.StringRelated;

import java.util.HashSet;

/*
 两个指针的追逐战。 然后比较的是set的大小！
 这个题也要画图做。
 如果出现repeat 或者多少次 这样的情况 不是set 就是hashmap来做

 https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=535183&extra=page%3D3%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B2%5D%3D2%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D7%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline

很客气的三哥， 一直在那说good， good， 然后就挂了， 不知道挂哪了
给一个string array， 找出没有repeat character 的最长的substring array， 返回subarray的长度。

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
