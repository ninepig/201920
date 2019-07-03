package facebookprepare;

/**
 * Created by yangw on 2019/7/2.
 */
public class populateRightPointerToNode {
    public void connect(TreeLinkNode root) {
        if(root == null)return;
        Queue<TreeLinkNode> nodes = new LinkedList<>();
        nodes.offer(root);
        while(!nodes.isEmpty()){
            int size = nodes.size();
            for(int i = 0; i < size; i++){
                TreeLinkNode cur = nodes.poll();
                TreeLinkNode n = null;
                if(i < size - 1){
                    n = nodes.peek();
                }
                cur.next = n;
                if(cur.left != null)nodes.offer(cur.left);
                if(cur.right != null)nodes.offer(cur.right);
            }

        }

    }
}
