package company.oracle.mianjing.design;


import java.util.Random;

public class reserviorAddAndGettingString {
    Node head;
    Random r ;
    Node cur;
    public reserviorAddAndGettingString(){
        head = new Node("");
        r = new Random();
        cur = head;
    }

    public void addString(String a){
        Node thisNode = new Node(a);
        cur.next = thisNode;
        cur = thisNode;
    }

    public String evenGetNextTarget(String a){
        Node newHead = head.next;
        String res = null;
        int count = 1;
        while (newHead != null){
            if (newHead.val.equals(a) && newHead.next!=null){
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