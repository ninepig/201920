package company.oracle.mianjing.StringRelated;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;

/*
第四轮，MIT帅气白人小哥，给了一个长长的字符串和俩子串，问这俩子串出现的位置的最小距离是多少。楼主说出来算法以后，他问如果是data stream怎么办。。。写了满满一个白版。。。
https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=573658&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B3%5D%3D3%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D7%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
如果是个stream的话，用一个queue来cache过去存到的一些字符串历史并进行 match。这是我的解法，面试官也认为不错。最后写了一黑板。

另外，还可以采用类似Robin Karp的方法。但这种方法也要求我们进行一次字符串匹配，所以仍然需要有一个cache。

不知道我说清楚了没。我个人觉得KMP不是一个很适合面试的算法，因为我比较笨记不住哈哈。
 */
public class twoTargetInAString {
    public static int distanceOfTwoTargetString(String str, String str1 , String str2){
        if (str == null || str.length() == 0) return 0;
        if (str1 == null || str2 == null || str1.length() == 0 ||str2.length() ==0) return 0;
        int lastStr1Pos = -1 , lastStr2Pos = - 1;
        int minDistance = Integer.MAX_VALUE;
        int strOneLength = str1.length(), strTwoLength = str2.length();
        for (int i = 0 ; i < str.length() ; i++){
            if((i + strOneLength < str.length())&&str.substring(i,i+strOneLength).equals(str1)){
                lastStr1Pos = i;
                if (lastStr2Pos != -1){
                    minDistance = Math.min(lastStr1Pos - lastStr2Pos, minDistance);
                }
            }
            if((i+strTwoLength < str.length())&&str.substring(i,i+strTwoLength).equals(str2)){
                lastStr2Pos = i;
                if (lastStr1Pos != -1){
                    minDistance = Math.min(lastStr2Pos - lastStr1Pos, minDistance);
                }
            }
        }
        return minDistance;
    }

    public static  void main(String ... abs){
        String target = "abccba";
        String a = "ab";
        String b = "cb";
        System.out.println(distanceOfTwoTargetString(target,a,b));
    }
}
