package subcategory.strings;

/**
 * Created by yangw on 2019/7/3.
 * 基本题目
 * 关键是维护carry
 */
public class addBinary {
    public String addBinary(String a, String b) {
        if(a == null ) return b;
        if (b == null) return a;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = a.length()-1, j = b.length() -1 ; i >= 0 || j >= 0;){
            if (i >= 0){
                carry = a.charAt(i) - '0' + carry;
                i--;
            }
            if (j >= 0){
                carry = b.charAt(j) - '0' +carry;
                j--;
            }
            int currentD = carry % 2;
            carry = carry / 2;
            sb.insert(0,currentD + "");
        }
        if (carry == 1){
            sb.insert(0,"1");
        }
        return sb.toString();
    }
}
