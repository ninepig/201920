package tree.difficult;

import tree.TreeNode;

/**
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.
 * For example:
 * Given a binary tree {1,2,3,4,5},
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 * return the root of the binary tree [4,5,2,#,#,3,1].
 *    4
 *   / \
 *  5   2
 *     / \
 *    3   1
 * confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 *
 * Thought process:
 * After the flip, root and root.right will become siblings, and the left most child will become the new root. The idea is to traverse the tree to the left. As we traverse, we make root.left the new root, root.right the left child of new root, and root itself the right child of new root.
 */
/*
https://www.bilibili.com/video/av58693172/
虽然讲的不怎么样，但是画图表明了意义
   1
  2 3
 4 5
 对于 2 来说 他的左节点将是  3， 1 将是他的右节点。
 递归下去做即可。
 这道题关键是画图！ 把剩下的交给递归即可
 */
public class BinaryTreeUpsideDown {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
            if (root == null || root.left == null)
                return root;
            // 递归地找到最左节点，作为新的root
            TreeNode newRoot = upsideDownBinaryTree(root.left);
            root.left.left = root.right;
            root.left.right = root;
            // 根节点会变成右子节点 ， 所以要清空
            root.left = null;
            root.right = null;
            return newRoot;
    }

}
