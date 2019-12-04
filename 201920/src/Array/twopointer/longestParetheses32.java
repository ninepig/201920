package Array.twopointer;

import java.util.Stack;

/*

https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=555866&extra=page%3D2%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B2%5D%3D2%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D7%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline

https://leetcode.com/problems/longest-valid-parentheses/solution/

wenjing todo

第一轮电面，面试官印度口音很重
简单介绍自己和项目后，面试官问了最具挑战的事情

然后是丽扣32题，最长有效括号。我一开始以为问的是 subset，clarify 以后发现是 subsequence。紧张地忘了这题自己做过了。

面试官建议使用栈来做这道题，我之前地做法是dp。我隐晦地提了一下 dynamic programming 发现他不太感冒。我最后用了个 stack 来存括号，然后还是用了 dp 的做法。。。

然后我问了面试官 Oracle 的云和其他几家相比有什么特点，给面试官整 high 了。。。感觉这个点在 Oracle 应该专门做过宣传教育。
 */
public class longestParetheses32 {
    public int longestValidParentheses(String s) {

        if (s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        // Max means result, beginIndex means current valid String begin pos.
        int max = 0 , beginIndex = 0;
        for (int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            if (c == '('){
                stack.push(i);
            }else {
                if (stack.isEmpty()){
                    beginIndex = i + 1;
                }else {
                    stack.pop();
                    // We just have one left parethesis.
                    if (stack.isEmpty()){
                        // + 1 means the pop out ).
                        max = Math.max(max , i - beginIndex + 1);
                    }else {
                        // we have mul left parethesis.
                        // stack.peek() + 1 means add one for top's (
                        max = Math.max(max , i - (stack.peek() +1) +1);
                    }
                }
            }
        }
        return max;
    }

    public int longestValidParethesesTwoPass(String s){
        if (s == null || s.length() == 0) return 0;
        int left = 0 , right = 0;
        int max = 0;
        for (int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            if (c == '('){
                left++;
            }else{
                right++;
            }
            if (left == right){
                max = Math.max(max , 2 * right);
            }else if (right >= left){
                // Reset
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1 ; i >= 0; i--){
            char c = s.charAt(i);
            if (c == '('){
                left++;
            }else{
                right++;
            }
            if (left == right){
                max = Math.max(max , 2 * left);
            }else if (left >= right){
                //Reset
                left = right = 0;
            }
        }

        return max;

    }

}
