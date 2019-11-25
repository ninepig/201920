package company.oracle;

public class longestCommonPrefix14 {
    // 自己的做法無法控制 str[0] 長度的影響
    // 通過增加flag 來完成！
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        String first = strs[0];
        boolean ifContinue = true;
        for (int j = 0 ; j < first.length() ; j ++){
            char c = first.charAt(j);
            for (int i = 1 ; i < strs.length ; i++){
                if ( j >= strs[i].length() || strs[i].charAt(j)!= c){
                    ifContinue = false;
                    break;
                }
            }
            if (ifContinue) {
                sb.append(c);
            }else {
                break;
            }
        }
        return sb.toString();
    }


    public String longestCommonPrefixRightone(String[] strs) {
        if (strs == null || strs.length ==0)
            return "";
        int index = 0;
        StringBuilder sb = new StringBuilder();
        boolean ifTrue = true;
        while (ifTrue && index < strs[0].length()){
            for (int i = 0 ; i<strs.length ; i++){
                if (strs[i].length() <= index || strs[i].charAt(index) != strs[0].charAt(index)){
                    ifTrue = false;
                    break;
                }
            }
            if (ifTrue){
                sb.append(strs[0].charAt(index));
                index++;
            }
        }
        return sb.toString();
    }
}
