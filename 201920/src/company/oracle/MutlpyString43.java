package company.oracle;

/*
关键是想明白 999 * 99 最大可能是 6位数。也就是1000 * 100 = 100000 ， 然后维护这样一个数组即可。
个位数相乘 最多会使用的就是2位。  也就是i + j + 1 位
 */
public class MutlpyString43 {

    public String multiply(String num1, String num2) {
        int lengthA = num1.length(), lengthB = num2.length();
        int[] product = new int[lengthA+lengthB];
        for(int i = lengthA-1 ; i >= 0 ;i--){
            for(int j = lengthB -1 ;j >= 0; j--){
                int numberA = num1.charAt(i) - '0';
                int numberB = num2.charAt(j) - '0';
                product[i+j+1] += numberA*numberB;
            }
        }

        int carry = 0;
        for(int i = product.length -1 ;i >= 0 ; i--){
            int reminder = (product[i]+carry)%10;
            carry = (product[i]+carry)/10;
            product[i] = reminder;
        }

        StringBuilder sb = new StringBuilder();
        for(int num : product){
            sb.append(num);
        }
        // Remove 0 at head.
        while(sb.length()!= 0 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0":sb.toString();

    }
}
