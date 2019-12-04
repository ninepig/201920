package company.oracle;

import LinkedList.ListNode;


public class intersectionOfTwoLinkedList160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        ListNode pointerA = headA , pointerB = headB;
        if (lengthA > lengthB){
            for (int i = 0 ; i < lengthA - lengthB ; i++){
                pointerA = pointerA.next;
            }
        }else if (lengthA < lengthB){
            for (int i = 0 ; i < lengthB - lengthA ; i++){
                pointerB = pointerB.next;
            }
        }
        while (pointerA != pointerB){
            pointerA = pointerA.next;
            pointerB = pointerB.next;
        }
        return pointerA;
    }

    private int getLength(ListNode headA) {
        int length = 0;
        while (headA!=null){
            length++;
            headA = headA.next;
        }
        return length;
    }
}
