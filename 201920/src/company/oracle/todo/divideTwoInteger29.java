package company.oracle.todo;

/*
https://leetcode.com/problems/divide-two-integers/discuss/142849/C%2B%2BJavaPython-Should-Not-Use-%22long%22-Int
bit ?
 */
public class divideTwoInteger29 {
    public int divide(int dividend, int divisor) {
        if(dividend == 0){
            return 0;
        }
        int sign = 1;

        if(dividend > 0 && divisor < 0){
            sign = -1;
        }
        if(dividend < 0 && divisor > 0){
            sign = -1;
        }

        long divid =  Math.abs((long)dividend);
        long divis =  Math.abs((long)divisor);

        long res = helper(divid, divis);

        int ans ;
        if(res>Integer.MAX_VALUE){
            ans = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }else{
            ans = (int) (sign * res);
        }
        return ans;
    }
    // Core algorithem.  X = 1 + 2 + 4 + 8....
    /*
    这部分是核心 ~ 越看越觉得牛逼
     */
    private long helper(long divedent, long divisor){
        if(divedent < divisor){
            return 0;
        }

        long sum = divisor;
        long mul = 1;
        while((sum+sum) <= divedent){
            sum += sum;
            mul += mul;
        }

        return mul + helper(divedent - sum, divisor);
    }
}

class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        boolean sign = (dividend < 0) == (divisor < 0);
        dividend = dividend > 0? -dividend: dividend;
        divisor = divisor > 0? -divisor: divisor;
        int res = divideHelper(dividend, divisor);
        return sign? res: -res;
    }

    public int divideHelper(int dividend, int divisor){
        if(divisor < dividend) return 0;
        int sum = divisor, m = 1;
        while((Integer.MIN_VALUE - sum < sum) && (sum + sum > dividend)){
            sum += sum;
            m += m;
        }
        return m + divideHelper(dividend - sum, divisor);
    }

    private int divideHelperBitWay(int dividend, int divisor){
        // base case
        if(divisor < dividend) return 0;
        // get highest digit of divisor
        int cur = 0, res = 0;
        while((divisor << cur) >= dividend && divisor << cur < 0 && cur < 31) cur++;
        res = dividend - (divisor << cur-1);
        if(res > divisor) return 1 << cur-1;
        return (1 << cur-1)+divide(res, divisor);
    }
}