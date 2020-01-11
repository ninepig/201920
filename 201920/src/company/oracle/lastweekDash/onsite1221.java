package company.oracle.lastweekDash;

import jdk.nashorn.internal.ir.WhileNode;
import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Created by yangw on 2020/1/4.
 * regular follow up need think
 https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=579917&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B3%5D%3D3%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D7%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline *
 */
public class onsite1221 {
    /*
    DNS:
    Pc ---> local root dns server .root---> com or org  top level  --->
    xxxx.com second level---> host name--->ipaddress (register , bigdaddy--> register second level host)

    SQL performance
    --> explain keyword
    --> explain each query's performance
    sql performance tips
    https://database.51cto.com/art/201901/589633.htm

     */

    public int[] findFirstAndLastPostionOfTarget(int[] arr, int target) {
        if (arr == null || arr.length == 0) return new int[]{};
        int left = 0, right = arr.length - 1;
        int fisrt = -1, last = -1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (arr[left] == target) {
            fisrt = left;
        } else if (arr[right] == target) {
            fisrt = right;
        }

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (arr[right] == target) {
            last = right;
        } else if (arr[left] == target) {
            last = left;
        }
        return new int[]{fisrt, last};
    }

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s.charAt(i - 1) == p.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // ? can be one char or empty Char.
                if (p.charAt(i - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1] || dp[i][j - 1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    // Less or equal than
    public int findClosedNumberInbst(TreeNode root, int target) {
        int res = 0;
        TreeNode cur = root;
        Stack<TreeNode> s = new Stack<>();

        while (!s.isEmpty() || cur != null) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            cur = s.pop();
            if (cur.val <= target) {
                res = Math.max(res, cur.val);
            }
            cur = cur.right;
        }

        return res;
    }

    public List<Integer> findKClosedNumberInbst(TreeNode root, int target , int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(k);
        TreeNode cur = root;
        Stack<TreeNode> s = new Stack<>();

        while (!s.isEmpty() || cur != null) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            cur = s.pop();
            if (cur.val <= target) {
                if (q.size() >= k){
                    q.poll();
                }
                q.offer(cur.val);
            }
            cur = cur.right;
        }
        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()){
            res.add(q.poll());
        }
        return res;
    }


    // 第五轮design，各种乱七八糟背景，但实质上就是mapreduce，先1个机器怎么做，后来数据量大了怎么办，so就MapReduce的原理说一下，出现failure怎么办。replica。

}