package facebookprepare;

/**
 * Created by yangw on 2019/7/2.
 */
public class StringToIntAoti {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0) return 0;

        str = str.trim();
        int signal = 0;
        int length = str.length();
        long result = 0;

        for(int i = 0 ; i < length ; i++){

            char cur = str.charAt(i);

            if(cur == '+'){
                if(i != 0 || signal != 0 ){
                    break;
                }else{

                    signal = 1;
                }
            }else if(cur == '-'){
                if(i != 0 || signal != 0 ){
                    break;
                }else{
                    signal = -1;
                }
            }else if ( cur <= '9' && cur >= '0'){
                result = result*10 + (cur-'0');
                if(result > Integer.MAX_VALUE){
                    if(signal>=0){
                        return Integer.MAX_VALUE;
                    }else{
                        return Integer.MIN_VALUE;
                    }
                }
            }else{
                break;
            }

        }

        if(signal >= 0){
            return (int) result;
        }else{
            return (int) result * -1;
        }
    }
}
