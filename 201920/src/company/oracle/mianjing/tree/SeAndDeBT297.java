package company.oracle.mianjing.tree;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
利用前序来做
然后用一个 NULL 来作为区别符号
如果没有node 用null来代替
这样de的时候 就可以同样利用前序的特点来解决


3. serialize and deserialize binary tree 沒要寫 但問你思路
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





class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}
    class Codec {

        // Encodes a tree to a single string.
        public String serialize(Node root) {
            if (root == null) return "";

            Queue<Node> que = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toString(root.val)).append(",#,");
            que.add(root);

            while (!que.isEmpty()) {
                Node node = que.poll();
                for (Node n : node.children) {
                    sb.append(Integer.toString(n.val)).append(",");
                    que.add(n);
                }
                sb.append("#,");
            }

            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public Node deserialize(String data) {
            if (data.length() == 0) return null;
            String[] s = data.split(",");

            Queue<Node> que = new LinkedList<>();
            Node root = new Node(Integer.parseInt(s[0]), new ArrayList<Node>());
            que.add(root);
            int i = 1;

            while (!que.isEmpty()) {
                Node node = que.poll();
                i++;
                while (!s[i].equals("#")) {
                    Node c = new Node(Integer.parseInt(s[i]), new ArrayList<>());
                    node.children.add(c);
                    que.add(c);
                    i++;
                }
            }

            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

}
