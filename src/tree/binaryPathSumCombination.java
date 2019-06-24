package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangw on 2019/6/24.
 * 1 2 3
 *
 */
public class binaryPathSumCombination {
    boolean pathSumI (TreeNode root,int sum){
        if (root == null) return false;
        if(root.left ==null && root.right == null){
            return root.val == sum;
        }
        return pathSumI(root.left,sum - root.val) || pathSumI(root.right, sum -root.val);
    }

    // 类似combination的题
    List<List<String>> pathSumII (TreeNode root, int sum){
        ArrayList<List<String>> res = new ArrayList<>();
        ArrayList<String> cur = new ArrayList<>();
        helper(root,sum,res,cur);
        return res;
    }

    private void helper(TreeNode root, int sum, ArrayList<List<String>> res, ArrayList<String> cur) {
        if(root == null) return ;
        sum -= root.val;
        if(root.left == null && root.right == null){
            if (sum == 0){
                cur.add(root.val+"");
                res.add(cur);
                // 必须有这一步。因为没有clear的过程
                cur.remove(cur.size()-1);
            }
            return;
        }

        cur.add(root.val+"");
        helper(root.left,sum,res,cur);
        helper(root.right,sum,res,cur);
        cur.remove(cur.size()-1);
    }

    int pathSumIII (TreeNode root, int sum){
         if (root == null) return 0;

         return pathSumIII(root.left,sum) + pathSumIII( root.right,sum) + helper2(root,sum);


    }

    private int helper2(TreeNode root, int sum) {
        if (root == null) return 0;
        int res = 0;
        if (root.val == sum)  res++;
        res += helper2(root.left,sum-root.val);
        res += helper2(root.right,sum - root.val);
        return res;
    }

}
