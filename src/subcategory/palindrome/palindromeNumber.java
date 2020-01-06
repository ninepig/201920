package subcategory.palindrome;

/**
 * Created by yangw on 2019/7/7.
 */
public class palindromeNumber {

    public boolean isPalindrome(int x){
        if(x < 0){
            return false;
        }
        if(x == 0)
            return true;

        int newX = 0;
        int temp = x;
        while(temp > 0){
            newX = newX * 10 + temp % 10;
            temp = temp / 10;
        }
        return newX == x;
    }
}
