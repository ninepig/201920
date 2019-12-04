package company.oracle;

public class findDuplicatedInArray287 {
    // Binary Search
    // fast and slow point
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int l = 0, r = nums.length - 1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            if (count <= mid) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    public int findDuplicate2(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int fast = 0 , slow = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (slow != fast);

        slow = 0;
        while (slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;

    }
}