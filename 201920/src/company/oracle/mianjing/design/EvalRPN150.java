package company.oracle.mianjing.design;

import java.util.Stack;

/*
友善国人小哥，不知道lc有没有原题，就是给“1 2 + 3 *” 对应的算数式是（1 + 2）* 3输出0，不用考虑优先级，
用一个stack做就好，follow up是如果实际应用中有很多新的符号，比如a & b = a * b - a，同时需要不断添加新的符号应该怎么处理，有点OOD的意思了，思路就是不同的符号使用不同subclass，也聊到了异常处理的问题
 */
public class EvalRPN150 {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack();

        for(int i = 0 ; i < tokens.length ; i++){
            String cur = tokens[i];
            if(cur.equals("+")){
                stack.push(stack.pop() + stack.pop());
            }else if (cur.equals("-")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            }else if(cur.equals("*")){
                stack.push(stack.pop() * stack.pop());
            }else if(cur.equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            }else{
                stack.push(Integer.valueOf(cur));
            }
        }
        return stack.pop();
    }
}
