package facebookprepare;

/**
 * Created by yangw on 2019/6/30.
 */
public class validPalindrome2 {
    public boolean validPalindrome(String s){
        if(s==null||s.length()==0){
            return false;
        }
        for(int i = 0 ; i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i)){
                int j = s.length()-1-i;
                return (isPalindrome(s,i+1,j))||(isPalindrome(s,i,j-1));
            }
        }
        return true;
    }

    public boolean isPalindrome(String s, int i, int j){
        int start = i;
        int end = j;
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;

    }
}
