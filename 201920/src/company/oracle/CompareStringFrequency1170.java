package company.oracle;

import java.util.Arrays;


public class CompareStringFrequency1170 {
    // My way ... not a good way . too low ?
    public static int[] numSmallerByFrequency(String[] queries, String[] words) {
        if (queries == null || words == null || queries.length == 0 || words.length == 0)
            return new int[0];

        int[] res = new int[queries.length];
        for (int i = 0 ; i < queries.length ; i++){
            res[i] = getAnswer(queries[i] , words);
        }

        return res;
    }

    private static int getAnswer(String query, String[] words) {
        int count = 0;
        int queryFrequecy = getSmallestFrency(query);
        for (String word : words){
            if (getSmallestFrency(word) > queryFrequecy){
                count++;
            }
        }
        return count;
    }

    private static int getSmallestFrency(String query) {
        int[] map = new int[26];
        for (char a : query.toCharArray()){
            map[a - 'a']++;
        }
        for (int i = 0 ; i < 26 ; i++){
            if (map[i] != 0){
                return map[i];
            }
        }
        return 0;
    }

    public static void main(String ... ars){
        String abc = "bcdb";
        System.out.println(getSmallestFrency(abc));
    }


    // Using binary search to boost that.
    // get count first !
    public int[] numSmallerByFrequency2(String[] queries, String[] words) {
        int[] q = new int[queries.length], w = new int[words.length];
        for (int i = 0; i < q.length; i++) {
            q[i] = jisuan(queries[i]);
        }
        for (int i = 0; i < w.length; i++) {
            w[i] = jisuan(words[i]);
        }
        Arrays.sort(w);
        int[] ans = new int[q.length];
        for (int i = 0; i < q.length; i++) {
            int l = 0, r = w.length - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (w[mid] <= q[i]) {
                    l = mid + 1;
                }
                else {
                    r = mid - 1;
                }
            }
            ans[i] = w.length - l;
        }
        return ans;
    }

    private int jisuan(String str) {
        int[] arr = new int[26];
        for (char ch : str.toCharArray())
            arr[ch - 'a']++;
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0)
                return arr[i];
        }
        return 0;
    }
}
