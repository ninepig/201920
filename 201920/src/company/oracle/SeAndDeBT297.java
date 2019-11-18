package company.oracle;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
利用前序来做
然后用一个 NULL 来作为区别符号
如果没有node 用null来代替
这样de的时候 就可以同样利用前序的特点来解决
 */
public class SeAndDeBT297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        StringBuilder res=new StringBuilder();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode cur=queue.poll();
            if(cur==null){
                res.append("null ");
                continue;
            }
            res.append(cur.val+" ");
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="") return null;
        String[] str=data.split(" ");
        TreeNode root=new TreeNode(Integer.parseInt(str[0]));
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        for(int i=1;i<str.length;i++){
            TreeNode cur=queue.poll();
            if(!str[i].equals("null")){
                cur.left=new TreeNode(Integer.parseInt(str[i]));
                queue.offer(cur.left);
            }
            if(!str[++i].equals("null")){
                cur.right=new TreeNode(Integer.parseInt(str[i]));
                queue.offer(cur.right);
            }
        }
        return root;
    }

}
