package binarysearch;

/**
 * Created by yangw on 2019/6/22.
 * lintcode 183
 * 经典的二分法题
 * 太牛逼的做法了~
 */
public class woodcut {
   public  int woodCut(int[] L ,int k){
       int l = 1 , res = 0;
       int r = 0;
       // Find longest wood
       for (int item : L){
           r = Math.max(r,item);
       }

       while ( l+1 < r){
           int mid = l + (r - l) / 2 ;
           if(count(L,mid) >= k){
               res = mid;
               // keep finding a bigger one;
               l = mid + 1;
           }else{
               r = mid - 1;
           }
       }
       return res;
   }
    // Get how many piece can a wood cut.
    private int count(int[] l, int mid) {
        int sum = 0;
        for (int item : l){
            sum += item/mid;
        }
        return sum;
   }


}
