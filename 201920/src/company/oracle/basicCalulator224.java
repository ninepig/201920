package company.oracle;

import java.util.Stack;

public class basicCalulator224 {
    // Only () + -
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int cur = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    cur = cur * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                res += sign * cur;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                stack.push(res);
                res = 0;
                stack.push(sign);
                sign = 1;
            } else if (c == ')') {
                res = res * stack.pop() + stack.pop();
                sign = 1;
            }
        }
        return res;
    }


    public int calculateWithAddMinusDivedMul(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        for (int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                res = res * 10 + c - '0';
            }
//            else if ((!Character.isDigit(c)) && c != ' ' && i < s.length() - 1){
                if((!Character.isDigit(c)) && s.charAt(i) != ' '|| i == s.length() -1 ){
                if (sign == '+'){
                    stack.push(res);
                }else if(sign == '-'){
                    stack.push(-res);
                }else if (sign == '*'){
                    stack.push(res * stack.pop());
                }else if (sign == '/'){
                    stack.push(stack.pop() /  res);
                }
                sign = c;
                res = 0;
            }
        }
        int result = 0;
        for (int i : stack){
            result += i;
        }
        return result;
    }


}