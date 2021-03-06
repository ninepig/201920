package design;

import java.util.HashMap;

public class Lru146 {
    class Node {
        int key;
        int value;
        Node pre ;
        Node next;
        public Node(int key , int value){
            this.value = value;
            this.key = key;
        }
    }

    HashMap<Integer , Node> map ;
    Node tail , head ;
    int count;
    int capacity;

    public Lru146(int capacity){
        this.capacity = capacity;
        map = new HashMap<>();
        tail = new Node(0,0);
        head = new Node(0,0);
        tail.pre = head;
        tail.next = null;
        head.pre = null;
        head.next = tail;
        count = 0;
    }

    public void addToHead(Node node){
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    public void deleteNode(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void put(int key , int val){
        if (map.containsKey(key)){
            Node node = map.get(key);
            node.value = val; // update val in the node
            deleteNode(node);
            addToHead(node);
        }else {
            Node node =new Node(key,val);
            map.put(key,node);
            if (count < capacity){
                count ++;
                addToHead(node);
            }else {
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
                addToHead(node);
            }
        }
    }

    public int get(int key){
        if (map.containsKey(key)){
            Node node = map.get(key);
            deleteNode(node);
            addToHead(node);
            return node.value;
        }else {
            return -1;
        }
    }
}
