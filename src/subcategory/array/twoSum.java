package subcategory.array;

import facebookprepare.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by yangw on 2019/7/4.
 */
public class twoSum {
    public int[] twoSum1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public int[] twoSum2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{};
        int l = 0 , r = nums.length;
        while ( l < r){
            if (nums[l] + nums[r] == target){
                return new int[]{l , r};
            }else if (nums[l] + nums[r] < target){
                l++;
            }else {
                r--;
            }
        }
        return new int[]{};
    }

    public boolean findTarget(TreeNode root, int k) {
        if (root==null){
            return false;
        }
        HashSet<Integer> set= new HashSet();

        return dfs(root,k,set);
    }

    private boolean dfs(TreeNode root, int k, HashSet<Integer> set) {
        if(root == null){
            return false;
        }
        if (set.contains(k-root.val)){
            return true;
        }
        set.add(root.val);
        return dfs(root.left,k,set)||dfs(root.right,k,set);
    }

    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public void add(int number) {
        if(map.containsKey(number)) {
            map.put(number, map.get(number) + 1);
        } else {
            map.put(number, 1);
        }
    }

    public boolean find(int value) {
        for (int key : map.keySet()) {
            int another = value - key;
            if (another == key && map.get(key) > 1) {
                return true;
            } else if (another != key && map.containsKey(another)) {
                return true;
            }
        }
        return false;

    }
}
