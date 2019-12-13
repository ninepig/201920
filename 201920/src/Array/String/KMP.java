package Array.String;

/*
https://www.youtube.com/watch?v=GTJr8OvyEVQ
https://github.com/mission-peace/interview/blob/master/src/com/interview/string/SubstringSearch.java

2. 有两个string，找出首尾最多重叠多少？我说可以暴力，问要不要code。同胞说能不能效率高点？我假装想了一会说可以用KMP。问能不能写出code，我说一时可能写不出，就讲了讲思路。同胞表示满意。

 */
public class KMP {
    //O(m*n)
    public static int searchBrutal(String text, String pattern) {
        int N = text.length();
        int M = pattern.length();
        for (int i = 0; i < N-M; i++) {
            int j;
            for (j = 0; j < M; j++) {
                if (text.charAt(i+j) != pattern.charAt(j))
                    break;
            }
            if (j == M) return i;
        }

        return -1;
    }

    private int[] computePrefixArray(char pattern[]){
        int[] lps = new int[pattern.length];
        int index = 0;
        for (int i = 1 ; i < pattern.length;){
            if (pattern[i] == pattern[index]){
                lps[i] = index + 1;
                index++;
                i++;
            }else {
                if (index != 0){
                    index = lps[index - 1];
                }else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public boolean kmp(char[] text , char[] pattern){
        int[] lps = computePrefixArray(pattern);
        int i = 0 ;
        int j = 0;
        while (i < text.length && j < pattern.length){
            if (text[i] == pattern[j]){
                i++;
                j++;
            }else {
                if (j != 0){
                    j = lps[j - 1];
                }else {
                    i++;
                }
            }
        }
        if (j == pattern.length ){
            return  true;
        }
        return false;
    }
    public static void main(String args[]){

        String str = "abcxabcdabcdabcy";
        String subString = "abcdabcy";
        KMP ss = new KMP();
        boolean result = ss.kmp(str.toCharArray(), subString.toCharArray());
        System.out.print(result);

    }
}
