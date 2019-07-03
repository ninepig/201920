package facebookprepare;

/**
 * Created by yangw on 2019/7/2.
 */
public class summaryRange {

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums==null||nums.length==0){
            return res;
        }
        if(nums.length==0){
            res.add(nums[0]+"");
        }
        for(int i = 0; i<nums.length;i++){
            int lower = nums[i];
            while (i<nums.length-1&&nums[i+1]-nums[i]==1){
                i++;
            }
            if(lower==nums[i]){
                res.add(nums[i]+"");
            }else {
                res.add(lower+"->"+nums[i]);
            }
        }
        return res;
    }
}
