package company.oracle.mianjing.dfs;

import java.util.*;

/*
如果R3不是limit组 R2就是limit组 和R1 R3不同组 基本无口音的南亚人口大国人士 比较nice
1分钟面试官模板介绍组+1分钟我模板介绍我
给字符串，含有三种括号() {} []及别的字符，问如何判断是否valid
follow up是如果不valid，怎么删除括号使其valid

如果是3种的话
只要一个string
要么就是 正反扫一次
多个string
bfs
 */
public class removeInvalidParethesesSimpleAndOriginal {
        /*
        Limit max removal rmL and rmR for backtracking boundary. Otherwise it will exhaust all possible valid substrings, not shortest ones.
    Scan from left to right, avoiding invalid strs (on the fly) by checking num of open parens.
    If it's '(', either use it, or remove it.
    If it's '(', either use it, or remove it.
    Otherwise just append it.
    Lastly set StringBuilder to the last decision point.
    In each step, make sure:

    i does not exceed s.length().
    Max removal rmL rmR and num of open parens are non negative.
    De-duplicate by adding to a HashSet.
         */
        public List<String> removeInvalidParentheses(String s) {
            List<String> res = new ArrayList<>();
            if (s == null || s.length() == 0) return res;
            int leftP = 0 , rightP = 0;
            for (int i = 0 ; i < s.length() ; i++){
                if (s.charAt(i) == '('){
                    leftP++;
                }else if(s.charAt(i) == ')'){
                    if (leftP > 0){
                        leftP--;
                    }else{
                        rightP++;
                    }
                }
            }
            HashSet<String> set = new HashSet<>();
            dfs(s, 0, set, new StringBuilder() , leftP , rightP , 0);
            return new ArrayList<>(set);
        }
        // Open means left paretheses.
        private void dfs(String s, int i, HashSet<String> res, StringBuilder stringBuilder, int leftP, int rightP, int open) {
            if (leftP < 0 || rightP < 0 || open < 0) return;
            if (i == s.length()){
                if (leftP == 0 && rightP == 0 && open == 0){
                    res.add(stringBuilder.toString());
                }
                return;
            }
            char c = s.charAt(i);
            int len = stringBuilder.length();

            if (c == '('){
                // if we use (
                dfs(s, i+1 ,res, stringBuilder.append('('),leftP , rightP , open+1);
                // if we dont use (
                dfs(s , i+1 ,res, stringBuilder, leftP-1, rightP , open);
            }else if ( c== ')'){
                // if we use )
                dfs(s , i + 1, res, stringBuilder.append(')'), leftP , rightP, open - 1);
                // if we dont use )
                dfs(s, i +1 , res, stringBuilder, leftP , rightP-1, open);
            }else{
                dfs(s, i+1, res,stringBuilder.append(c), leftP , rightP , open);
            }

            stringBuilder.setLength(len);
        }


    public List<String> removeInvalidParenthesesBFS(String s) {
        List<String>  res = new ArrayList<>();
        if (s == null) return res;
        HashSet<String> vistied = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        vistied.add(s);
        q.offer(s);
        boolean found = true;
        while (!q.isEmpty()){
            s = q.poll();
            if (isValid(s)){
                found = true;
                res.add(s);
            }
            // We already found the answer, so just skip.
            if (found) continue;
            for (int i = 0 ; i < s.length() ; i++){
                // normal character.
                if (s.charAt(i) != '(' && s.charAt(i) !=')') continue;
                // get new string.
                String t = s.substring(0,i) + s.substring(i+1);
                if (!vistied.contains(t)){
                    q.add(t);
                    vistied.add(t);
                }
            }
        }
        return res;
    }

    private boolean isValid(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') count++;
            if (c == ')' && count-- == 0) return false;
        }

        return count == 0;
    }

        // Facebook version . 一般就是返回一个valid String
        // 扫两次的方法， 第一次检查 左边和右边match的情况，如果）有多 删除掉
        // 第二次从右边开始往左边扫。 如果（ 有多 删除掉右侧括号
        public String removeInvalidParenthesesFacebookVersion(String s) {
            if (s == null || s.length() == 0) return s;
            int l = 0;
            StringBuilder sb = new StringBuilder(s);
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == '(') {
                    l++;
                } else if (s.charAt(i) == ')') {
                    if (l == 0) {
                        sb.deleteCharAt(i);
                    } else {
                        l--;
                    }
                } else {
                    continue;
                }
            }

            int r = 0;
            for (int i = sb.length() - 1; i >= 0; i--) {
                if (sb.charAt(i) == ')') {
                    r++;
                } else if (sb.charAt(i) == '(') {
                    if (r == 0) {
                        sb.deleteCharAt(i);
                    } else {
                        r--;
                    }
                } else {
                    continue;
                }
            }
            return sb.toString();

        }

        // one loop

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


    class Solution {
        public  void main(String[] args) {
            String s1 = "{[}";
            System.out.println(isValid1(s1));
            String s2 = "{[}]";
            System.out.println(isValid1(s2));
            String s3 = "{";
            System.out.println(isValid1(s3));
            String s4 = "{}";
            System.out.println(isValid1(s4));
            String s5 = "{[(";
            System.out.println(isValid1(s5));
        }
        public  int isValid1(String s) {
            if(s == null || s.length() == 0){
                return 0;
            }
            Stack<Character> stack = new Stack<>();
            int res = 0;
            for(char c : s.toCharArray()){
                if(c == ')'){//{[}
                    while(!stack.isEmpty() && stack.peek() != '('){
                        stack.pop();
                        res++;
                    }

                    if(!stack.isEmpty() && stack.peek() == '('){
                        stack.pop();
                    }else{
                        res++;
                    }
                }else if(c == ']'){
                    while(!stack.isEmpty() && stack.peek() != '['){
                        stack.pop();
                        res++;
                    }

                    if(!stack.isEmpty() && stack.peek() == '['){
                        stack.pop();
                    }else{
                        res++;
                    }
                }else if(c == '}'){
                    while(!stack.isEmpty() && stack.peek() != '{'){
                        stack.pop();
                        res++;
                    }
                    if(!stack.isEmpty() && stack.peek() == '{'){
                        stack.pop();
                    }else{
                        res++;
                    }
                }else{
                    stack.push(c);
                }
            }
            return stack.size() + res;
        }
    }

}
