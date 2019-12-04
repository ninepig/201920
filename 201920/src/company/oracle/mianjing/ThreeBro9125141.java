package company.oracle.mianjing;

import LinkedList.ListNode;

import java.util.HashSet;
import java.util.Set;

/*
https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=549779&extra=page%3D2%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B2%5D%3D2%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D7%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline

对方介绍组里做啥，自己做啥
没有问我简历或者BQ，直接上题
非常简单的三道题
LC 第九题，题设跟原题不太一样，case-121也算是有效 palindrome
LC 易二武 忽略大小写和符号，只考虑letter 判断这个输入是不是palindrome，题设应该是跟原题一模一样
LC 意思意 followup是如果不用two pointer怎么做
写完了还有时间 就闲聊了一会儿
要onisite需要大米 感谢

 */
public class ThreeBro9125141 {
    public boolean isPalindrome(int x) {
            if (x == 0) return true;
            int cur = Math.abs(x);
            if (cur < 10){
                return true;
            }

            int newRes = 0;
            while (cur != 0){
                newRes = newRes * 10 + cur % 10;
                cur = cur /10;
            }
            return cur == newRes;
    }
// small bug
        public boolean isPalindrome(String s) {
            if (s == null || s.length() == 0) return false;
            String ignoreCaseS = s.toLowerCase();
            int l = 0 , r = ignoreCaseS.length() - 1;
            while (l < r){
                // need use ! , not alphabetic
                while (l < r && !Character.isAlphabetic(ignoreCaseS.charAt(l))){
                    l++;
                }
                while (l < r && !Character.isAlphabetic(ignoreCaseS.charAt(r))){
                    r--;
                }
                if (ignoreCaseS.charAt(l) != ignoreCaseS.charAt(r)){
                    return false;
                }
                l++;
                r--;
            }
            return true;
        }

        // 141 ， two pointer or hashset!
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}

