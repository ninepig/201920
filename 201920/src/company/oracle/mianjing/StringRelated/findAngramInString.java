package company.oracle.mianjing.StringRelated;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
follow up 1: suppose there are too many words that we can't load all of them into memory, how do solve it?
split input into chunks, process chunk by chunk.
follow up 2: if you have multiple machines, how do you accelrate it?
Map reduce, talk a little bit how hadoop and how it works
follow up 3: if we want to build a service for this, how should you do it?
Talked about specifying API, module dependency, monitoring, metrics, SLA, etc
 */
public class findAngramInString {
    public List<String> anagramList(String[] strs , String target){
        if (strs == null || strs.length == 0){
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        for (String str : strs){
            if (validAngram(str, target)){
                res.add(str);
            }
        }
        return res;
    }
    // NLOGN n is the length of String , or we can use array conter to do that.
    private boolean validAngram(String stringA, String stringB) {
        char[] A = stringA.toCharArray();
        char[] B = stringB.toCharArray();
        Arrays.sort(A);
        Arrays.sort(B);
        String sortedA = new String(A);
        String sortedB = new String(B);
        return sortedA.equals(sortedB);
    }
}
