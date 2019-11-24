package company.oracle;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Stack;

public class decodeString394 {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) return s;
        Stack<String> resStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        int index = 0;
        String res = "";

        while (index < s.length()){
            if (Character.isDigit(s.charAt(index))){
                int count = 0;
                // 细节  新的api
                while (Character.isDigit(s.charAt(index))) {
                    count = count * 10 + s.charAt(index) - '0';
                    index++;
                }
                countStack.add(count);
            }else if(s.charAt(index) == '['){
                resStack.push(res);
                res = "";
                index++;
            }else if (s.charAt(index) == ']'){
                StringBuilder sb = new StringBuilder(resStack.pop());
                int repeat = countStack.pop();
                // Repeat current string x times to the current RES
                for (int i = 0 ; i < repeat ; i++){
                    sb.append(res);
                }
                res = sb.toString();
                index++;
            }else {
                res += s.charAt(index++);
            }
        }
        return res;
    }
}