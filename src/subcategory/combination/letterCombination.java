package subcategory.combination;

/**
 * Created by yangw on 2019/7/2.
 */
public class letterCombination {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList();
        if(digits == null || digits.length() == 0) return res;
        String[] dict = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        helper(0,new StringBuilder(),dict,digits,res);
        return res;
    }

    private void helper(int i, StringBuilder sb, String[] dict, String digits, List<String> res) {
        if(sb.length() >= digits.length()){
            res.add(sb.toString());
        }else {
            String cur = dict[Character.getNumericValue(digits.charAt(i))];
            for (char c : cur.toCharArray()){
                sb.append(c);
                helper(i+1,sb,dict,digits,res);
                sb.deleteCharAt(sb.length()-1);
            }
        }

    }
}
