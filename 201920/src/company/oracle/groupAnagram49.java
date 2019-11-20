package company.oracle;

import java.util.*;

/*
new api learned!!
 List<String> cur = new ArrayList<>(set);
 */
public class groupAnagram49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return null;
        HashMap<String , HashSet<String>> map  = new HashMap<>();
        for (String str : strs){
            char[] strChar = str.toCharArray();
            Arrays.sort(strChar);
            String sorted = new String(strChar);
            if (!map.containsKey(sorted)){
                map.put(sorted , new HashSet<>());
            }
            map.get(sorted).add(str);
        }
        List<List<String>> res = new ArrayList<>();
        for (HashSet<String> set : map.values()){
            List<String> cur = new ArrayList<>(set);
            res.add(cur);
        }
        return res;
    }

    // Could be duplicated!
    public List<List<String>> groupAnagramsList(String[] strs) {
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
