package subcategory.array;

/**
 * Created by yangw on 2019/7/6.
 */
public class maxConsectutiveOne {
    // 至多有k个可以改变，最长连续1有多长
    // 还有个题 是改变1次。最长 ， 那就是k= 1
    public int longestOnes(int[] A, int K) {
        int zeroCount=0,start=0,res=0;
        for(int end=0;end<A.length;end++){
            if(A[end] == 0) zeroCount++;
            while(zeroCount > K){
                if(A[start] == 0) zeroCount--;
                start++;
            }
            res=Math.max(res,end-start+1);
        }
        return res;
    }




    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int longestResult = Integer.MIN_VALUE;
        int currentOnes = 0;

        for(int i = 0 ; i < nums.length; i++){
            if(nums[i]==1){
                currentOnes++;
            }else {
                longestResult = Math.max(longestResult,currentOnes);
                currentOnes=0;
            }
        }
        return Math.max(longestResult,currentOnes);
    }
}
