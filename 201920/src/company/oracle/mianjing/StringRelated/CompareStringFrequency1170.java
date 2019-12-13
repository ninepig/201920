package company.oracle.mianjing.StringRelated;

import java.util.Arrays;


public class CompareStringFrequency1170 {
    // My way ... not a good way . too slow ?
    public static int[] numSmallerByFrequency(String[] queries, String[] words) {
        if (queries == null || words == null || queries.length == 0 || words.length == 0)
            return new int[0];

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = getAnswer(queries[i], words);
        }

        return res;
    }

    private static int getAnswer(String query, String[] words) {
        int count = 0;
        int queryFrequecy = getSmallestFrency(query);
        for (String word : words) {
            if (getSmallestFrency(word) > queryFrequecy) {
                count++;
            }
        }
        return count;
    }

    private static int getSmallestFrency(String query) {
        int[] map = new int[26];
        for (char a : query.toCharArray()) {
            map[a - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (map[i] != 0) {
                return map[i];
            }
        }
        return 0;
    }



    // Using binary search to boost that.
    // get count first !
    public static int[] numSmallerByFrequency2(String[] queries, String[] words) {
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
                } else {
                    r = mid - 1;
                }
            }
            ans[i] = w.length - l;
        }
        return ans;
    }

    private static int jisuan(String str) {
        int[] arr = new int[26];
        for (char ch : str.toCharArray())
            arr[ch - 'a']++;
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0)
                return arr[i];
        }
        return 0;
    }
    // lower case? upper case?
    /*
    https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=561285&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B2%5D%3D2%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D7%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline

蠡口 奕乙鳍鳞


稍微改变了一下。输入没给数组，给了两个字符串，分别表示两个数组，数据都用分隔符隔开了，需要自己处理一下得到两个输入数组。

写完了之后让我写了两个test case run 了一下，打印出结果看看，没让用Junit

花了点时间理解题目，做题时间总+聊天接近五十分钟，没时间做别的题了，不知道过不过，等结果吧
     */
    public static int[] numSmallerByFrequency3(String queries, String words) {
        if (queries == null || queries.length() == 0 || words == null || words.length() == 0) return new int[]{};
        int[] res = new int[queries.length()];
        String[] queryList = queries.split(",");
        String[] wordList = words.split(",");
        int[] queriesFrequency = frequencyHelper(queryList);
        int[] wordsFrequency = frequencyHelper(wordList);

        // Method one . compare one by one
        // o(N^2)
//        for (int i = 0 ; i < queriesFrequency.length ; i++){
//            int count = 0;
//            for (int j = 0 ; j <wordsFrequency.length ;j++){
//                 if (queriesFrequency[i] < wordsFrequency[j]){
//                    count++;
//                }
//            }
//            res[i] = count;
//        }
        Arrays.sort(wordsFrequency);
        for (int i = 0 ; i < queriesFrequency.length ; i++) {
            int l = 0  , r = wordsFrequency.length - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (wordsFrequency[mid] <= queriesFrequency[i]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            res[i] = wordsFrequency.length - l;
        }
        return res;
    }

    private static int[] frequencyHelper(String[] queries) {
        int[] res = new int[queries.length];
        for (int i = 0 ; i < queries.length ; i++){
            res[i] = getSingleFrequncy(queries[i]);
        }
        return res;
    }

    private static int getSingleFrequncy(String query) {
        int[] map = new int[26];
        for (char c : query.toCharArray()){
            map[c - 'a']++;
        }
        for (int i = 0 ; i < 26 ; i++){
            if (map[i] != 0){
                return map[i];
            }
        }
        return 0;
    }

    public static void main(String... ars) {
//        String[] a = new String[]{"bbb", "cc"};
//        String[] b = new String[]{"a", "aa", "aaa", "aaaa"};
//        for (int c : numSmallerByFrequency3(a, b)) {
//            System.out.println(c);
//        }
    }

}