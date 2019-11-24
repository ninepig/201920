package company.oracle;

public class JumpGame55 {

    /*
    global / local 的思想
     */
        public boolean canJump(int[] nums) {
            if (nums  == null || nums.length == 0) return false;
            int maxReach = 0;
            int canReach = 0;
            for (int i = 0 ; i< nums.length ;i++){
                if (canReach < i){
                    break;
                }
                maxReach = Math.max(maxReach , i + nums[i]);
                canReach = maxReach;
                if (maxReach >= nums.length - 1){
                    return true;
                }
            }
            return false;
        }

        public int reachTimes(int[] nums){
            if (nums == null || nums.length == 0) return 0;
            int reach = 0 ;
            int max = 0;
            int times = 0;
            for (int i = 0 ; i < nums.length ; i++){
                // if you can not get this i, you need one jump, we will choose the max step you can reach.
                if ( reach < i ){
                    times ++ ;
                    reach = max;
                }
                // update where you can jump.
                max = Math.max(max , i + nums[i]);
            }
            return times;
        }
}
