package facebookprepare;

/**
 * Created by yangw on 2019/7/2.
 */
public class longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {

        if(strs == null || strs.length == 0){
        return "";
    }
    StringBuilder sb = new StringBuilder();
    int index = 0;
    boolean ifTrue = true;
        while (ifTrue){
        for(int i = 0 ; i < strs.length ; i++){
            if(strs[i].length()<=index||strs[i].charAt(index)!=strs[0].charAt(index)){
                ifTrue = false;
                break;
            }
        }
        if(ifTrue){
            sb.append(strs[0].charAt(index));
            index++;
        }
    }
        return sb.toString();
}
}
