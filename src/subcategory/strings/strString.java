package subcategory.strings;

/**
 * Created by yangw on 2019/7/2.
 */
public class strString {
    public int strStr(String haystack, String needle) {
        if(haystack == null){
            return -1;
        }
        if(needle == null || needle.length() == 0){
            return 0;
        }
        if(haystack.length() < needle.length()){
            return -1;
        }

        int difference = haystack.length() - needle.length();
        // int index = 0;

        // Bug i < =  difference , if it is a, a
        for(int i = 0; i <= difference; i ++){
            boolean ifContain = true;
            for(int j = 0 ; j < needle.length();j++){
                if(haystack.charAt(i+j)!= needle.charAt(j)){
                    ifContain = false;
                }
            }
            if(ifContain){
                return i;
            }
        }
        return -1;
    }
}
