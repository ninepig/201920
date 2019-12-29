package company.oracle.mianjing.tree;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SeAndDeTree {

    public String seriousTree(TreeNode root){
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // Level order travel to seTree
        while (!q.isEmpty()){
            TreeNode temp = q.poll();
            if (temp == null){
                sb.append("NULL ");
            }
            sb.append(root.val + " ");
            q.offer(root.left);
            q.offer(root.right);
        }
        return sb.toString();
    }

    public TreeNode deTree(String res){
        if (res == null || res.length() == 0) return null;
        String[] nodes = res.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        for (int i = 1 ; i < nodes.length ; i++){
            TreeNode cur = q.poll();
            if (nodes[i].equals("NULL")){
                cur.left = new TreeNode(Integer.parseInt(nodes[i]));
                q.offer(cur.left);
                i++;
            }
            if (nodes[i].equals("NULL")){
                cur.right = new TreeNode(Integer.parseInt(nodes[i]));
                q.offer(cur.right);
                i++;
            }
        }
        return root;
    }

    public String seTree2(mTree root){
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<mTree> q = new LinkedList<>();
        //必须一开始就把root的放进去， 要不然无法处理子层的问题， 因为每一层要#结束 同时要处理child 的逻辑
        sb.append(root.val + ",#,");
        q.offer(root);
        while (!q.isEmpty()){
            mTree temp = q.poll();
            for (mTree child : temp.children){
                sb.append(child.val+",");
                q.offer(child);
            }
            // after ending use # to end
            sb.append("#,");
        }
        return sb.toString();
    }

    public mTree deTree2(String res){
        if (res == null || res.length() ==0) return null;
        Queue<mTree> q = new LinkedList<>();
        String[] nodes = res.split(",");
        mTree root = new mTree(Integer.parseInt(nodes[0]) , new ArrayList<mTree>());
        q.offer(root);
        int index = 1;
        while (!q.isEmpty()){
            mTree temp = q.poll();
            index++;
            // Go through current level.
            while (!nodes[index].equals("#")){
                mTree tempChild= new mTree(Integer.parseInt(nodes[index]));
                temp.children.add(tempChild);
                index++;
                q.offer(tempChild);
            }
        }
        return root;
    }
}

class mTree{
    int val ;
    ArrayList<mTree> children;
    public mTree(int val , ArrayList<mTree> children){
        this.val = val;
        this.children = children;
    }
    public mTree(int val){

    }
}
