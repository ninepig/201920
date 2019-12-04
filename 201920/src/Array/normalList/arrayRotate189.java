package Array.normalList;

public class arrayRotate189 {
     static class solution {
        public void rotate(int[] nums, int k) {
            if (nums == null || nums.length == 0) return;
            k = k % nums.length;
            helper(nums, 0, k );
            helper(nums, k+1, nums.length - 1);
            helper(nums, 0, nums.length - 1);
        }

        private void helper(int[] nums, int left, int right) {
            while (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
    }

    public static  void main(String ... args){
        int[] nums = new int[] {1,2,3,4,5,6,7};
        int k = 3;
        solution a = new solution();
        a.rotate(nums,k);
         for (int num : nums){
             System.out.println(num);
         }
    }

}
