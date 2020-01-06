package subcategory.strings;

import java.util.HashSet;

/**
 * Created by yangw on 2019/7/5.
 * 感觉就是基本操作，仔细小心即可。
 */
public class toGoatLatin {
    private HashSet<Character> set = new HashSet<Character>() {{
        add('A');
        add('E');
        add('I');
        add('O');
        add('U');
    }};   //initialization is a litte complex.

    public String toGoatLatin(String S) {
        String strs[] = S.split("\\s+"); // split with regex
        int n = strs.length;
        StringBuffer resSB = new StringBuffer();
        for(int i = 0; i < n; i++) {
            if(set.contains(Character.toUpperCase(strs[i].charAt(0))) == false) {
                strs[i] = strs[i].substring(1) + strs[i].charAt(0);
            }
            strs[i] += "ma" + copyA(i+1);
            resSB.append(strs[i]);
            if(i != n - 1) {
                resSB.append(" ");
            }
        }
        return resSB.toString();
    }


    private String copyA(int times) {// copy a for times times
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < times; i++) {
            sb.append('a');
        }
        return sb.toString();
    }
}
