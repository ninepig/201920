package subcategory.binarysearch;

/**
 * Created by yangw on 2019/6/22.
 */
public class sqrt {
    public int mySqrt(int x) {
        if(x < 0) return -1;
        long l = 1;
        long r = x;
        while(l + 1 < r){
            long mid = l + (r - l) / 2 ;
            if(mid * mid == x ){
                return (int) mid;
            }else if (mid*mid < x){
                l = mid;
            }else{
                r = mid;
            }
        }
        if(r * r <= x){
            return (int)r;
        }else{
            return (int)l;
        }
    }
}