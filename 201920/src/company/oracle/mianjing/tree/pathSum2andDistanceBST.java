package company.oracle.mianjing.tree;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
/*
https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=527168&extra=page%3D3%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B2%5D%3D2%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D7%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
1. 给你Binary Tree和一个target number，print路径使得路径和是target，路径必须root开始。
真是佛了这个面试官了，我问是不是return list of list所有路径，他说叫我找到一个就行，我说行，找到就return。很快写完，他看了半天说，hmmm感觉还是要list of list，我说好吧，改好了。然后他又在那说你们python append是这样用的吗？你确定是对的吗？我昏倒啊。。感觉跟他叨叨不明白
PathSum
2. 一个bst，找到任意两个node的距离。
https://leetcode.com/discuss/interview-question/algorithms/125084/given-a-binary-search-tree-find-the-distance-between-2-nodes

 */
public class pathSum2andDistanceBST {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        helper(res, cur , sum , 0 ,root);



        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> cur , int target ,int sum , TreeNode node){
        if(node == null) return;
        if( node.right != null&& node.left!=null && (sum + node.val) == target){
            cur.add(node.val);
            res.add(new ArrayList(cur));
            return;
        }
        cur.add(node.val);
        helper(res, cur, target , sum + node.val , node.left);
        helper(res, cur, target, sum + node.val , node.right);

    }
    public int bstDistance(TreeNode root, int node1, int node2) {
        if (root == null) return -1;
        TreeNode lca = lca(root, node1, node2);
        return getDistance(lca, node1) + getDistance(lca, node2);
    }

    private int getDistance(TreeNode src, int dest) {
        if (src.val == dest) return 0;
        TreeNode node = src.left;
        if (src.val < dest) {
            node = src.right;
        }
        return 1 + getDistance(node, dest);
    }

    private TreeNode lca(TreeNode root, int node1, int node2) {
        while (true) {
            if (root.val > node1 && root.val > node2) {
                root = root.left;
            } else if (root.val < node1 && root.val < node2) {
                root = root.right;
            } else {
                return root;
            }
        }
    }
}
