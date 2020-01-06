package company.oracle.mianjing.StringRelated;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DnaString {
    public List<String> findRepeatedDnaSequences(String s) {


        Map<String, Integer> map = new HashMap<>();
        // 要用<= 因为subString 是exclusive的
        for (int i = 10; i <= s.length(); ++i) {
            String sub = s.substring(i - 10, i);
            map.put(sub, map.getOrDefault(sub, 0) + 1);
        }
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                res.add(entry.getKey());
            }
        }
        return res;
    }
}
