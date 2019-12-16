package design;

import LinkedList.ListNode;

import java.util.Random;

/*
https://www.jianshu.com/p/63f6cf19923d
https://leetcode.com/problems/linked-list-random-node/discuss/85662/Java-Solution-with-cases-explain

 */
public class reserviorSamplingTwo382And398{
      class LinkedList382{
          Random r ;
          ListNode head;
          public LinkedList382(ListNode head){
              r = new Random();
              this.head = head;
          }

          /*
            核心思想是蓄水池算法。 你不用证明。
            这里的关键是 拿一个节点 当作水池 初始就是头节点。随着链表的前行，count越来越大。 我们因为只要一个点。
            所以当random到0的时候 也就是1/K 的概率被选到，我们就替换我们水池。
           */
          public int getRandom(){
              int count = 1;
              ListNode reserviorNode = head;
              ListNode cur = head;
              while (cur != null){
                  if (r.nextInt(count++) == 0){
                      reserviorNode = cur;
                  }
                  cur = cur.next;
              }
              return reserviorNode.val;
          }
      }

    class Solution {
        int[] nums;

        public Solution(int[] nums) {
            this.nums = nums;
        }
        //同理 这里的重复的情况 也是这样。 用一个index 作为水池。 每次出现相等的。就随机选择。
        public int pick(int target) {
            int index = -1;
            int count = 1;
            Random random = new Random();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    if (random.nextInt(count++) == 0) {
                        index = i;
                    }
                }
            }
            return index;
        }
    }
}
