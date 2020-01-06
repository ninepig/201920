package company.oracle.mianjing.StringRelated;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
follow up 1: suppose there are too many words that we can't load all of them into memory, how do solve it?
split input into chunks, process chunk by chunk.
follow up 2: if you have multiple machines, how do you accelrate it?
Map reduce, talk a little bit how hadoop and how it works
Hadoop
follow up 3: if we want to build a service for this, how should you do it?
Talked about specifying API, module dependency, monitoring, metrics, SLA, etc
https://en.wikipedia.org/wiki/Service-level_agreement

 */
public class anagramGroup {
    public List<String> findAnagram(String[] strs, String target){
        List<String> res= new ArrayList<>();
        if (strs == null || strs.length == 0) return res;
        for (String str : strs){
            if (helper1(str , target)){
                res.add(str);
            }
        }
        return res;
    }

    private boolean helper1(String str, String target) {
        char[] a = str.toCharArray();
        char[] b = target.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        String newStr = new String(a);
        String newTarget = new String(b);
        return newStr.equals(newTarget);
    }
    // Case sensitive ? other chactacters?
//    private boolean helper2(String str , String target){
//        if (str.length() != target.length() ) return false;
//        int[] helperA = new int[26];
//        int[] helperB = new int[26];
//        for (char a : str.toCharArray()){
//            helperA[a - 'a']
//        }
//    }
    public boolean isAnagram(String s, String t) {
        if(s==null || t==null){
            return false;
        }
        if(s.length() != t.length()){
            return false;
        }
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        int[] charNumbers = new int[26];
        for(int i = 0; i<s.length();i++){
            charNumbers[s.charAt(i)-'a']++;
            charNumbers[t.charAt(i)-'a']--;
        }
        for(int num:charNumbers){
            if(num != 0){
                return false;
            }
        }
        return true;
    }
}
