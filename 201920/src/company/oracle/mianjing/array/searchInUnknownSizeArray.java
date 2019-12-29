package company.oracle.mianjing.array;

public class searchInUnknownSizeArray {
    public int search (int[] arr ,  int target){
        int l = 0 , h = 1;

        while (helper(arr, h) < target){
            l = h;
            h *= 2;
        }

        while (l + 1 < h){
            int m = l + (h - l) /2 ;
            if (helper(arr,m) == target){
                return m;
            }else if (helper(arr,m) > target){
                h = m-1;
            }else h = m + 1;
        }
        return -1;
    }

    private int helper(int[] arr , int index){
        return 0;
    }
}
