package subcategory.Tree;

import facebookprepare.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.Stack;

/**
 * Created by yangw on 2019/7/3.
 * 本质上也是一个preorder的遍历
 */
public class bstIterator {
    TreeNode curr;
    Stack<TreeNode> s;
    public bstIterator(TreeNode root) {
        curr = root;
        s = new Stack<>();
    }

    public boolean hasNext() {
        return !s.isEmpty()|| curr != null;
    }

    public int next() {
        while (curr!=null){
            s.push(curr);
            curr = curr.left;
        }
        TreeNode temp = s.pop();
        curr = temp.right;
        return temp.val;
    }

}
