package tree;

public class ConvertSortedArryToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return helper(nums,0,nums.length -1 );
    }

    private TreeNode helper(int[] nums, int l , int r){
        //TODO 二分法的注意事项。结束条件。也就是while loop里的东西 l>r
        if(l > r){
            return null;
        }

        int mid = l + (r-l)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums,l,mid - 1);
        root.right = helper(nums,mid + 1,r);

        return root;
    }
}
