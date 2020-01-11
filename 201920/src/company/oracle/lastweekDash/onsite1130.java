package company.oracle.lastweekDash;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=574496&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B3%5D%3D3%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D7%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
 redwood 所以应该不是IAM
 */
public class onsite1130 {
    /*
    todo
    dfs strange 题目
    第一题：https://www.1point3acres.com/bbs/thread-572648-1-1.html， 当场没有想到brute force 之外的解法（现在也没想出来。。）于是换了一题
第二题： 字符串匹配，先写了个brute force的然后让我优化，当场不会写kmp， 遂卒。
     */


    class StringMatch{
        public boolean brutalForce(String s, String p){
            if ( s== null || p == null) return false;
            int sLength = s.length(), pLenght = p.length();
            for (int i = 0 ; i < sLength - pLenght ;i++){
                    int j = 0;
                    for ( ; j < pLenght ; j++){
                        if (s.charAt(i+j) != p.charAt(j)){
                            break;
                        }
                    }
                    if (j == pLenght) return true;
            }
            return false;
        }


        //KMP
        public boolean KMP(String s , String p){
            if (s == null || p == null) return false;
            int[] preSufArray = helper(p.toCharArray());
            int i = 0 , j = 0;
            while (i < s.length() && j < p.length()){
                if (s.charAt(i) == p.charAt(j)){
                    i++;
                    j++;
                }else {
                    if(j!=0){
                        j = preSufArray[j - 1];
                    }else {
                        i++;
                    }
                }
            }
            if (j == p.length()){
                return true;
            }
            return false;
        }

        private int[] helper(char[] p) {
            int[]preSufArray = new int[p.length];
            int index = 0;
            for (int i = 1 ; i< preSufArray.length ; i++){
                if (preSufArray[i] == preSufArray[index]){
                    preSufArray[i] = index + 1;
                    index++;
                    i++;
                }else {
                    if (index != 0){
                        index = preSufArray[index - 1];
                    }else {
                        preSufArray[i] = 0;
                        i++;
                    }
                }
            }
            return preSufArray;
        }
    }

    /*
    傻吊系列
     */

    /*
    LRU
     */
    class LruLinkedList{
        private LinkedHashMap<Integer, Integer> map ;
        private int capacity;
        public LruLinkedList(int capacity){
            this.capacity = capacity;
            map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f,true){
              protected boolean removeEldestEntry(Map.Entry eldest){
                  return size() > capacity;
              }
            };
        }
        public int get(int key){
            return map.getOrDefault(key, - 1);
        }
        public void put(int key , int value){
            map.put(key, value);
        }
    }


    class LruNormal{
        HashMap<Integer, Node> map;
        Node head, tail;
        int size;
        int capacity;

        public LruNormal(int capacity){
            this.capacity = capacity;
            this.size = 0;
            head = new Node(0,0);
            tail = new Node(0,0);
            head.pre = null;
            head.next = tail;
            tail.pre = head;
            tail.next = null;
            map = new HashMap<>();
        }

        public void addToHead(Node node){
            // 先连接无关的 再连接相关的
            node.pre = head;
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
        }

        public void removeNode(Node node){
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        public int get(int key){
            if (!map.containsKey(key)){
                return -1;
            }else {
                Node temp = map.get(key);
                removeNode(temp);
                addToHead(temp);
                return temp.val;
            }
        }

        public void put(int key , int val){
            if (!map.containsKey(key)){
                Node temp = new Node(val,key);
                if (size < capacity){
                    map.put(key, temp);
                    addToHead(temp);
                    size++;
                }else {
                    // remove tail one then add
                    // 一直搞错了啊！ 要有一个key的值
                    map.remove(tail.pre.key);
                    removeNode(tail.pre);
                    map.put(key,temp);
                }
            }else{
                Node temp = map.get(key);
                temp.val = val;
                removeNode(temp);
                addToHead(temp);
            }
        }
    }

    class Node{
        // 一直搞错了啊！ 要有一个key的值

        Node pre, next;
        int val;
        int key;
        public Node(int val,int key){
            this.val = val;
            this.key = key;
        }
    }

}
