package facebookprepare;

/**
 * Created by yangw on 2019/7/2.
 */
public class plusOne {
    public int[] plusOne(int[] digits) {
        if(digits==null||digits.length==0){
            return new int[]{};
        }
        for(int i = digits.length-1;i>=0;i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }
            digits[i]=0;
        }
        int[] res =new int[digits.length+1];
        res[0]=1;
        return res;
    }
}
