package facebookprepare;

/**
 * Created by yangw on 2019/7/1.
 */
public class romanToINT {
    public int romanToInt(String s) {
        if( s == null || s.length() == 0){
            return 0;
        }
        int result = 0 ;
        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            switch (c){
                case 'I':
                    if( i < s.length()-1 && (s.charAt(i+1) == 'V'||s.charAt(i+1) == 'X'))
                        result -= 1;
                    else
                        result += 1 ;
                    break;
                case 'V':
                    result += 5;
                    break;
                case 'X':
                    if(i < s.length()-1 && (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C'))
                        result -= 10;
                    else
                        result += 10;
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'C':
                    if(i < s.length()-1 && (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M'))
                        result -= 100;
                    else
                        result += 100;
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'M':
                    result += 1000;
                    break;
            }
        }
        return result;
    }
}
