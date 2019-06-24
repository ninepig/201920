package binarysearch;

/**
 * Created by yangw on 2019/6/23.
 * 也是利用二分的思想。
 * leetcode 50
 * 这道题在于分析出如何舍弃，如何二分。以及edge case。
 */
public class myPow {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        if(n < 0 ){
            x = 1/x;
            n = -n;
        }
        if(n % 2 == 0){
            return myPow(x*x, n/2);
        }else{
            return x * myPow(x*x , n/2);
        }
    }
}