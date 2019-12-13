package company.oracle.mianjing.tree;

/*
https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=555176&extra=page%3D2%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B2%5D%3D2%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D7%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
1. 把一个BST转化为双向链表
2. 给一个unsigned int, 统计总共有多少个bit 是1。 写完后跟我说有个要求是不能用 if 和 循环

30 分钟写完，对面也是毫不含糊，跟我说会有onsite然后直接挂了电话。。。
 */
public class russianBstToDlinkedlistAndBit {
    node pre, head;

    public node bstToDlinkedList(node root) {
        if (root == null) return root;
        pre = null;
        head = null;
        inorderHelper(root);
        // 最早的头结点 pre这时候已经是最后一个节点了。 我们把它连起来
        // if we dont  need loop. we don't need these two line
        pre.right = head;
        head.left = pre;

        return head;
    }

    private void inorderHelper(node thisNode) {
        if (thisNode == null) return;
        inorderHelper(thisNode.left);
        node cur = new node(thisNode.val, null, null);
        if (head == null) {
            head = cur;
        }
        // Connect prenode and cur node
        if (pre != null) {
            pre.right = cur;
            cur.left = pre;
        }
        pre = cur;
        inorderHelper(thisNode.right);
    }

    public class node {
        int val;
        node left, right;

        public node(int val, node left, node right) {

        }
    }

    public int getOneInNumber(int number) {

        int count = 0;
        for (int i = 0; i <= 31; i++) {
            if (((number >> i) & 1) == 1)
                count++;
        }

        return count;
    }

    int[] helper = new int[256];

    public int getOneInNumberWithoutIf(int number) {
        return helper[number & 0xff] + helper[number >> 8 & 0xff] + helper[number >> 16 & 0xff] + helper[number >> 24 & 0xff];
    }
}
