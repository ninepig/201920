package facebookprepare;

/**
 * Created by yangw on 2019/6/29.
 */
public class addBinary {
    public String addBinary(String a, String b) {
        if (a == null || b == null) {
            return null;
        }
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; ) {
            if (i >= 0) {
                carry = a.charAt(i) - '0' + carry;
                i--;
            }
            if (j >= 0) {
                carry = b.charAt(j) - '0' + carry;
                j--;

            }
            int currentDigit = carry % 2;
            carry = carry / 2;
            sb.insert(0, "" + currentDigit);
        }

        if (carry == 1) {
            sb.insert(0, "1");
        }

        return sb.toString();
    }
}
