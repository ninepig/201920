package subcategory.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yangw on 2019/7/4.
 */
public class FindAllAnagramInAString {
    public List<Integer> findAnagrams(String s, String t) {
        if (s == null || t ==null ||s.length() == 0||t.length()==0){
            return  null;
        }
        List<Integer> res= new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        for (Character c: t.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int l = 0 , r = 0;
        int count = map.size();

        while ( r < s.length()){
            char right = s.charAt(r);
            if (map.containsKey(right)){
                map.put(right,map.get(right) - 1);
                if (map.get(right) == 0){
                    count--;
                }
            }
            r++;
            while (count == 0){
                char left = s.charAt(l);
                if (map.containsKey(left)){
                    map.put(left,map.get(left)+1);
                    if (map.get(left)>0){
                        count++;
                    }
                }
                if (r - l == t.length()){
                    res.add(l);
                }
                l++;
            }
        }
        return res;
    }
}
