package company.oracle.mianjing.design;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
双向链表 + hashmap
hashmap 让get 变成 o 1
链表让删除/存放变成 o 1

链表操作要画图。
lru的任何操作 都要 delete + putHEAD操作

Consider a sequence of n append operations, where we start with an array of length 1.
A careful analysis shows that the total time of these operations is only Θ(n).

There will be a total of n constant-time assignment and increment operations.
The resizing will happen only at operation 1, 2, 4, …, 2k, for a total of 1 + 2 + 4 + …+ 2k = 2·2k - 1
constant-time element copy operations. Since 2k ≤ n, this is at most 2n - 1.
Hence, the amortized time complexity for a single append operation is Θ(1

Amoritezed time analysis , it a sequrence of operation between a time period. and we got the average time of that
for example if we got 100 operation. 99 of them is 0(1)  one is o(n), we can count that as o(1)


 */
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

    // 链表的移动操作 ，一定要画图
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
