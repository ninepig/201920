package facebookprepare;

/**
 * Created by yangw on 2019/7/2.
 */
public class zigZag {
    public String convert(String s , int nRows){
        char[] c = s.toCharArray();
        int len = s.length();
        StringBuilder[] sb = new StringBuilder[nRows];
        for (int i = 0 ; i < nRows ; i++){
            sb[i] = new StringBuilder();
        }
        int i = 0;
        while(i < len){
            // Vertical down
            for (int index = 0 ; index < nRows && i < len ; index++ ){
                sb[index].append(c[i++]);
            }
            // Obliquely up
            for (int index = nRows - 2; index >= 1 && i < len ; index-- ){
                sb[index].append(c[i++]);
            }
        }
        for (int index = 1 ; index < sb.length ; index++){
            sb[0].append(sb[index]);
        }
        return sb[0].toString();
    }
}

