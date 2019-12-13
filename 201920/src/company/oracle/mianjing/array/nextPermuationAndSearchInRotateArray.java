package company.oracle.mianjing.array;

/*
https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=565380&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B2%5D%3D2%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D7%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline

上来先自我介绍，然后做题：

黎寇姗姗
哩抠伞衣

代码、测试、测了测corner case。

做完还剩下一些时间，小姐姐面试的时候英语很纯正，一点口音都没有，结果竟然会说中文。

我们就用中文，交流了一下公司的发展，组的发展和个人的发展。
 */
public class nextPermuationAndSearchInRotateArray {
    public static void nextPermuation(int[] target){
        int length = target.length;
        int i = target.length - 1;
        for ( ; i > 0 ; i--){
            if (target[i - 1] < target[i]){
                break;
            }
        }
        // Located first number decresasing from end.
        i--;
        // Located first Number bigger than target[i] from end.
        int j = target.length -1;
        while ( j >= 0 && target[j] < target[i]){
            j--;
        }
        // swap them.
        int temp = target[i];
        target[i] = target[j];
        target[j] = temp;

        // reverse from i + 1;
        reverse(target, i+1);

    }

    private static void reverse(int[] target, int i) {
        int l = i , r = target.length - 1;
        while (l < r){
            int temp = target[l];
            target[l] = target[r];
            target[r] = temp;
            l++;
            r--;
        }
    }

    public static void main(String ...args){
        int[] arr = new int[]{3,1,4,2,5,4};
        nextPermuation(arr);
        for (int a : arr ){
            System.out.println(a);
        }
    }

    // No duplication
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int l = 0 , r = nums.length - 1;
        while (l + 1 < r){
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[r]){
                if ( target >= nums[mid] && target <= nums[r]){
                    l = mid;
                }else{
                    r = mid;
                }
            }else {
                if (target <= nums[mid] && target >= nums[l]){
                    r = mid;
                }else {
                    l = mid;
                }
            }
        }
        if (nums[l] == target){
            return l;
        }else if (nums[r] == target){
            return r;
        }else {
            return -1;
        }
    }

    public boolean search2(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return false;
        int start = 0;
        int end = nums.length-1;
        int mid;
        while(start + 1 < end){
            mid = start + (end -start)/2;
            if(nums[mid] == target) return true;
            if(nums[mid] > nums[start]){
                if(nums[mid] >= target && nums[start] <= target) end = mid;
                else start = mid;
            }else if (nums[mid] < nums[start]){
                if(nums[mid]<= target && nums[end]>=target) start = mid;
                else end = mid;
            }else{
                // start = mid = end;
                start++;
            }
        }
        if(nums[start] == target || nums[end] == target){
            return true;
        }
        return false;
    }
}
