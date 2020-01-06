package subcategory.Tree;

import facebookprepare.ListNode;
import facebookprepare.TreeNode;

/**
 * Created by yangw on 2019/7/2.
 */
public class convertedSortedArrayTobst {
    public class Solution {
        private ListNode current;

        private int getListLength(ListNode head) {
            int size = 0;

            while (head != null) {
                size++;
                head = head.next;
            }
            return size;
        }

        public TreeNode sortedListToBST(ListNode head) {
            int size;

            current = head;
            size = getListLength(head);

            return sortedListToBSTHelper(size);
        }

        public TreeNode sortedListToBSTHelper(int size) {
            if (size <= 0) {
                return null;
            }
            TreeNode left = sortedListToBSTHelper(size / 2);
            TreeNode root = new TreeNode(current.val);
            current = current.next;
            TreeNode right = sortedListToBSTHelper(size - 1 - size / 2);

            root.left = left;
            root.right = right;
            return root;
        }

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums==null||nums.length==0){
            return  null;
        }
        int l =0;
        int r = nums.length-1;
        TreeNode root =  binarySearch(nums,l,r);

        return root;
    }

    private TreeNode binarySearch(int[] nums,int left, int right) {
        if (left>right){
            return null;
        }
        int mid = (left+right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = binarySearch(nums,left,mid-1);
        root.right =binarySearch(nums,mid+1,right);

        return root;
    }
}
