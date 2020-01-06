package subcategory.strings;

import java.util.Stack;

/**
 * Created by yangw on 2019/7/6.
 */
public class validParethesis {
    public boolean isValid(String s) {

        if (s == null || s.length() == 0) {
            return false;
        }
        Stack<Character> stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                default:
                    break;
            }

        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
