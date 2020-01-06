package subcategory.strings;

/**
 * Created by yangw on 2019/7/7.
 */
public class customSortString {
    /*
    排序后的T中字母x也要在y之前，其他S中未出现的字母位置无所谓。那么我们其实关心的是S中的字母，只要按S中的字母顺序遍历，对于遍历到的每个字母，
    如果T中有的话，就先排出来，这样等S中的字母遍历完了，再将T中剩下的字母加到后面即可。所以我们先用HashMap统计T中每个字母出现的次数，然后遍历S中的字母，
    只要T中有，就将该字母重复其出现次数个，加入结果res中，然后将该字母出现次数重置为0。之后再遍历一遍HashMap，将T中其他字母加入结果res中即可，参见代码如下：
     */
        public String customSortString(String S, String T) {
            int[] count = new int[26];
            for (char c : T.toCharArray()) { ++count[c - 'a']; }  // count each char in T.
            StringBuilder sb = new StringBuilder();
            for (char c : S.toCharArray()) {
                while (count[c - 'a']-- > 0) { sb.append(c); }    // sort chars both in T and S by the order of S.
            }
            for (char c = 'a'; c <= 'z'; ++c) {
                while (count[c - 'a']-- > 0) { sb.append(c); }   // group chars in T but not in S.
            }
            return sb.toString();
        }
}
