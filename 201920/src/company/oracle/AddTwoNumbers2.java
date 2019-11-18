package company.oracle;

import LinkedList.ListNode;

import java.util.ArrayList;

public class AddTwoNumbers2 {
    /*
     要移动 L1 L2 ！  一个是carry 一个是sum！
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode newHead = dummy;
        int carry = 0;
        while(l1 != null || l2 != null){
            int sum = 0 ;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            int digit = (sum + carry)%10;
            carry = (sum + carry)/10;
            newHead.next = new ListNode(digit);
            newHead = newHead.next;

        }

        if(carry != 0){
            newHead.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
