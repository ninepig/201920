package company.oracle.mianjing.dp;

import java.util.ArrayList;
import java.util.HashMap;

public class wordBreak {
    public boolean wordBreak(ArrayList<String> dict , String str){
        if (str == null || str.length() == 0 || dict == null) return false;
        boolean[] helper = new boolean[str.length() + 1];
        helper[0] = true;
        // helper[j] = subString(i,j) && helper[i]
        for (int i = 1 ; i < helper.length ; i++ ){
            for (int j = 0 ; j < i ; i++){
                if (helper[j] && dict.contains(str.substring(j,i))){
                    helper[i] = true;
                    break;
                }
            }
        }
        return helper[str.length()];
    }
}
