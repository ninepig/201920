package facebookprepare;

/**
 * Created by yangw on 2019/7/1.
 */
public class MultplyStrings {
    public String multiply(String num1, String num2) {
        int lengthA =num1.length(),lengthB = num2.length();
        int[] product = new int[lengthA+lengthB];
        for(int i = lengthA-1;i>=0;i--){
            for (int j = lengthB-1;j>=0;j--){
                int a = num1.charAt(i)-'0';
                int b = num2.charAt(j)-'0';
                product[i+j+1]+= a*b;
            }
        }
        int carry = 0;
        for(int i = product.length-1;i>=0;i--){
            int temp = (product[i]+carry)%10;
            carry = (product[i]+carry)/10;
            product[i] = temp;
        }
        StringBuffer sb = new StringBuffer();
        for (int nums:product){
            sb.append(nums);
        }
        while(sb.length()!=0&&sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        return sb.length()==0?"0":sb.toString();
    }
}
