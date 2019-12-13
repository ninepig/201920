package company.oracle.mianjing.StringRelated;

import java.util.Stack;

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
