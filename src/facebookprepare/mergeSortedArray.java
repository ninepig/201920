package facebookprepare;

/**
 * Created by yangw on 2019/6/30.
 */
public class mergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

       if(nums2==null||nums2.length==0){
        return ;
    }
    int merge = m+n-1;
    int index1 =m-1;
    int index2 =n-1;
        while(index1>=0&&index2>=0){
        if(nums1[index1]>=nums2[index2]){
            nums1[merge] = nums1[index1];
            index1--;
        }else{
            nums1[merge] = nums2[index2];
            index2--;
        }
        merge--;
    }
        while(index2>=0){
        nums1[merge]=nums2[index2];
        merge--;
        index2--;
    }
}
}
