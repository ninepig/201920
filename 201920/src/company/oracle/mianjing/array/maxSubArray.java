package company.oracle.mianjing.array;

/*

https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=572539&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B2%5D%3D2%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D7%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline

雾散
follow up: 打印maximum sub的区间
接着问了time and space complexity, 问sorted array最快的搜索方法和time（binary search logN)，BST的search time（log N, wrong N），hashmap的confict解决（increase bucket size），double linked list delete time（operation O(1), search O(n)）
最后五分钟问问题。


analytics Cloud组
面试官是个印度大哥，口音不重，感觉人还比较nice
上来10分钟他先讲这个组的情况，然后问了下interest。
再给了链接做题，就是刷题网舞伞。
然后简单地问了下system design，limit 5 requests per user per minute，问single server和distributed会有什么concerns。
Rate limiting api
for single
1 when we have bunch of user, the server will down.
2 even smaller user , need do repilca.

for distrubuted
1 more cost
2 global rate limit , loader balacer
3 if it is nessarary!

最后一点时间问了下简历。
感觉还挺全套的。


 */
public class maxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int local = nums[0];
        int global = nums[0];
        for (int i = 1; i < nums.length ; i++){
            local = Math.max(nums[i] , local + nums[i]);
            global = Math.max(local, global);
        }
        return global;
    }

    public static int maxSubArrayPrintingOut(int[] A) {
        int max = Integer.MIN_VALUE, sum = 0;
        int left = 0 , right = 0;
        for (int i = 0; i < A.length; i++) {
            if (sum < 0) {
                sum = A[i];
                left = i;
            }
            else
                sum += A[i];
            if (sum > max) {
                max = sum;
                right = i;
            }
        }
        for (int i = left ; i <= right ; i++){
            System.out.println(A[i]);
        }
        return max;
    }
    // Driver code
    public static void main(String[] args) {
        int[] a = new int[]{ -2, -3, 4, -1, -2, 1, 5, -3 };
        int n = a.length;
       maxSubArrayPrintingOut(a);
    }
}
