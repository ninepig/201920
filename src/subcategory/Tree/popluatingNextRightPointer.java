package subcategory.Tree;

/**
 * Created by yangw on 2019/7/7.
 */
public class popluatingNextRightPointer {

    /**
     * Definition for binary tree with next pointer.
     * public class TreeLinkNode {
     *     int val;
     *     TreeLinkNode left, right, next;
     *     TreeLinkNode(int x) { val = x; }
     * }
     */
//    public void connect(TreeLinkNode root) {
//
//        TreeLinkNode first = root;
//        while(first!=null){
//            TreeLinkNode cur = first;
//            // Level order!
//            while(cur != null){
//                if(cur.left != null) cur.left.next = cur.right;
//                if(cur.next!= null && cur.right!=null) cur.right.next = cur.next.left;
//                cur = cur.next;
//            }
//            // Go to next level.
//            first = first.left;
//        }
//    }
}
