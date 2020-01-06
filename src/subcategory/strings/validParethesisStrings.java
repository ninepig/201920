package subcategory.strings;

/**
 * Created by yangw on 2019/7/6.
 */
public class validParethesisStrings {
    // Two pass
//    Think this might be logically easiest solution for this problem.
//    Check from left to right and then check from right to left.
//    When check from left to right, take all '*'s as '(', to see whether can match all ')'s.
//            And, When check from right to left, take all '*'s as ')', to see whether can match all '('s.
//    If both checks are valid, then the string is valid.
//    p.s. Thanks to @vagnihotri1117, we can return true if the first check returns bal=0.

    public boolean checkValidString(String s) {
        int bal = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '*') bal++;
            else if (bal-- == 0) return false;
        }
        if (bal == 0) return true;
        bal = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == ')' || s.charAt(i) == '*') bal++;
            else if (bal-- == 0) return false;
        }
        return true;
    }

    // One pass
//    It's quite straight forward actually.
//    When you met "(", you know you need one only one ")", cmin = 1 and cmax = 1.
//    When you met "(*(", you know you need one/two/three ")", cmin = 1 and cmax = 3.
//
//    The string is valid for 2 condition:
//
//    cmax will never be negative.
//    cmin is 0 at the end.
    public boolean checkValidString2(String s) {
        int cmin = 0, cmax = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                cmax++;
                cmin++;
            } else if (c == ')') {
                cmax--;
                cmin = Math.max(cmin - 1, 0);
            } else {
                cmax++;
                cmin = Math.max(cmin - 1, 0);
            }
            if (cmax < 0) return false;
        }
        return cmin == 0;
    }
}
