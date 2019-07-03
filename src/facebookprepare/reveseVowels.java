package facebookprepare;

/**
 * Created by yangw on 2019/7/2.
 */
public class reveseVowels {
    public String reverseVowels(String s) {
        //uppercase lowercase
        if(s==null||s.length()==0){
            return "";
        }
        char[] stringArray = s.toCharArray();
        int l = 0;
        int r = s.length()-1;


        while(l<r){
            while(!ifVowels(stringArray[l])&&l<r){
                l++;
            }
            while(!ifVowels(stringArray[r])&&l<r){
                r--;
            }
            if(l<r){
                char temp = stringArray[l];
                stringArray[l]=stringArray[r];
                stringArray[r]= temp;
            }
            l++;
            r--;
        }

        return new String(stringArray);

    }

    public boolean ifVowels(char a){
        return a=='a'||a=='e'||a=='o'||a=='u'||a=='i'||a=='A'||a=='E'||a=='O'||a=='U'||a=='I';
    }
}
