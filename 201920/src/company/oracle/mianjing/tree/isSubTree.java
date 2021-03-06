package company.oracle.mianjing.tree;

import tree.TreeNode;

public class isSubTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null){
            return false;
        }
        if (isSameTreeA(s,t)){
            return true;
        }
        return isSubtree(s.left,t)||isSubtree(s.right,t);

    }

    private boolean isSameTreeA(TreeNode s, TreeNode t) {
        if(s==null&&t==null){
            return true;
        }
        if (s==null||t==null) {
            return false;
        }
        if (s.val!=t.val){
            return false;
        }
        return isSameTreeA(s.left,t.left)&&isSameTreeA(s.right,t.right);
    }
}
