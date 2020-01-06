package subcategory.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yangw on 2019/7/6.
 */
public class groupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        if(strs == null || strs.length == 0){
            return res;
        }
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            if(map.containsKey(key)){
                map.get(key).add(str);
            }else{
                List<String> cur = new ArrayList();
                cur.add(str);
                map.put(key,cur);
            }
        }
        for(List<String> list : map.values()){
            res.add(list);
        }
        return res;
    }
}
