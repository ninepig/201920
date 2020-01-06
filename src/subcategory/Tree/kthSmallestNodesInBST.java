package subcategory.Tree;

import facebookprepare.TreeNode;

/**
 * Created by yangw on 2019/7/2.
 */
public class kthSmallestNodesInBST {
    int min =Integer.MIN_VALUE;
    int count =0;
    public int kthSmallest(TreeNode root, int k){
        travel(root,k);
        return min;
    }

    private void travel(TreeNode root,int k) {
        if(root==null){
            return;
        }
        travel(root.left,k);
        count++;
        if(count==k) {
            min = root.val;
        }
        travel(root.right,k);

    }
}
