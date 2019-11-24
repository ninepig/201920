package company.oracle.mianjing;

import java.util.ArrayList;
import java.util.List;

public class permutation46needfollowup {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        List<Integer> cur = new ArrayList<>();
        helper(res,cur,nums,0);
        return res;
    }

    private void helper(List<List<Integer>> res,List<Integer> cur,int[] nums, int pos){
        if(cur.size() == nums.length){
            res.add(new ArrayList(cur));
            return;
        }else{
            for(int i = pos ; i < nums.length ; i++){
                if(cur.contains(nums[i])){
                    continue;
                }
                cur.add(nums[i]);
                // Because it is permutation. So i need keep pos here , not using pos+1! and using duplcated remove method to remove duplciated.
                helper(res,cur,nums,pos);
                cur.remove(cur.size()-1);
            }
        }
    }
}
