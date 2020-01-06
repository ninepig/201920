package subcategory.dfs;

/**
 * Created by yangw on 2019/7/3.
 * 贪心法 借用递归来完成的
 */
public class IntegerToEnglish {
    private final String[] belowTen = new String[] {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    private final String[] belowTwenty = new String[] {"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen"
            ,"Seventeen","EightTeen","NineTeen"};
    private final String[] belowHundred = new String[] {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy",
            "Eighty","Ninety"};

    public String numberToWords(int num) {
        if (num == 0){
            return "zero";
        }
        return dfs(num);
    }

    private String dfs(int num) {
        String res = new String();
        if (num < 10 ) res =  belowTen[num];
        else if (num < 20) res = belowTwenty[num - 10];
        else if (num < 100) res = belowHundred[num / 10] + dfs(num%10);
        else if (num < 1000) res = dfs(num/100) + "Hundred" + dfs(num % 100);
        else if (num < 1000000) res = dfs(num/1000) + "Thousand" + dfs(num % 1000);
        else if (num < 1000000000) res =  dfs(num/1000000) + "Million" + dfs(num % 1000000);
        else res = dfs(num/1000000000) + "Billion" + dfs(num % 1000000000);
        return res.trim();
    }
}
