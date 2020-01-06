package company.oracle.onsiteMianjing;

public class kmp {
    /*
        abcxabcdabxabcdabcdabcy
        abcdabcy
     */
    public int kmp(String str, String pattern){
        if (str == null || str.length() == 0) return -1;
        if (pattern == null || pattern.length() == 0) return - 1;
        if (str.length() < pattern.length()) return -1;

        int[] helper = build(pattern);
        int i = 0, j = 0;
        while (i < str.length() && j < pattern.length() ){
            if (str.charAt(i) == pattern.charAt(j) ){
                i++;
                j++;
            }else{
                if(j != 0){
                    // Get previous index 's LPS value
                    j = helper[j-1];
                }else {
                    i++;
                }
            }
        }
        if (j == pattern.length()){
            return i;
        }
        return -1;
    }

    private int[] build(String pattern) {
        int[] helper = new int[pattern.length()];
        int index = 0;
        for (int i = 1 ; i < pattern.length();) {
            if (pattern.charAt(i) == pattern.charAt(index)) {
                helper[i] = helper[index] + 1;
                index++;
                i++;
            }else {
                if (index != 0){
                    index = helper[index - 1];
                }else {
                    helper[i] = 0;
                    i++;
                }
            }
        }
        return  helper;
    }
}
