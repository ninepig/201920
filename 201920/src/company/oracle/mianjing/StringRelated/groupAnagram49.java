package company.oracle.mianjing.StringRelated;

import java.util.*;

/*
new api learned!!
 List<String> cur = new ArrayList<>(set);

 https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=561706&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B2%5D%3D2%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D7%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
刷题网斯舅

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
