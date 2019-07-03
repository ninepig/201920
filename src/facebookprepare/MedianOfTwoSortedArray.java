package facebookprepare;

/**
 * Created by yangw on 2019/7/2.
 */
public class MedianOfTwoSortedArray {
    public double findMedianSortedArrays(int[] input1, int[] input2) {
        if(input1.length > input2.length){
            return findMedianSortedArrays(input2, input1);
        }
        int x = input1.length ,  y = input2.length;
        int low = 0, high = x;
        while( low <= high){
            int pivotX = (low + high)/2;
            int pivotY = (x + y + 1)/2 - pivotX;

            int maxLeftX = (pivotX == 0) ? Integer.MIN_VALUE : input1[pivotX - 1 ];
            int maxLeftY = (pivotY == 0) ? Integer.MIN_VALUE : input2[pivotY - 1 ];
            int minRightX = (pivotX == x) ? Integer.MAX_VALUE : input1[pivotX];
            int minRightY = (pivotY == y) ? Integer.MAX_VALUE : input2[pivotY];

            if(maxLeftX <= minRightY && maxLeftY <= minRightX){
                if( (x + y) % 2 == 1){
                    return (double) Math.max(maxLeftX, maxLeftY);
                }else{
                    return (double)(Math.max(maxLeftX,maxLeftY) + Math.min(minRightX,minRightY))/2.0;
                }
            }else if (maxLeftX > minRightY){
                high = pivotX - 1;
            }else{
                low =pivotX + 1;
            }
        }
        throw new Error();
    }
}
