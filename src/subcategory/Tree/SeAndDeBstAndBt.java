package subcategory.Tree;

import facebookprepare.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

/**
 * Created by yangw on 2019/7/3.
 * difference between se and de bst and bt
 * bst的顺序是固定的，只要用前序就能确定，
 * 但是bt 是不能光通过这个inorder能确定的，要至少2个序才可以
 * 所以这边要走的话 要加上辅助的数组，比如 # null 之类的
 * bst 只需要一个inorder就可以解决问题了
 * 但其实是通用的，只要你写出来，所以我感觉考 也就会考一个
 */
public class SeAndDeBstAndBt {
    private static final String spliter = ",";
    private static final String NN = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NN).append(spliter);
        } else {
            sb.append(node.val).append(spliter);
            buildString(node.left, sb);
            buildString(node.right,sb);
        }
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new ArrayDeque<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals(NN)) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}
