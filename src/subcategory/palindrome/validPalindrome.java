package subcategory.palindrome;

/**
 * Created by yangw on 2019/7/3.
 * 双指针，最基本palindrome
 */
public class validPalindrome {
    public boolean isPalindrome(String s) {
        if(s==null||s.length()==0){
            return true;
        }
        s = s.toLowerCase();
        int l = 0 ;
        int r = s.length()-1;
        while(l<r){
            while(l<r&&(!isAlph(s.charAt(l)))){
                l++;
            }
            while(l<r&&(!isAlph(s.charAt(r)))){
                r--;
            }
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    boolean isAlph(char a){
        return (a>='a'&&a<='z')||(a>'A'&&a<='Z')||(a>='0'&&a<='9');
    }
}
