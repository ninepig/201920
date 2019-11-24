package company.oracle;

/*
一定要画图做
helper数组作用， 只有左上，左，上都是1 右下才能是新的边长（1+1） 以此类推！，helper 用来记录最大的可能的边长
 */
public class maxSuare221 {
    public int maxSqure(char[][] res){
        if (res == null || res.length == 0) return 0;
        int max = 0;
        int[][] helper = new int[res.length][res[0].length] ;
        for (int i = 1 ;  i < helper.length ; i++){
            for (int j = 1 ; j < helper[0].length ; j++){
                if (res[i-1][j-1] == '1'){
                    helper[i][j] = Math.min(helper[i-1][j-1], Math.min(helper[i][j-1], helper[i-1][j])) + 1 ;
                    max = Math.max(max, helper[i][j]);
                }
            }
        }
        return max * max;
    }
}
