package company.oracle.onsiteMianjing;

import java.rmi.UnexpectedException;

/**
 * Created by yangw on 2019/12/16.
 */
public class validParethesisWithStar {
    public  boolean check(String input) throws UnexpectedException {
       if (input == null || input.length() ==0) return false;
       int starCountBeforeLeftParethesis = 0;
       int starCountAfterLeftParethesis = 0;
       int leftParethesis = 0;
       for (int i = 0 ; i < input.length() ; i++){
           char c = input.charAt(i);
           if (c == '('){
               leftParethesis++;
               starCountBeforeLeftParethesis = 0;
           }else if (c == ')'){
               if (leftParethesis == 0){
                   if (starCountBeforeLeftParethesis == 0) return false;
                   else starCountBeforeLeftParethesis--;
               }else {
                   leftParethesis--;
               }
           }else if (c == '*'){
               starCountAfterLeftParethesis++;
               starCountBeforeLeftParethesis++;
           }else{
               throw new UnexpectedException("");
           }
       }
        return starCountAfterLeftParethesis - leftParethesis >= 0;
    }
}
