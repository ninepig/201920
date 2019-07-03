package facebookprepare;

/**
 * Created by yangw on 2019/7/2.
 */
public class StringCompression {
    public int compress(char[] chars) {
        if(chars == null || chars.length == 0) return 0;

        char pre = chars[0];
        int count = 1;
        int index = 0;
        for (int i = 1 ; i < chars.length ; i++){
            if(pre != chars[i]){
                chars[index++] = pre;
                if(count > 1) {
                    chars[index++] = (char) count;
                }
                pre = chars[i];
            }else{
                count++;
            }
        }
        return index;
    }
}
