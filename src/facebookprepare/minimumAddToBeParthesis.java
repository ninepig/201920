package facebookprepare;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by yangw on 2019/7/2.
 */
public class minimumAddToBeParthesis {
    public int minAddToMakeValid(String S) {
        Deque<Character> stk = new ArrayDeque<>();
        int count = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') { stk.push(c); }
            else if (stk.isEmpty()) { ++count; }
            else { stk.pop(); }
        }
        return count + stk.size();
    }
}
