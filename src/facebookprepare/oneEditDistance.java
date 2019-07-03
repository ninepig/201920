package facebookprepare;

/**
 * Created by yangw on 2019/6/30.
 */
public class oneEditDistance {
//    因为只有可能是一个distance edit
//    所以我们用一个boolean 判断即可。
//    如果是have edit 过了
//    再出现一个不同就 false
//    但是要注意的是
//    有可能长度不同，也就是长度差别最多只能超过1
//
//    让较短的和较长的比较。 如果有一个char不同（比较replace），设为true，
//    如果有一个char 不同，再出现 则return false，同时如果s<t 则比较 delete/insert关系
//    o（n）
//            if same length , return false once we have two different
//if not same length, we skip one char
//            acd
//    abcd  we skip b, if one more difference , we return false

    public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null || s.equals(t) || Math.abs(s.length() - t.length()) > 1) return false;
        if (s.length() > t.length()) return isOneEditDistance(t, s);
        boolean hasDiff = false;
        for (int i = 0, j = 0; i < s.length(); i++, j++) {
            if (s.charAt(i) != t.charAt(j)) {
                if (hasDiff) return false;
                hasDiff = true;
                if (s.length() < t.length()) i--;
            }
        }

        return true;

    }



}
