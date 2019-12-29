package company.oracle.mianjing.tree;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class mergeTwoBinaryTrees {
    // de and se binary tree for testing this.
    // Assert 
    public TreeNode mergeTrees(TreeNode t1 , TreeNode t2){
        TreeNode root = new TreeNode(0);

        if (t1 != null && t2 != null){
            root.val = t1.val + t2.val;
            root.left = mergeTrees(t1.left , t2.left);
            root.right = mergeTrees(t1.right , t2.right);
        }else if(t1 != null && t2 == null){
            root.val = t1.val;
            root.left = mergeTrees(t1.left , null);
            root.right = mergeTrees(t1.right , null);
        }else if (t1 == null && t2 != null){
            root.val = t2.val;
            root.left = mergeTrees(null , t2.left);
            root.right = mergeTrees(null,t2.right);
        }else {
            return null;
        }
        return root;
    }

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
