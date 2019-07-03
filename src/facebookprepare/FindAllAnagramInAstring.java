package facebookprepare;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yangw on 2019/6/30.
 */
public class FindAllAnagramInAstring {
    public List<Integer> findAnagrams(String s, String t) {
        List<Integer> result = new ArrayList();
        if(t.length()>s.length()){
            return result;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        // put the target string in map
        for (char c: t.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        int begin = 0 , end = 0;
        int count = map.size();
        while (end<s.length()){
            //右侧pointer 向右扫描，count--代表map里的count ==0 ，表示我们找到了一串字符串 满足我们的map
            char endChar = s.charAt(end);
            if(map.containsKey(endChar)){
                map.put(endChar,map.get(endChar)-1);
                if(map.get(endChar)==0){
                    count--;
                }
            }
            end++;
            //如果count == 0 时， 左侧pointer 向右扫描，如果含有一个我们map里的字符，我们count++
            //如果count==0 且 字符串长度为 mapping的长度 则说明我们找到了一个subString 满足条件
            //如果字符串长度不相等 则说明中间有杂的字符，不满足条件，就要继续从头开始找
            while (count==0){
                char beginChar = s.charAt(begin);
                if(map.containsKey(beginChar)){
                    map.put(beginChar,map.get(beginChar)+1);
                    if(map.get(beginChar)>0){
                        count++;
                    }
                }
                if(end-begin==t.length()){
                    result.add(begin);
                }
                begin++;
            }
        }
        return result;
    }
}
