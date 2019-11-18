package Array.normalList;

import java.util.HashMap;

public class twoSum001 {
    public int[] twoSumBrutal(int[] nums, int target) {

        if (nums == null || nums.length == 0)
            return null;
        int answerLeft = 0, answerRight = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    answerLeft = i;
                    answerRight = j;
                    break;
                }
            }
        }
//        int[] answer = new int[2];
//        answer[0] = answerLeft;
//        answer[1] = answerRight;
        return new int[] {answerLeft, answerRight};
    }

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return null;
        HashMap<Integer , Integer> map = new HashMap<>();
        for (int i = 0 ; i < nums.length ;i++){
            if (map.containsKey(target - nums[i])){
                return new int[] { map.get(target - nums[i]), i};
            }else {
                map.put(nums[i],i);
            }
        }
        return null;
    }
}
