package company.oracle.mianjing.StringRelated;

import java.rmi.UnexpectedException;

/**
 * Created by yangw on 2019/12/16.
 */
public class validParethesisWithStar {
    public static boolean check(String input) throws UnexpectedException {
        int inputLen = input.length();
        if (inputLen == 0)
            return true;

        int starsCount             = 0;
        int starsAfterOpeningCount = 0;
        int parenthesisCount       = 0;

        for (int inputIndex = 0; inputIndex < inputLen; inputIndex++) {
            Character inputChar = input.charAt(inputIndex);

            if (inputChar == '(') {
                parenthesisCount++;
                starsAfterOpeningCount = 0;
            }
            else
            if (inputChar == ')') {
                if (parenthesisCount == 0) {
                    if (starsCount == 0)
                        return false;
                    else
                        starsCount--;
                }
                else
                    parenthesisCount--;
            }
            else
            if (inputChar == '*') {
                starsCount++;
                starsAfterOpeningCount++;
            }
            else
                throw(new UnexpectedException("Unexpected input"));
        }

        return (starsAfterOpeningCount - parenthesisCount) >= 0;
    }
}
