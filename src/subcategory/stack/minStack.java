package subcategory.stack;

import java.util.Stack;

/**
 * Created by yangw on 2019/7/2.
 */
public class minStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    /** initialize your data structure here. */
    public minStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty() || minStack.peek() >= x){
            minStack.push(x);
        }
    }

    public void pop() {
        if (stack.peek().equals( minStack.peek())){
            stack.pop();
            minStack.pop();
        }else{
            stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return  minStack.peek();
    }
}
