package company.oracle.lastweekDash;

import sun.reflect.generics.tree.Tree;
import tree.TreeNode;

import java.util.*;


/**
 * Created by yangw on 2020/1/4.
 * https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=581058&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B3%5D%3D3%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D7%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
 */
// TODO MINdEPTH
public class onsite1228 {
    /*
    1. 蠡口 已领斯
    2. 蠡口 无私伞
     */
    public int maxDepthRercusive(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }

    public int maxDepth(TreeNode root){
        if (root == null) return 0;
        int depth = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0 ; i < size; i++){
                TreeNode temp = q.poll();
                if (temp.left!=null){
                    q.offer(temp.left);
                }
                if (temp.right!=null){
                    q.offer(temp.right);
                }
            }
            depth++;
        }
        return depth;
    }

    int maxLength = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        dfsHelper(root);
        return maxLength;
    }

    private int dfsHelper(TreeNode root) {
        if (root == null) return 0;
        int left =dfsHelper(root.left);
        int right = dfsHelper(root.right);

        maxLength =Math.max(maxLength, left + right);

        return Math.max(left , right) + 1;
    }

    class reverseIntervalMap{

        TreeMap<Integer,Integer> map = new TreeMap<>();

        public int get(int key){

            Map.Entry<Integer, Integer> leftBond = map.floorEntry(key);
            Map.Entry<Integer, Integer> rightBond = map.ceilingEntry(key);

            if (leftBond == null){
                return -1;
            }
            if (rightBond == null){
                return -1;
            }

            if (leftBond.getValue() != rightBond.getValue()){
                return -1;
            }

            return leftBond.getValue();

        }


        public boolean put(int beginKey, int endKey, int val){

            Map.Entry<Integer, Integer> leftLowerBond = map.floorEntry(beginKey);
            Map.Entry<Integer, Integer> rightLowerBond = map.ceilingEntry(beginKey);
            Map.Entry<Integer, Integer> leftHigherBond = map.floorEntry(endKey);
            Map.Entry<Integer, Integer> rightHigherBond = map.ceilingEntry(endKey);

            // Occupied
            if (rightLowerBond != null) {
                if (rightLowerBond.getKey() < endKey) {
                    return false;

                }
            }
            // Occupied
            if (leftHigherBond != null) {

                if (leftHigherBond.getKey() > beginKey) {
                    return false;
                }
            }

            if (leftLowerBond != null && rightHigherBond != null) {
                if (leftLowerBond.getValue() == rightHigherBond.getValue()) {
                    return false;
                }
            }
            map.put(beginKey,val);
            map.put(endKey,val);
            return true;
        }
    }

    public ListNode copyListNode(ListNode head){
        if (head == null) return head;
        HashMap<ListNode , ListNode> map = new HashMap<>();
        ListNode dummy = new ListNode();
        ListNode pre = dummy;
        ListNode temp = new ListNode();

        while (head != null){
            // Copy head.
            if (map.containsKey(head)){
                temp = map.get(head);
            }else {
                temp = new ListNode(head.val);
                map.put(head, temp);
            }

            // Copy Random.
            if (head.random != null) {
                if (map.containsKey(head.random)) {
                    temp.random = map.get(head.random);
                } else {
                    temp.random = new ListNode(head.random.val);
                    map.put(head.random, temp.random);
                }
            }

            pre.next = temp;
            pre = pre.next;
            head = head.next;
        }
        return dummy.next;
    }

    public ListNode copyListNodeWithoutMap(ListNode head) {
        if (head == null) return head;
        ListNode cur = head;
        while (cur != null){
            ListNode copy = new ListNode(cur.next.val);
            copy.next = cur.next;
            cur.next = copy;
            cur = cur.next.next;
        }
        cur = head;
        while (cur!=null){
            if (cur.random != null){
                // 因为 cur.next的random 指向的是 cur.random的next 因为这个next 复制的是cur.random这个点
                // 所以random必须是复制的点
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        // Extract copied list.
        // Recover old list.
        cur = head;
        ListNode dummy = new ListNode(0);
        ListNode copyPre = dummy;
        while (cur!=null){
            // Make copy to connect.
            // Remove copy.next
            copyPre.next = cur.next;
            cur.next = cur.next.next;
            copyPre = copyPre.next;
            cur = cur.next;
        }
        return copyPre.next;

    }
        private class ListNode {
        ListNode next,random;
        int val ;
        public ListNode(int val){

        }
        public ListNode(){

        }
    }



    // 2 , 3 will must be prime. so we start from 4.
    public int countPrime(int number){
        if (number <= 1) return 0;
        boolean[] helper = new boolean[number];
        int count = 0;
        for (int i = 2 ; i < number ; i++){
            if (helper[i] == false){
                count++;
            }
            for (int j = 2 ; i*j < number ; j++){
                helper[j*i] = true;
            }
        }
        return count;
    }
}
