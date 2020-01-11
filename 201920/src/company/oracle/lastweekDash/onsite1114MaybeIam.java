package company.oracle.lastweekDash;

import tree.TreeNode;

import java.util.*;

/*
    因为我有ecommerce的背景，就让我设计一个inventory uploading系统，读入csv或者excel，根据其内容更新数据库里的产品信息
    答的跟屎一样，还是便秘的那种。基本是：给点提示加一点东西，给点提示再加一点东西。

    https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=570220&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B3%5D%3D3%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D7%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
 */
public class onsite1114MaybeIam {
    /*
    R1
    忘了哪个组的了 基本无口音的南亚人口大国人士 很nice
    1分钟面试官模板介绍组+1分钟我模板介绍我
    LC 舅散罢 在 BST 里找落在某范围内的和 可秒的题，花了一点时间思怎么描述我的思路，讲完秒之
    LC 儿散留 找LCA

    LCA我平时用这个模板：
    想了半天怎么才能解释清楚，结果了没一会儿，面试官应该是听懂我想干嘛了，直接打断，让我不用直接给最优解。。
    然后我就用了先找到从root到a和b的paths然后找两条paths中last common node的傻方法
    讲完思路时间差不多了没让我写代码

    最后剩几分钟问问题

    如果R3不是limit组 R2就是limit组 和R1 R3不同组 基本无口音的南亚人口大国人士 比较nice
    1分钟面试官模板介绍组+1分钟我模板介绍我
    给字符串，含有三种括号() {} []及别的字符，问如何判断是否valid

    follow up是如果不valid，怎么删除括号使其valid

    面试官花了不少时间质疑我在dfs找到valid字符串之后返回True强行一层一层跳出栈的行为，坚持说不用这样
    我试图跟他解释不立即返回的话，在跳回上一层递归的之后栈会被pop掉的，最终结果会变成空字符 ，但是这里解释的确实不好，有几个关键的术语忘了英语要怎么说，在表达上大打折扣，怀疑他没听明白。
    最后只好按照他的思路，把代码修改成他要的样子，然后跑了一遍，他才知道他哪错了。。

    最后剩几分钟问问题

    R3
    如果R2不是limit组 R3就是limit组 和R1 R2不同组 小manager 口音很重的南亚人口大国人士 比较nice
    1分钟面试官模板介绍组+1分钟我模板介绍我
    因为我有ecommerce的背景，就让我设计一个inventory uploading系统，读入csv或者excel，根据其内容更新数据库里的产品信息
    答的跟屎一样，还是便秘的那种。基本是：给点提示加一点东西，给点提示再加一点东西。
     */
    int sum = 0;
    public int rangeSum(TreeNode root , int l , int r){
        if (root == null) return sum;
        helper(root, l , r);
        return sum;
    }

    private void helper(TreeNode root, int l, int r) {
        if (root == null) return;
        if (root.val >= l && root.val <= r){
            sum += root.val;
        }
        helper(root.left , l , r);
        helper(root.right, l , r);
    }


    public TreeNode findLca(TreeNode root , TreeNode left, TreeNode right){
        if (root == null || root == left ||root == right){
            return root;
        }
        TreeNode l = findLca(root.left,left,right);
        TreeNode r = findLca(root.right, left , right);
        if (l != null && r != null){
            return root;
        }
        if (l != null ){
            return l;
        }
        if (r != null){
            return r;
        }

        return null;
    }

    // Iteritve way
    // 把点的父亲都找到。 直到 p q 都找到
    // 把p的父亲一路存进set ，然后从q开始找， 第一个在set里的就是lca
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        parent.put(root, null);
        stack.push(root);

        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }
        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }
        while (!ancestors.contains(q))
            q = parent.get(q);
        return q;
    }


    public int toGetAvalidString(String abc){
        if (abc== null || abc.length() == 0) return 0;
        int res = 0;
        Stack<Character> s = new Stack<>();
        // Using another stack to record character Postion to be remove.
        // Stack use to record position.
        for (int i = 0 ; i < abc.length() ; i++){
            char cur = abc.charAt(i);
            if (cur == ')'){
                while (!s.isEmpty() && s.peek()!='('){
                    s.pop();
                    res++;
                }
                if (!s.isEmpty() && s.peek() == '('){
                    s.pop();
                }else {
                    res++;
                }
            }else if(cur == ']'){
                while (!s.isEmpty() && s.peek()!='['){
                    s.pop();
                    res++;
                }
                if (!s.isEmpty() && s.peek() == '['){
                    s.pop();
                }else {
                    res++;
                }
            }else  if (cur == '}'){
                while (!s.isEmpty() && s.peek()!='{'){
                    s.pop();
                    res++;
                }
                if (!s.isEmpty() && s.peek() == '{'){
                    s.pop();
                }else {
                    res++;
                }
            }else {
                s.push(cur);
            }
        }
        return s.size() + res;
    }
}