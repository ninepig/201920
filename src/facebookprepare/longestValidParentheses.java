package facebookprepare;

import java.util.Stack;

/**
 * Created by yangw on 2019/7/1.
 */
public class longestValidParentheses {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() <= 0){
            return 0;
        }

        int beginIndex = 0, maxLen = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '(')
                stack.push(i);
            else {
                // we just have ) right now.
                if (stack.isEmpty()) {
                    beginIndex = i + 1;
                } else {
                    stack.pop();
                    if (stack.isEmpty())
                        // we just have one ( in front of current )
                        // So we use i - beginIndex + 1
                        // one means one popout (
                        maxLen = Math.max(maxLen, i - beginIndex + 1);
                    else
                        // we have more than one ( in front of current )
                        // stack.peak means current top of stack 's position
                        // plus one means one (
                        maxLen = Math.max(maxLen, i - (stack.peek() + 1) + 1);
                }
            }
        }
        return maxLen;

    }
}
