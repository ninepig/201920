package facebookprepare;

/**
 * Created by yangw on 2019/7/2.
 */
public class MissingRange {



    public List<String> findMissingRanges(int[] A, int lower, int upper) {

        if(A==null) return null;
        List<String> res = new ArrayList<String>();
        for(int i=0; i<A.length; i++) {
            while(i<A.length && A[i] == lower ) {lower++; i++;}
            if(i>=A.length) break;
            if(A[i] == lower+1) {
                res.add(String.valueOf(lower));
            } else {
                res.add("" + lower + "->" + (A[i]-1) );
            }
            lower = A[i] + 1;
        }

        if(lower == upper) {
            res.add(String.valueOf(lower));
        } else if(lower < upper ){
            res.add("" + lower + "->" + upper );
        }
        return res;
    }



}
