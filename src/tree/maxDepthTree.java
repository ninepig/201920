package tree;

/**
 * Created by yangw on 2019/6/23.
 */
public class maxDepthTree {
    public int maxDepthDC(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(maxDepthDC(root.left),maxDepthDC(root.right))+1;
    }


    // 如果是traversal 一定会有个变量作为参数，然后再递归的过程之中不断更新
    int depth;
    public int maxDepthT(TreeNode root) {
        if (root == null) return 0;
        depth = 0;
        helper(root,1);

        return depth;
    }

    private void helper(TreeNode root, int i) {
        if (root == null) return ;
        if(i > depth){
            depth = i;
        }
        helper(root.left, i + 1);
        helper(root.right, i + 1);
    }
}