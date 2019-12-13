package company.oracle.mianjing.StringRelated;
/*
1道题：
给一个仅由26个小写字母组成的string判断是否Valid。
Valid：所有字母出现的频率一样。或者删除某个字母后，所有字母出现频率一样。
e.g:
aabbcc
aabbccddd

need ask if only one char what ?
 */
public class charCount {
    public  static  boolean validCharCount(String str){
        if (str == null || str.length() == 0){
            return false;
        }
        int[] count = new int[26];
        for (char c : str.toCharArray()){
            count[c-'a']++;
        }

        boolean flag = false;
        for (int number : count){
            System.out.println(number);
        }
        for (int i = 1 ; i < count.length ; i++){
            if (count[i] == 0){
                continue;
            }
            if (!flag){
                if (count[i] > count[i-1] ){
                    if (count[i] - count[i - 1] != 1){
                        return false;
                    }else {
                        flag = true;
                    }
                }else if (count[i] < count[i - 1]){
                    if (count[i - 1] - count[i] != 1){
                        return false;
                    }else {
                        flag = true;
                    }
                }
            }else {
                return false;
            }
        }
        return true;
    }
    public static void main(String... args){
        String a = "a";

        System.out.println(validCharCount(a));
    }
}
