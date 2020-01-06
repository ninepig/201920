package company.oracle.onsiteMianjing;

import java.math.BigInteger;
import java.util.Random;

public class randomImp {
    public int random01Generator() {

        Random rand = new Random();
        return rand.nextInt(2);
    }

    // function will use the above
    // method and return numbers
    // between 0 and 6 inclusive.
    public void random06Generator(){

        Random rand = new Random();
        int val = 7;
        while (val >= 7) {

            String res = "";
            // two binary ... get the smallest 2^n bigger than target value . here is 7 , so we loop 3 times
            for (int i = 0; i < 3; i++) {
                res += String.valueOf(random01Generator());
//                System.out.println(res);
            }
            // String to int based on Base！
            BigInteger bg = new BigInteger(res,2);
            val = bg.intValue();
        }

        System.out.println(val);
    }

    // Driver Code
    public static void main(String[] args){
        randomImp r = new randomImp();
        r.random06Generator();
    }
}
