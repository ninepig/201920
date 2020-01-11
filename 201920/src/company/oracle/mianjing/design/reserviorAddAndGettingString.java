package company.oracle.mianjing.design;


import java.util.Random;

public class reserviorAddAndGettingString {
    Node dummy;
    Random r ;
    Node cur;
    public reserviorAddAndGettingString(){
        dummy = new Node("");
        r = new Random();
        cur = dummy;
    }

    public void addString(String a){
        Node thisNode = new Node(a);
        cur.next = thisNode;
        cur = thisNode;
    }

    public String evenGetNextTarget(String target){
        Node newHead = dummy.next;
        String res = null;
        int count = 1;
        while (newHead != null){
            if (newHead.val.equals(target) && newHead.next!=null){
                if (r.nextInt(count++)==0){
                    res = newHead.next.val;
                }
            }
            newHead = newHead.next;
        }
        return res == null ? "nothing" : res;
    }
}

class Node{
        String val;
        Node next;
        public Node(String val){
        this.val = val;
        }
    }