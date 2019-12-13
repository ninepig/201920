package company.oracle.mianjing.StringRelated;

import java.util.LinkedList;
import java.util.List;

/*
https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=567866&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B2%5D%3D2%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D7%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
第一题是给一个string，判断这个string的permutation能否构成Palindrome
2
给一个string，比如“(()()())”, 然后利用这个string构建一棵树(不是BT)，构建的规则是根据index，这个例子就是root有两个值(0,7)，然后里面的子树有三个，左边(1,2)，中间(3,4)，右边(5,6)。如果是“((())())”，那么root还是(0,7)，子树是(1，4) 和(5，6), (1,4)又有子树(2，3)

 */
public class PermutationPalindromeAndWiredTreeConstructTodo {
    public boolean StringPermutationPalindrome(String str){
        if (str == null || str.length() == 0) return false;
        // Uppercase or lowercase?
        int[] map = new int[26];
        for (char c: str.toCharArray()){
            map[c - 'a'] ++;
        }
        int count = 0;
        for (int i: map){
            count += i % 2;
        }

        return count <= 1;
    }
    private class Node {
        int left;
        int right;
        List<Node> childs;
        public Node(int i) {
            left = i;
            childs = new LinkedList<>();
        }
    }
    private int cur = 0;
    public static void main(String[] args) {
        PermutationPalindromeAndWiredTreeConstructTodo m = new PermutationPalindromeAndWiredTreeConstructTodo();
        String s = "((()))";
        m.buildTree(s);
    }
    private Node buildTree(String s) {
        if(s == null) return null;
        if(cur >= s.length()) return null;

        Node node = new Node(cur);
        cur++;
        while(s.charAt(cur) != ')' && cur < s.length()) {
            node.childs.add(buildTree(s));
        }
        node.right = cur;
        cur++;
//        System.out.println(cur+","+node.left+","+node.right);
//        for(Node item : node.childs) {
//            System.out.println("("+item.left+","+item.right+")");
//        }

        return  node;
    }

}
