package company.oracle.onsiteMianjing;

import tree.TreeNode;

import java.util.*;

//第四轮很像刷题网而起而，但是是比target小或等于的closest，不能大于。 然后target是int不是float，起初是相当于k=1， followup是k。

public class bstClosetAndSmallFollowUpK {
    int closest = 0;
    public int closestNodeInBst(TreeNode root , int target){
        if (root == null){
            return  0;
        }
        helper(root,target);
        return closest;
    }

    private void helper(TreeNode node, int target) {
        if (node == null) return;
        if (node.val <= target && (target - closest) > (target - node.val) ){
            closest = node.val;
        }
        if (node.val < target){
            helper(node.right , target);
        }else if (node.val > target){
            helper(node.left,target);
        }
    }

    // Using inorder
    public List<Integer> closestNodeInBstFollowUp(TreeNode root , int target , int K){
        if (root == null) return null;
        Stack<TreeNode>  stack = new Stack<>();
        TreeNode cur = root;
        List<Integer> res = new ArrayList<>();
        while (cur != null || !stack.isEmpty() ){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (cur.val <= target) {
                if (res.size() <= K) {
                    res.add(cur.val);
                }else{
                    res.remove(0);
                    res.add(cur.val);
                }
            }else{
                break;
            }
            cur = cur.right;
        }
        return res;
    }


// 272

    class Solution {
        public int closestValue(TreeNode root, double target) {
            if (root.left != null && target < root.val) {
                int leftResult = closestValue(root.left, target);
                return Math.abs(leftResult - target) < Math.abs(root.val - target) ? leftResult : root.val;
            }
            if (root.right != null && target > root.val) {
                int rightResult = closestValue(root.right, target);
                return Math.abs(rightResult - target) < Math.abs(root.val - target) ? rightResult : root.val;
            }
            return root.val;
        }
    }

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Queue<Integer> list = new LinkedList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(!stack.isEmpty() || node != null){
            while(node != null){
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();

            if(list.size() < k){
                list.offer(node.val);
            }else{
                if(Math.abs(list.peek() - target) > Math.abs(node.val - target)){
                    list.poll();
                    list.offer(node.val);
                }else{
                    break;
                }
            }

            node = node.right;
        }

        return (List<Integer>) list;
    }
}
