package company.oracle.mianjing.design;

import java.util.*;

/*

https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=567603&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B2%5D%3D2%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D7%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
OCI 店面
店面。 问了unittest怎么做，用过linter没之类的。打得很烂。然后做题， 没找到LC原题， 但是不难，BFS就可以了。说面1小时，但是40分钟就结束了说Ok。 然后快过了一周收到hiring manager邮件说second technical chat。唉。 这次问了简历项目经历。
Linting is the process of running a program that will analyse code for potential errors.
1 framework
2 unit test plan
3 prepare test case
4 do unittest
https://stackoverflow.com/questions/40578588/java-bfs-to-a-limited-friendship-level-in-a-graph

LRU （linked）
不同level的friend？
给了一个dictionary， 找不同level 朋友，没找到lc原题，不难， BFS做就可以

 */
public class friendBfsAndLruTODO {
    public List<List<String>> friendFromDifferentLevel(HashMap<String,List<String>> dict , String start){

        if(dict == null || dict.size() == 0) return new ArrayList();

        List<List<String>> res = new ArrayList();
        Queue<String> q = new LinkedList<>();

        q.offer(start);
        int level = 0;

        while(!q.isEmpty()){
            int size = q.size();
            List<String> curLevel = new ArrayList();
            level++;
            for(int i = 0 ; i < size ; i++){
                String cur = q.poll();
                if(dict.containsKey(cur)){
                    for(String friend : dict.get(cur)){
                        curLevel.add(friend);
                        q.offer(friend);
                    }
                }
            }
            res.add(new ArrayList(curLevel));
        }
        return res;
    }
    // Lru will add recently used node to the head.
    class Lru{
        HashMap<Integer , Node> map ;
        Node head;
        Node tail;
        int count;
        int capactity;
        public Lru(int capactity){
            map = new HashMap<>();
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.pre = null;
            head.post = tail;
            tail.pre = head;
            tail.post = null;
            this.count = 0;
            this.capactity = capactity;
        }


        public void addToHead(Node node){
            node.pre = head;
            node.post = head.post;
            head.post.pre = node;
            head.post = node;
        }
        public void deleteNode(Node node){
            node.pre.post = node.post;
            node.post.pre = node.pre;
        }

        public void put(int key, int val){
            if(map.containsKey(key)){
                Node node = map.get(key);
                node.val = val;
                map.put(key,node);
                deleteNode(node);
                addToHead(node);
            }else {
                if (count < capactity){
                    Node node = new Node(key, val);
                    addToHead(node);
                    count++;
                }else {
                    Node node = new Node(key , val);
                    Node last = tail.pre;
                    map.remove(last.key);
                    deleteNode(last);
                    map.put(key,node);
                    addToHead(node);
                }
            }
        }
        public int get(int key){
            if (map.containsKey(key)){
                Node cur = map.get(key);
                deleteNode(cur);
                addToHead(cur);
                return cur.val;
            }else {
                return -1;
            }
        }

        class Node{
            int val;
            int key;
            Node pre;
            Node post;
            public Node(int key, int val){
                this.val = val;
                this.key = key;
            }
        }
    }
}
