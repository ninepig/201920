package company.oracle;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
Kth largest.
 */
public class KthLargestArray215 {
    // Sorting , nlogn
    public int getKth(int[] arr , int k){
        if (arr == null || arr.length ==0) return -1;
        Arrays.sort(arr);
        return arr[arr.length - k];
    }

    // Heap , nlogk
    public int getKth2(int[] arr , int k){
        PriorityQueue<Integer> p = new PriorityQueue<>();
        for (int num : arr){
            p.offer(num);
            if (p.size() > k){
                p.poll();
            }
        }
        return  p.peek();
    }

    // best o (n) worst o(n^2)
    public int getKth3(int[] arr , int k ){

        return  quickSelect(arr, 0 , arr.length - 1 , arr.length - k);
    }
    //By default it goes to be ascding order.
    private int quickSelect(int[] arr, int start, int end, int targetK) {
        if (start > end) return Integer.MAX_VALUE;

        int pivot = arr[end];
        int left = start;
        for (int i = start ; i < end ; i++){
            if (arr[i] <= pivot){
                // Put number less that pivot to left.
                swap(arr, left++ , i);
            }
        }
        // Swap pivot back to it position.
        swap(arr, left , end);

        if (left == targetK){
            return arr[left];
        }else if(left < targetK){
            return quickSelect(arr, left + 1 ,end , targetK);
        }else {
            return quickSelect(arr, left - 1 , end ,targetK);
        }
    }

    private void swap(int[] number, int left, int right) {
        int temp = number[right];
        number[right] = number[left];
        number[left] = temp;
    }
}
