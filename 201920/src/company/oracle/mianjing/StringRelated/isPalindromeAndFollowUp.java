package company.oracle.mianjing.StringRelated;

import java.util.Stack;

public class isPalindromeAndFollowUp {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return false;
        String ignoreCaseS = s.toLowerCase();
        int l = 0, r = ignoreCaseS.length() - 1;
        while (l < r) {
            while (l < r && !Character.isAlphabetic(ignoreCaseS.charAt(l))) {
                l++;
            }
            while (l < r && !Character.isAlphabetic(ignoreCaseS.charAt(r))) {
                r--;
            }
            if (ignoreCaseS.charAt(l) != ignoreCaseS.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public boolean isPlaindromeWithOutTwopointer(String a) {
        if (a == null || a.length() == 0) {
            return false;
        }
        a = a.toLowerCase();
        Stack<Character> s = new Stack<>();
        for (char c : a.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                s.push(c);
            }
        }
        for (int i = 0; i < a.length(); i++) {
            if (Character.isAlphabetic(a.charAt(i))) {
                if (s.isEmpty()) {
                    return false;
                } else {
                    if (a.charAt(i) != s.pop()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
