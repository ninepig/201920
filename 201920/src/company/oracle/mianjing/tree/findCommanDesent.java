package company.oracle.mianjing.tree;

import LinkedList.ListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
find common descent（即一个node可以有多个parents，但是每个node的child是固定的）：

follow up recent one
 */
public class findCommanDesent {

    class Node {
        ArrayList<Node> children;
        char val;
    }

    // Question one , any
    public Node findAnyCommonDesent(Node a, Node b) {
        if (a == null || b == null) return null;
        ArrayList<Node> listA = new ArrayList<>();
        ArrayList<Node> listB = new ArrayList<>();
        travel(a, listA);
        travel(b, listB);

        for (Node bchild : listB) {
            if (listA.contains(bchild)) {
                return bchild;
            }
        }
        return null;
    }

    private void travel(Node a, ArrayList<Node> listA) {
        if (a == null) return;
        listA.add(a);
        for (Node child : a.children) {
            travel(child, listA);
        }
    }

    // Question follow up , most recent
    public Node findAnyCommonRecentDesent(Node a, Node b) {
        if (a == null || b == null) return null;
        ArrayList<Node> listA = new ArrayList<>();
        ArrayList<Node> listB = new ArrayList<>();
        // level order travel
        travelBfs(a, listA);
        return travelBfsSecond(b,listA,listB);
    }

    private Node travelBfsSecond(Node b, ArrayList<Node> listA, ArrayList<Node> listB) {
        Queue<Node> q = new LinkedList<>();
        q.offer(b);
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0 ; i < size; i++){
                Node temp = q.poll();
                if(listB.contains(temp)){
                    return temp;
                }
                listA.add(temp);
                for (Node child : temp.children){
                    if (child!=null){
                        q.offer(child);
                    }
                }
            }
        }
        return null;
    }

    private void travelBfs(Node a, ArrayList<Node> listA) {
        Queue<Node> q = new LinkedList<>();
        q.offer(a);
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0 ; i < size; i++){
                Node temp = q.poll();
                listA.add(temp);
                for (Node child : temp.children){
                    if (child!=null){
                        q.offer(child);
                    }
                }
            }
        }
    }
}