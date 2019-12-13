package company.oracle.mianjing.array;

import LinkedList.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=558259&extra=page%3D2%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B2%5D%3D2%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D7%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline

合并K个Sort过的Array。 提出几种不同的solution，再聊一聊优化，分析时间复杂度等。
解出来了但代码有瑕疵，过程中也有卡壳。感谢国人小哥哥手下留情，全程follow着我得思路1小时也没掉线的Guide到最后。
想上岸真不容易啊。
 */
public class mergeKsortedArrayTODOkmp {
    // NLOGN N is the length of array
    public static List<Integer> mergeKsortedA(int[][] target) {
        if (target == null || target.length == 0) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        for (int[] row : target) {
            for (int number : row) {
                res.add(number);
            }
        }
        Collections.sort(res);
        return res;
    }

    public static void main(String... args) {
        int[][] res = new int[][]{
                {1, 2, 3, 4, 2, 2, 2},
                {2, 3, 2, 2, 2, 2, 2}
        };

        for (int c : mergeKsortedA(res)) {
            System.out.println(c);
        }
    }

    static class Node {
        int val;
        int x;
        int y;
        Node(int val , int x, int y){
            this.val = val;
            this.x = x;
            this.y = y;
        }
    }


    /*
      Using helper class
      NlogK
      N is the all elements
      K is the target array length
     */
    public static List<Integer> mergeKsortedB(int[][] target) {
        if (target == null || target.length == 0){
            return new ArrayList<>();
        }
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Node> q = new PriorityQueue<>(target.length , ((a,b) ->a.val - b.val));

        // Adding each head in to list
        for (int i = 0 ; i < target.length ; i++){
            q.offer(new Node(target[i][0], i , 0));
        }

        Node temp ;
        while (!q.isEmpty()){
            temp = q.poll();
            res.add(temp.val);
            if (temp.y + 1 < target[temp.x].length){
                q.offer(new Node(target[temp.x][temp.y + 1] , temp.x ,  temp.y + 1));
            }
        }
        return res;
    }

    /*


https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=558924&extra=page%3D2%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B2%5D%3D2%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D7%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
1. merge k sorted list 很快用堆秒了。说了说复杂度，同胞表示满意
2. 有两个string，找出首尾最多重叠多少？我说可以暴力，问要不要code。同胞说能不能效率高点？我假装想了一会说可以用KMP。问能不能写出code，我说一时可能写不出，就讲了讲思路。同胞表示满意。
     */

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> (a.val - b.val));

        for (ListNode listNode: lists){
            if(listNode != null){
                pq.offer(listNode);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (!pq.isEmpty()){
            ListNode cur = pq.poll();
            head.next = cur;
            if (cur.next != null){
                pq.offer(cur.next);
            }
            head = head.next;
        }
        return dummy.next;
    }
}