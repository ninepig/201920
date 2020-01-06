package subcategory.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangw on 2019/7/3.
 * 复杂版本的其实也不难。关键是理解题意
 * dfs的分解的结束条件
 * 1结束条件满足两个patten以后才可以加入res
 * 2递归过程：把不满足的字符删掉以后加入下一层循环 比较复杂
 * 3递归的拆解 利用count 来传递
 */
public class removeInvalidParethesisCompleteVersion {
    char[][] patterns = {{'(', ')'}, {')', '('}};

    public List<String> removeInvalidParentheses(String s) {
        List<String> ret = new ArrayList<>();
        dfs(s, 0, 0, patterns[0], ret);
        return ret;
    }

    private void dfs(String s, int start, int lastRemove, char[] pattern, List<String> ret) {
        int count = 0, n = s.length();
        for (int i = start; i < n; i++) {
            if (s.charAt(i) == pattern[0]) {
                count++;
            }
            if (s.charAt(i) == pattern[1]) {
                count--;
            }
            if (count < 0) {
                for (int j = lastRemove; j <= i; j++) {
                    // when lastRemove is a more ( or ) and we remove duplicated.
                    if (s.charAt(j) == pattern[1] && (j == lastRemove || s.charAt(j) != s.charAt(j - 1))) {
                        dfs(s.substring(0, j) + s.substring(j + 1), i, j, pattern, ret);
                    }
                }
                return;
            }
        }
        // 对字符串进行又一次的遍历，如果字符串既不是“（”也不是“）”则跳过，否则选择要还是不要。
        // 第一个是左边（比较多的情况
        //revese下检查右侧比较多的情况
        s = new StringBuilder(s).reverse().toString();
        if (pattern[0] == patterns[0][0]) {
            dfs(s, 0, 0, patterns[1], ret);
        } else {
            ret.add(s);
        }
    }
}
