package company.oracle.mianjing.array;


// 时间复杂度?
public class SumOfminNumberOfPerfectSquares {
    public int  minNumberOfPerfectSqures(int n){
        if (n <= 3){
            return n;
        }
        int res = n ;
        for (int i = 1 ; i <= n ; i++){
            int temp = i * i;
            if (temp > n) break;
            else{
                res = Math.min(res, 1 + minNumberOfPerfectSqures(n - temp));
            }
        }
        return res;
    }
}
