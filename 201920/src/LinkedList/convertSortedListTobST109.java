package LinkedList;

import tree.TreeNode;

/*
二分法的完美演示， 同时加上快慢指针！！绝了
 */
public class convertSortedListTobST109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return helper(head, null);
    }

    private TreeNode helper(ListNode head , ListNode tail) {
        if (head == tail) return null;
        ListNode fast = head, slow = head;
        while (fast != tail && fast.next != tail){
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = helper(head, slow);
        root.right = helper(slow.next , tail);
        return root;
    }
}
