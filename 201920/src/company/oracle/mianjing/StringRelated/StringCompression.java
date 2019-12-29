package company.oracle.mianjing.StringRelated;

public class StringCompression {
    public int compress(char[] str) {
        if (str == null || str.length == 0) return 0;
        int index = 0;
        int count = 0;
        for (int i = 0; i < str.length; i++) {
            char c = str[i];
            count = 1;
            while (i + 1 < str.length && c == str[i + 1]) {
                count++;
                i++;
            }
            str[index++] = c;
            if (count != 1) {
                for (char digit : String.valueOf(count).toCharArray()) {
                    str[index++] = digit;
                }
            }
        }
        return index;
    }

    // 每次循环的时候增加count！
    // 出现不同的时候才重置count， 这样就不用循环么。
    public int compressWithoutInnerLoop(char[] str) {
        if (str == null || str.length == 0) return 0;
        int index = 0 ;
        int count = 0;
        for (int i = 0 ; i < str.length ; i++){
            count++;
            if (i == str.length - 1 || str[i] != str[i + 1]){
                str[index++] = str[i];
                if (count != 1){
                    for (char digit : String.valueOf(count).toCharArray()) {
                        str[index++] = digit;
                    }
                }
                count = 0;
            }
        }
        return index;
    }
}
