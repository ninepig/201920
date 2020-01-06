package subcategory.strings;

import java.util.HashSet;

/**
 * Created by yangw on 2019/7/6.
 */
public class longestSubStringWithoutRepeat {
    public class longestSubstringWithoutRepeat {
        public int lengthOfLongestSubstring(String s){
            if(s == null || s.length()==0) return 0;
            HashSet<Character> set = new HashSet();
            int left = 0 , right = 0 ;
            int res = 0;
            while(right < s.length()){
                if(!set.contains(s.charAt(right))){
                    set.add(s.charAt(right));
                    res = Math.max(res, set.size());
                    right++;
                }else{
                    set.remove(s.charAt(left));
                    left++;
                }
            }
            return res;
        }
    }
}
