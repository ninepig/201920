package company.oracle.mianjing.StringRelated;

import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;

/*

https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=560516&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B2%5D%3D2%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D7%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline

1 用string表示很大的数，将两个数相加2. 将两个数相乘

交流很重要，一开始没有清楚问明白，input的形式，想一些能想到的coner case


https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=563345&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B2%5D%3D2%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D7%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
昨天进行的30分钟电面 刷题网 死妖舞
10min coding
10min improve
10min 问面试官问题

今天收到邮件约时间昂赛
 */
public class bigNumberAddingAndMulp {

    // postive? or negtive? so we have different concern
    public static String twoStringAdd(String a, String b) {
        if (a == null) return b;
        if (b == null) return a;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int lengthA = a.length() - 1;
        int lengthB = b.length() - 1;
        while (lengthA >= 0 || lengthB >= 0) {
            int cur = 0;
            if (lengthA >= 0) {
                cur += a.charAt(lengthA) - '0';
                lengthA--;
            }
            if (lengthB >= 0) {
                cur += b.charAt(lengthB) - '0';
                lengthB--;
            }
            cur += carry;
            sb.append(cur % 10);
            carry = cur / 10;
        }

        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }


    public static void main(String... args) {
        String a = "111";
        String b = "9";
        System.out.println(twoStringMult(a, b));
    }

    public static String twoStringMult(String a, String b) {
        if (a == null) return b;
        if (b == null) return a;
        int[] product = new int[a.length() + b.length()];
        for (int i = 0 ; i < a.length() ; i++){
            for (int j = 0 ; j < b.length() ; j++){
                product[i + j + 1] += (a.charAt(i)- '0') * (b.charAt(j) - '0');
            }
        }
        int check = 0;
        for (int i = product.length -1; i >= 0 ; i--){
            int reminder = (product[i] + check) % 10;
            check =   (product[i] + check) / 10;
            product[i] = reminder;
        }
        StringBuilder sb = new StringBuilder();
        for(int num : product){
            sb.append(num);
        }
        while (sb.length() != 0 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
