package company.oracle.onsiteMianjing;

import java.util.Stack;

public class basicCaclulator {
    // No way to be negtive number
    // Simple version of caclulator 2
    public int caclulatorWithAddAndMul(String s){
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int cur = 0 ;
        char sign = '+';
        for (int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                cur = cur * 10 + c - '0';
            }
            if (!Character.isDigit(c) && s.charAt(i) != ' ' || i == s.length() - 1) {
                if (sign == '+') {
                    stack.push(cur);
                } else if (sign == '*') {
                    stack.push(stack.pop() * cur);
                }
                sign = c;
                cur = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }


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

    public int calculate3(String s) {
        s = s.replaceAll(" ", "");
        if (s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int res = 0, pre = 0, i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            //consecutive digits as a number, save in `pre`
            if (Character.isDigit(ch)) {
                pre = pre*10+(ch-'0');
            }
            //recursively calculate results in parentheses
            if (ch == '(') {
                int j = findClosing(s.substring(i));
                pre = calculate3(s.substring(i+1, i+j));
                i += j;
            }
            //for new signs, calculate with existing number/sign, then update number/sign
            if (i == s.length()-1 || !Character.isDigit(ch)) {
                switch (sign) {
                    case '+':
                        stack.push(pre); break;
                    case '-':
                        stack.push(-pre); break;
                    case '*':
                        stack.push(stack.pop()*pre); break;
                    case '/':
                        stack.push(stack.pop()/pre); break;
                }
                pre = 0;
                sign = ch;
            }
            i++;
        }
        while (!stack.isEmpty()) res += stack.pop();
        return res;
    }

    //Eliminate all "()" pairs, calculate the result in between and save in `pre`
    private int findClosing(String s) {
        int level = 0, i = 0;
        for (i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') level++;
            else if (s.charAt(i) == ')') {
                level--;
                if (level == 0) break;
            } else continue;
        }
        return i;
    }


}
