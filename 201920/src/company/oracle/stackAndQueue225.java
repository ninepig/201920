package company.oracle;

import java.util.LinkedList;
import java.util.Stack;

public class stackAndQueue225 {
    class MyStack {
        LinkedList<Integer> q ;
        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            q = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            q.add(x);
            for (int i = 1 ; i < q.size() ; i++){
                q.add(q.poll());
            }
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return q.poll();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return q.peek();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return  q.size() == 0;
        }
    }

    class MyQueue {
        Stack<Integer> s1, s2;
        /** Initialize your data structure here. */
        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            s1.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (!s2.isEmpty()){
               return s2.pop();
            }else {
                while (!s1.isEmpty()){
                    s2.push(s1.pop());
                }
            }
            return s2.pop();
        }

        /** Get the front element. */
        public int peek() {
            if (!s2.isEmpty()){
                return s2.peek();
            }else {
                while (!s1.isEmpty()){
                    s2.push(s1.pop());
                }
            }
            return s2.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return s1.isEmpty() && s2.isEmpty();
        }
    }

}
