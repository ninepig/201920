package facebookprepare;

import java.util.List;

/**
 * Created by yangw on 2019/7/1.
 */
public class wordBreakI {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length()==0){
            return true;
        }
        //state function , to store to ith of s , if it can be break with dict
        boolean[] res = new boolean[s.length()+1];

        //initital state
        res[0] = true;
        for(int i = 1; i<= s.length();i++){
            for(int j = 0 ; j<i;j++){
                //transfer  if res[j] can be break ,and the substring j--i contains in dict.
                //res[i] =>true;
                if(res[j]&&wordDict.contains(s.substring(j,i))){
                    res[i] = true;
                    break;
                }
            }
        }
        return res[s.length()];
    }
}
