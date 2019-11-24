package company.oracle;

/*
有点类似 integerToEnglish
比较复杂 细致
贪心的思想！
 */
public class intToRoman12 {

    int[] nums = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    String[] romans = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    public String intToRoman(int num) {
        if(num <= 0) return "";
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < nums.length ; i++){
            while(num >= nums[i]){
                num -= nums[i];
                sb.append(romans[i]);
            }
        }
        return sb.toString();
    }
}
