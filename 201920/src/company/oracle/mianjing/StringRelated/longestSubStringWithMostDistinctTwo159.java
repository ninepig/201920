package company.oracle.mianjing.StringRelated;

import java.util.HashMap;
import java.util.Map;

/*


一开始10分钟bq，跟亚马逊一样的题目和风格。然后是数据结构基础，数组和连标的区别，哈希表，哈希表冲突解决等等。普林斯顿coursera的网课足够了。感觉就是在按照princeton的课程问问题。princeton algorithm有一个网址，有所有的code可以看看，问题不会问具体到代码。

最后是一道题目。领口姚武久。

做的一般。自己有一个笨的方法，当时脑子不转了，突发奇想用了一个比较快的方法，结构调试了一会儿。最后做出来了。
面试的人很nice。

多谢地里的面经和内推。
拖地里的福。攒人品，希望有onsite。
 */
 /*
 滑动窗口经典！
  */

 /*
 // Array vs LinkedList
// 1 how store in memory
// 2 access item
// 3 insert and delete
// 4 storage alloction

// Hashtable
// get o(1) put o(1) ---> Amortized time
// Conflict --> open addressing / chaining
  */
public class longestSubStringWithMostDistinctTwo159 {


    public static int getSubStringWithTwoChar(String str) {
        if (str == null || str.length() == 0) return 0;
        int left = 0, right = 0;
        int count = 0, max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (right < str.length()) {
            char c = str.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            // ONly when it equals 1 , it could count!!
            if (map.get(c) == 1) {
                count++;
            }
            right++;

            while (count > 2) {
                char leftC = str.charAt(left);
                map.put(leftC, map.get(leftC) - 1);
                if (map.get(leftC) == 0) {
                    count--;
                }
                left++;
            }

            max = Math.max(max, (right - left));
        }
        return max;
    }

    public static void main(String... args) {
        String abc = "abbbaccdddddddd";
        System.out.println(getSubStringWithKChar(abc,3));
    }

    public static int getSubStringWithKChar(String str, int K) {
        int left = 0, right = 0;
        int maxLen = 0 , counter = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (right < str.length()){
            char rightC = str.charAt(right);
            map.put(rightC, map.getOrDefault(rightC, 0 ) + 1);
            if (map.get(rightC) == 1){
                counter++;
            }
            right++;

            while (counter > K){
                char LeftC = str.charAt(left);
                map.put(LeftC, map.get(LeftC) - 1);
                if (map.get(LeftC) == 0){
                    counter -- ;
                }
                left++;
            }

            maxLen = Math.max(maxLen, (right - left));
        }

        return maxLen;
    }
}