package subcategory.array;

/**
 * Created by yangw on 2019/7/5.
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || m == 0 || nums2== null || n == 0) return;
        int newIndex = m + n - 1;
        int index1 =  m - 1;
        int index2 = n -1 ;
        while (index1 >= 0 && index2 >= 0){
            if (nums1[index1] >= nums2[index2]){
                nums1[newIndex] = nums1[index1--];
            }else {
                nums1[newIndex] = nums2[index2--];
            }
            newIndex--;
        }
        while (index2>=0){
            nums1[newIndex--] = nums2[index2--];
        }

    }
}
