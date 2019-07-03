package facebookprepare;

/**
 * Created by yangw on 2019/7/2.
 */
public class intersectionOfTwolist {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        //get Alength get B Length
        int lengthA =getLength(headA);
        int lengthB =getLength(headB);
        //move A or B difference steps
        while (lengthA<lengthB){
            headB= headB.next;
            lengthB--;
        }
        while (lengthA>lengthB){
            headA = headA.next;
            lengthA--;
        }
        //get intersectionNode
        while (headA!=headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private int getLength(ListNode headB) {
        int result = 0;
        while (headB!=null){
            result++;
            headB = headB.next;
        }
        return result;
    }
}
