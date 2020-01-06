package company.oracle.onsiteMianjing;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRU {

    Node head, tail;
    int size;
    int capacity;
    HashMap<Integer , Node> map ;


    public LRU(int capacity){
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        head.pre = null;
        tail.pre = head;
        tail.next = null;
        this.capacity = capacity;
        map = new HashMap<>();
        // forget to inital this
        size = 0;
    }

    public void deleteNode(Node node){
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }

    /*
     先操作node 在操作head
     */
    public void addToHead(Node node){
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    public int get(int key){
        if (map.containsKey(key)){
            Node temp = map.get(key);
            deleteNode(temp);
            addToHead(temp);
            return temp.val;
        }else {
            return -1;
        }
    }

    public void put(int key , int val){
        if (!map.containsKey(key)) {
            Node temp = new Node(val);
            map.put(key, temp);
            if (size < capacity) {
                addToHead(temp);
                size++;
            } else {
                map.remove(tail.pre.val);
                deleteNode(tail.pre);
                addToHead(temp);
            }
        }else {
            Node temp = map.get(key);
            temp.val = val; // update val in the node
            deleteNode(temp);
            addToHead(temp);
        }
    }
    class Node{
        int val;
        Node pre;
        Node next;

        public Node(int val) {
        }
    }


    public class LRUCache {
        private LinkedHashMap<Integer, Integer> map;
        private final int CAPACITY;
        public LRUCache(int capacity) {
            CAPACITY = capacity;
            map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
                protected boolean removeEldestEntry(Map.Entry eldest) {
                    return size() > CAPACITY;
                }
            };
        }
        public int get(int key) {
            return map.getOrDefault(key, -1);
        }
        public void set(int key, int value) {
            map.put(key, value);
        }
    }
}
