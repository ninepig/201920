package Array.complicated;

import java.util.*;

/*
https://leetcode.com/problems/word-break-ii/discuss/44167/My-concise-JAVA-solution-based-on-memorized-DFS
god war there
@Yanning for a recursive call of the word_break method, we will have two choice:
1.we have not memo it yet, that means we should calculate it using recursion, because there is no result form memo, we don't need to iterator the result form memo, so this choice is O(n^2);
2.we have already memo it, so we don't need to do recursion, just iterator every String from the set return buy memo, so this choice is O(n^2);

in conclusion, recursion and iterator memo won't happen at the same time, so the run time is O(n^2);

if there is something wrong, I'm willing to discuss~
 */
public class wordbreak2 {
    Map<String, List<String>> map = new HashMap<>();
    public List<String> wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0) return new ArrayList<>();

        List<String> res = new ArrayList<>();
        if (map.containsKey(s)){
            return map.get(s);
        }
        if (wordDict.contains(s)){
            res.add(s);
        }
        for(int i = 1 ; i < s.length() ; i++){
            String subString = s.substring(i);
            if (wordDict.contains(subString)){
                List<String> temp = wordBreak(s.substring(0,i),wordDict);
                if (temp.size()!=0){
                    for (int j = 0 ; j < temp.size() ; j++){
//                        System.out.println(j);
//                        System.out.println(temp.get(j));
                        res.add(temp.get(j) + " " + subString);
                    }
                }
            }
        }
        map.put(s , res);
        return res;
    }
}