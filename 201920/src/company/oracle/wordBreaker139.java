package company.oracle;

import java.util.List;
/*
状态转移方程
对于第 i 个字符
前面任意1---j个字符之中存在这样的词，同时 j--i的词在dict之中存在。
 */
public class wordBreaker139 {
    public boolean wordBreak(String s, List<String> wordDict) {
            if (wordDict == null || wordDict.size() == 0 || s ==null ||s.length() ==0) return false;
            boolean[] res = new boolean[s.length() + 1];
            res[0] = true;
            for ( int i = 1 ; i <  res.length ; i++){
                for ( int j = 0 ; j < i ; j++){
                    if (res[j] && wordDict.contains(s.substring(j , i ))){
                        res[i] = true;
                        break;
                    }
                }
            }
            return res[s.length()];
    }
}