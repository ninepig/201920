package facebookprepare;

/**
 * Created by yangw on 2019/7/2.
 */
public class smallestSubTreeWithAllThedeepestNode {
    public int depth(TreeNode root){
        if(root == null ) return 0;
        return Math.max(depth(root.left),depth(root.right))+1;
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if( root == null ) return null;
        int left =  depth(root.left);
        int right = depth(root.right);
        if( left  == right ) return root;
        if( left > right ) return subtreeWithAllDeepest(root.left);
        return subtreeWithAllDeepest(root.right);
    }
    The time complexity of above code is O(N^2) since a binary tree can degenerate to a linked list, the worst complexity to calculate depth is O(N) and so the overall time complexity is O(N^2). Here is the memoized version:

    Time complexity: O(N)

    public int depth(TreeNode root,HashMap<TreeNode,Integer> map){
        if(root == null ) return 0;
        if( map.containsKey(root) ) return map.get(root);
        int max = Math.max(depth(root.left,map),depth(root.right,map))+1;
        map.put(root,max);
        return max;
    }
    public TreeNode dfs(TreeNode root, HashMap<TreeNode,Integer> map){
        int left =  depth(root.left,map);
        int right = depth(root.right,map);
        if( left  == right ) return root;
        if( left > right ) return dfs(root.left,map);
        return dfs(root.right,map);
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if( root == null ) return null;
        HashMap<TreeNode,Integer> map = new HashMap<>();
        depth(root,map);
        return dfs(root,map);
    }
}
