package subcategory.binarysearch;

/**
 * Created by yangw on 2019/7/1.
 */
public class DivideTwoInteger {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if(dividend ==0){
            return 0;
        }
        if(dividend>0&&divisor<0){
            sign = -1;
        }
        if(dividend<0&&divisor>0){
            sign =-1;
        }

        long dend = Math.abs((long) dividend);
        long dsor = Math.abs((long) divisor);

        long ans = getDivide(dend,dsor);
        int res;
        if(ans>Integer.MAX_VALUE){
            res = sign>0?Integer.MAX_VALUE:Integer.MIN_VALUE;
        }else{
            res = sign*(int)ans;
        }
        return res;

    }
    public long getDivide(long dividend, long divisor){
        if(dividend<divisor){
            return 0;
        }
        long sum = divisor;
        long mul = 1;
        while((sum+sum)<dividend){
            sum +=sum;
            mul += mul;
        }
        return mul + getDivide(dividend-sum,divisor);
    }
}
