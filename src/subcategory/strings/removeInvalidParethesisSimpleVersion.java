package subcategory.strings;

import java.util.Stack;

/**
 * Created by yangw on 2019/7/3.
 * 简单版本，只要求返回一个string 即可 当然还有很多变体
 */
public class removeInvalidParethesisSimpleVersion {

    // Two pass , using pointer to remove invalid leftSign or rightSign
    public String removeInvalid(String input){
        if (input == null || input.length() == 0) return input;
        int lCount = 0;
        StringBuilder sb = new StringBuilder(input);
        for (int i = 0 ; i < sb.length() ; i++ ){
            if (sb.charAt(i) == '(') lCount++;
            else if (sb.charAt(i) == ')'){
                if (lCount == 0){
                    sb.deleteCharAt(i);
                }else {
                    lCount--;
                }
            }
        }
        int rCount = 0;
        for (int j = sb.length() - 1 ; j >= 0 ; j--){
            if (sb.charAt(j) == ')') rCount++;
            else if(sb.charAt(j) == '('){
                if (rCount == 0){
                    sb.deleteCharAt(j);
                }else {
                    rCount--;
                }
            }
        }
        return sb.toString();
    }
    // One pass using stack to record illegal postion. Then remove it.
    public static String removeInvalidOnePass(String input) {
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (stack.isEmpty() || input.charAt(stack.peek()) != '(') {
                    stack.push(i);
                } else {
                    stack.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder(input);
        while (!stack.isEmpty()) {
            sb.deleteCharAt(stack.pop());
        }
        return sb.toString();
    }

}
