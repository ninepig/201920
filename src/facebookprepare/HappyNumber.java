package facebookprepare;

/**
 * Created by yangw on 2019/7/2.
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        if(n == 0 ){
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        while (true){
            int result  = getDigitSum(n);
            if(result==1){
                return true;
            }else {
                if(set.contains(result)){
                    return false;
                }else {
                    set.add(result);
                    n = result;
                }
            }
        }
    }

    private int getDigitSum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n%10;
            sum += digit*digit;
            n = n/10;
        }
        return sum;
    }
}
