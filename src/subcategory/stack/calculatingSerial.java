package subcategory.stack;

import java.util.Stack;

/**
 * Created by yangw on 2019/7/6.
 */
public class calculatingSerial {
    public int calculateSimple(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int res = 0 , sign = 1;
        for (int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int cur = c - '0';
                while ( i + 1 < s.length() && Character.isDigit(s.charAt(i + 1)))
                    cur = 10*cur + s.charAt(++i) -'0';
                res += sign * cur;
            }else if (c == '-')
                sign = -1;
            else if (c =='+'){
                sign = 1;
            }else if (c == '('){
                stack.push(res);
                res = 0 ;
                stack.push(sign);
                sign = 1;
            }else if(c == ')'){
                res = res * stack.pop() + stack.pop();
                sign = 1;
            }
        }
        return res;
    }
    public int calculateWithoutPare(String s) {
        if( s == null || s.length() == 0)return 0;
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        char sign = '+';
        for (int i = 0 ; i < len ; i++){
            char cur = s.charAt(i);
            if(Character.isDigit(cur)){
                res = res * 10 + cur - '0';
            }
            if((!Character.isDigit(cur)) && s.charAt(i) != ' '|| i == len -1 ){
                if(sign == '-'){
                    stack.push(-res);
                }
                if(sign == '+'){
                    stack.push(res);
                }
                if(sign == '*'){
                    stack.push(res*stack.pop());
                }
                if(sign == '/'){
                    stack.push(stack.pop()/res);
                }
                sign = cur;
                res = 0;
            }
        }
        int result = 0;
        for (int i : stack){
            result += i;
        }
        return result;
    }

    public int calculate(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int res = 0 , pre = 0 , i = 0;
        while(i < s.length()){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                pre = pre * 10 + c - '0' ;
            }
            if(c == '('){
                int j = findClosing(s.substring(i));
                pre = calculate(s.substring(i+1,i+j));
                i += j;
            }
            if( i == s.length() - 1 || !Character.isDigit(c)) {
                switch (sign) {
                    case '+':
                        stack.push(pre);
                        break;
                    case '-':
                        stack.push(-pre);
                        break;
                    case '*':
                        stack.push(stack.pop() * pre);
                        break;
                    case '/':
                        stack.push(stack.pop() / pre);
                        break;
                }
                pre = 0;
                sign = c;
            }
        }
        while (!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }

    private int findClosing(String substring) {
        int level = 0 , i = 0;
        for (i = 0 ; i < substring.length();i++){
            if(substring.charAt(i) == '(') level++;
            else if(substring.charAt(i) == ')'){
                level--;
                if(level == 0) break;
            }else{
                continue;
            }
        }
        return i;
    }

}
