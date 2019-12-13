package company.oracle.mianjing.dfs;

import java.util.ArrayList;
import java.util.List;
/*
need using StringBuilder ！
Time complexity : (3^N * 4^M)
where N is the number of digits in the input that maps to 3 letters (e.g. 2, 3, 4, 5, 6, 8) and M is the number of digits in the input that maps to 4 letters

 */
public class letterCombination17NeedTime {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList<>();
        String[] map = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> res = new ArrayList<>();
        helper(map,res,new StringBuilder(),digits,0);
        return res;
    }

    private void helper(String[] map, List<String> res, StringBuilder s, String digits,int pos) {
        if (s.length() == digits.length()){
            res.add(s.toString());
            return;
        }else{
            String str = map[Character.getNumericValue(digits.charAt(pos))];
            for (char c : str.toCharArray()){
                s.append(c);
                helper(map,res,s,digits,pos+1);
                s.deleteCharAt(s.length() - 1);
            }
        }
    }
}
