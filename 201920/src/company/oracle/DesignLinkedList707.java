package company.oracle;

/*
https://www.1point3acres.com/bbs/thread-135566-1-1.html
这边的head就是头节点， 而不是指向头的点
在delete的时候 问题 n.next == null 就是清除 多余的连接。
 */
public class DesignLinkedList707 {
    class Node{
        int val ;
        Node next ;
        public Node(int val){
            this.val = val;
        }

        public Node (int val , Node next){
            this.val = val;
            this.next = next;
        }
    }

    private int count = 0;
    private Node head = null;
    private Node tail = null;

    public DesignLinkedList707(){

    }

    public int get(int index){
        if (index < 0 || index >= count) return -1;

        Node cur = head;
        while (index > 0){
            cur = cur.next;
            index--;
        }
        return cur.val;
    }

    public void addAtHead(int val){
        Node n = new Node(val);
        n.next = head;
        if (head == null){
            tail = n;
        }
        head = n;
        count++;
    }

    public void addAtTail(int val){
        Node n = new Node(val);
        if (tail != null) {
            n.next = tail;
        }else {
            head = n;
        }
        tail = n;
        count++;
    }

    public void addAtIndex(int index , int val){
        if (index > count) return;
        else if (index < 0) addAtHead(val);
        else if (index == count) addAtTail(val);
        else{
            Node cur = head;
            while (index > 1){
                cur = cur.next;
                index--;
            }
            // move to the node before target index

            Node n = new Node(val);
            n.next = cur.next;
            cur.next = n;
            ++count;
        }

    }

    public void deleteAtIndex(int index ){
        if (index > count) return ;
        --count;
        if (index == 0){
            // 删除头结点的注意事项 就是直接把next 给头 但是要把 n.next 去除， 因为我们已经有了head.next了
            // 两份内存~
            Node n = head.next;
            head = n;
            if (n != null)
                n.next = null;
            if (head == null)
                tail = null;
        }else{
            int idx = index;
            Node curr = head;
            while(index > 1){
                curr = curr.next;
                --index;
            }
            Node n = curr.next;
            curr.next = n.next;
            n.next = null;
            if(idx == count)
                tail = curr;
        }
    }

}
