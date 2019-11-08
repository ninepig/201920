package tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
  细节，传统方法。
  112 113
 */
public class PathSumCombination {
    boolean ifTrue = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }

        helper(root, sum , 0);

        return ifTrue;
    }

    public void helper(TreeNode node , int target , int sum){
        if(node == null) return;
        // need to be the leaf node !
        if(sum + node.val == target && node.left == null && node.right == null) {
            ifTrue = true;
        }
        // The value could be negative.
        // if(sum + node.val > target){
        //     return ;
        // }
        helper(node.left , target , sum + node.val);
        helper(node.right , target , sum + node.val);

    }

    /*
      回溯法的精髓。
      preorder。 要在共用的list remove掉当前的影响。 类似排列组合。让别人去尝试。
      1，2，3
      第一次是1，
      再次尝试要去掉1
      再加上2
      同一层 需要remove掉最后一个让别人尝试。
     */
    public List<List<Integer>> pathSumII(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        if(root == null){
            return res;
        }
        helper(res,cur,root,sum);
        return res;
    }

    private void helper( List<List<Integer>> res, List<Integer> cur,TreeNode root,int sum){

        if(root == null){
            return ;
        }

        cur.add(root.val);
        if(root.left == null && root.right == null && root.val == sum){
            res.add(new ArrayList(cur));
            cur.remove(cur.size()-1);
            return;
        }else {
            helper(res, cur , root.left, sum-root.val);
            helper(res, cur , root.right , sum - root.val);
        }
        cur.remove(cur.size()-1);
    }
    /*
    想明白就不难的一道题。同样是inorder 的分治法，由底网上subtree的方法，归纳的果然没错
     */
    public int pathSum3(TreeNode root, int sum) {
        if(root == null) return 0;

        return getSum(root,sum)+pathSum3(root.left,sum) + pathSum3(root.right,sum);
    }
    private int getSum(TreeNode root, int sum){
        int res = 0;
        if(root == null) return 0;

        if(root.val == sum)res++;

        res += getSum(root.left, sum-root.val);
        res += getSum(root.right, sum-root.val);

        return res;
    }

    /*
   仔细分析的一道题， 利用hashmap的形式来做树结构的题。关键是想明白就可以了。
   做一次就会的题。
     */
    public int pathSum666(int[] nums){
        if (nums == null || nums.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            int key = num / 10 ;
            int value = num % 10;
            map.put(key, value);
        }
        int sum = 0;
        getPathSum(nums[0] / 10 , 0 , map, sum);
        return sum;
    }

    private void getPathSum(int node, int cur, HashMap<Integer, Integer> map, int sum) {
        if (!map.containsKey(node)){
            return;
        }
        int level = node / 10;
        int pos = node % 10;
        int value = map.get(node);

        cur += value;
        int left = (level + 1) * 10 + pos * 2 -1;
        int right = (level + 1) * 10 + pos*2;

        // No left and right node.
        if (!map.containsKey(left) && !map.containsKey(right)){
            sum += cur;
            return ;
        }

        getPathSum(left, cur, map, sum);
        getPathSum(right,cur,map,sum);
    }
}
