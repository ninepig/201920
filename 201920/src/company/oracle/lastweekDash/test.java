package company.oracle.lastweekDash;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by yangw on 2020/1/4.
 */
public class test {

    public static void main(String ... args){
        regularExpression a = new regularExpression();
//        String c = "aa";
//        String b = "aa?";
//        System.out.println(a.isMatch(c,b));
        int[] b = new int[]{1,2,2,2,3,4};
        for (int number :a.inplaceRemoveDuplciated(b)){
            System.out.println(number);
        }
     }
}
class reverseIntervalMap {

    TreeMap<Integer, Integer> map = new TreeMap<>();

    public int get(int key) {

        Map.Entry<Integer, Integer> leftBond = map.floorEntry(key);
        Map.Entry<Integer, Integer> rightBond = map.ceilingEntry(key);

        if (leftBond == null) {
            return -1;
        }
        if (rightBond == null) {
            return -1;
        }

        if (leftBond.getValue() != rightBond.getValue()) {
            return -1;
        }

        return leftBond.getValue();

    }


    public boolean put(int beginKey, int endKey, int val) {

        Map.Entry<Integer, Integer> leftLowerBond = map.floorEntry(beginKey);
        Map.Entry<Integer, Integer> rightLowerBond = map.ceilingEntry(beginKey);
        Map.Entry<Integer, Integer> leftHigherBond = map.floorEntry(endKey);
        Map.Entry<Integer, Integer> rightHigherBond = map.ceilingEntry(endKey);

        // Occupied
        if (rightLowerBond != null) {
            if (rightLowerBond.getKey() < endKey) {
                return false;

            }
        }
        // Occupied
        if (leftHigherBond != null) {

            if (leftHigherBond.getKey() > beginKey) {
                return false;
            }
        }

        if (leftLowerBond != null && rightHigherBond != null) {
            if (leftLowerBond.getValue() == rightHigherBond.getValue()) {
                return false;
            }
        }
        map.put(beginKey, val);
        map.put(endKey, val);
        return true;
    }
}

class regularExpression{
    // P could have ? mask , ? can be any char or empty
    public boolean isMatch(String s , String p ){
        if (s == null || p == null) return false;
        if (s.length() > p.length()) {
            return false;
        }

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1 ; i < dp.length ;i++){
            for (int j = 1 ; j < dp[0].length ; j++){
                if (s.charAt(i-1) == p.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                if (p.charAt(i-1) == '?' ){
                    // One char or No char
//                    dp[i][j] = dp[i-1][j-1] || dp[i][j];
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[s.length()][p.length()];
    }


    public int[] inplaceRemoveDuplciated(int[] arr){
        // Corner case
        if (arr == null || arr.length == 0) return arr;
        int index = 1;
        int cur = arr[0];
        for (int i = 1 ; i < arr.length ; i++){
            if (cur != arr[i]){
                arr[index++] = arr[i];
                cur = arr[i];
            }
        }
        for (int i = index ; i < arr.length ; i++){
            arr[i] = 0;
        }
        return arr;
    }
}