package facebookprepare;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangw on 2019/7/2.
 *我们可以更加巧妙的利用偏移字符串的特点，那就是字符串的每个字母和首字符的相对距离都是相等的，
 * 比如abc和efg互为偏移，对于abc来说，b和a的距离是1，c和a的距离是2，对于efg来说，f和e的距离是1，g和e的距离是2。
 * 再来看一个例子，az和yx，z和a的距离是25，x和y的距离也是25(直接相减是-1，这就是要加26然后取余的原因)，那么这样的话，
 * 所有互为偏移的字符串都有个unique的距离差，我们根据这个来建立映射就可以很好的进行单词分组了，这个思路真实太赞了
 */
public class groupStringShifting {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> groups = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strings) {
            String encoded = encode(s);
            if (!map.containsKey(encoded)) {
                map.put(encoded, new ArrayList<>());
            }
            map.get(encoded).add(s);
        }

        for (String key : map.keySet()) {
            groups.add(map.get(key));
        }
        return groups;
    }

    private String encode(String s) {
        if (s.length() == 1) {
            return "-1";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            sb.append((s.charAt(i) + 26 - s.charAt(i - 1)) % 26);
        }
        return sb.toString();
    }
}
