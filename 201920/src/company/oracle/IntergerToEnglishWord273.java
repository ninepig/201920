package company.oracle;

public class IntergerToEnglishWord273 {
    String[] belowHundred = new String[] {" ", "Ten" , "Twenty", "Thirty","Forty" , "Fifty", "Sixty" , "Seventy" , "Eighty",
    "Ninety"};

    String[] belowTwenty = new String[] {"ten","Eleven", "Twelve" , "Thirteen" , "Fourteen" , "Fifteen" , "Sixteen" , "Seventeen" , "Eighteen","Nineteen"};

    String[] belowTen = new String[]{" ","one", "two" , "three" , "four" , "five" ,"Six" ,"Seven" , "Eight" , "Nine"};


    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        return helper(num);
    }

    private String helper(int num) {
        String result = new String();

        if ( num < 10) result = belowTen[num];
        else if (num < 20) result = belowTwenty[num - 10];
        else if (num < 100) result = belowHundred[num / 10] + " " + belowTen[num % 10];
        else if (num < 1000) result = helper(num / 100) + " Hundred " + helper(num % 100);
        else if (num < 1000000) result = helper( num / 1000) + " Thousand " + helper(num % 1000);
        else if (num < 1000000000) result = helper(num / 1000000) + " Million " + helper(num % 1000000);
        else result = helper(num/1000000000) + " Billion " + helper(num%1000000000);

        return result.trim();
    }
}