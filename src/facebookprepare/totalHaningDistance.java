package facebookprepare;

/**
 * Created by yangw on 2019/7/1.
 */
public class totalHaningDistance {
    /*
    The first solution came to my mind is brute forcely iterate through each pair, then sum all Integer.bitCount(x ^ y)
     like what I mentioned here https://discuss.leetcode.com/topic/72093/java-1-line-solution-d But as you can imagine, it TLE...

Let's think about this problem another way. We can separate the calculation to do one bit at a time. For example, look
 at the rightmost bit of all the numbers in nums. Suppose that i numbers have a rightmost 0-bit, and j numbers have a 1-bit.
 Then out of the pairs, i * j of them will have 1 in the rightmost bit of the XOR. This is because there are i * j ways to choose one number
 that has a 0-bit and one that has a 1-bit. These bits will therefore contribute i * j towards the total of all the XORs.

Apply above algorithm to each bit (31 bits in total as specified in the problem), sum them together then we get the answer.

Reference: http://stackoverflow.com/questions/21388448/sum-of-xor-values-of-all-pairs
     */
    public int totalHammingDistance(int[] nums) {
        int n = 31;
        int len = nums.length;
        int[] countOfOnes = new int[n];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < n; j++) {
                countOfOnes[j] += (nums[i] >> j) & 1;
            }
        }
        int sum = 0;
        for (int count: countOfOnes) {
            sum += count * (len - count);
        }
        return sum;
    }
}
