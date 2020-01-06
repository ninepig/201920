package subcategory.bit;

/**
 * Created by yangw on 2019/7/6.
 * hamming distance 可以等于 每一位的0 和 1 的总数相乘，所以只要循环32次，每次计算一位的0 和 1 的数量。
 * 计算pairs 总和即可
 */
public class totalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        int total = 0, n = nums.length;
        for (int j=0;j<32;j++) {
            int bitCount = 0;
            for (int i=0;i<n;i++)
                bitCount += (nums[i] >> j) & 1;
            total += bitCount*(n - bitCount);
        }
        return total;
    }
}
