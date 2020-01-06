package subcategory.strings;

/**
 * Created by yangw on 2019/7/3.
 * String的方法很巧妙
 * 把新的order mapping 回老的order
 * 利用了compare的知识点
 */
public class VerifyingAlienDict  {
    int[] mapping = new int[26];
    public boolean isAlienSorted(String[] words, String order){
        if (words==null || words.length == 0){
            return false;
        }
        // Mapping new order back to orignal one.
        for ( int i = 0 ; i < order.length() ; i++){
            mapping[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1 ; i < words.length ; i++){
            if (compare(words[i],words[i-1]) > 0){
                return false;
            }
        }
        return true;

    }

    private int compare(String word, String word1) {
        int n = word.length() , m = word1.length(), cmp = 0;
        for ( int i = 0, j = 0 ;  i < n && j < m && cmp == 0;i++,j++){
            cmp = mapping[word.charAt(i)-'a'] - mapping[word1.charAt(j) - 'a'];
        }
        return cmp == 0 ? n - m : cmp;
    }
}
