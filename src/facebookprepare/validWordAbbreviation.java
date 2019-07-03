package facebookprepare;

/**
 * Created by yangw on 2019/7/1.
 * 每次先判断两个字符串当前位置是否相等，如果相等都＋１，否则缩写字符串肯定应该是数字，
 * 然后找出这个数字多少就把word的位置右移多少．在找出扎个数字的时候还要先判断是否有先导０
 * ，如果有的话就不符合．最后把word位置右移之后还要判断移动之后的位置字符是否相等，也就是说如果移动之后的位置如果不相等肯定也为ｆａｌｓｅ．

 */
public class validWordAbbreviation {
    public boolean validWordAbbreviation(String word , String abbr){
        // edge case
        if (word == null || word.length() ==0 || abbr == null || abbr.length() ==0) return false;
        if (abbr.length() > word.length()) return  false;
        int k = 0, i = 0 , len1 = word.length(), len2 = abbr.length();

        while (i < len2){
            // move to the first number
            if (word.charAt(k) == abbr.charAt(i)){
                i++;
                k++;
                continue;
            }
            // Get how many number to offset
            int count = 0;
            if (abbr.charAt(i) == '0') return false;
            while (Character.isDigit(abbr.charAt(i))){
                count = count * 10 + abbr.charAt(i) - '0';
                i++;
            }
            // move to the rest
            k += count;
            if (k > len1 || word.charAt(k) != abbr.charAt(i)) return false;
        }
        return k == len1;
    }
}
