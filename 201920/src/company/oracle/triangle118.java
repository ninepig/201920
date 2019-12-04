package company.oracle;

import LinkedList.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class triangle118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows < 1){
            return res;
        }
        res.add(Arrays.asList(1));
        if (numRows == 1){
            return res;
        }
        res.add(Arrays.asList(1,1));
        List<Integer> cur = Arrays.asList(1,1);
        List<Integer> pre = null;
        for (int i = 3 ; i < numRows ; i++){
            pre = cur;
            cur = new ArrayList<>();
            cur.add(1);
            for (int j = 0; j < pre.size() - 1 ; j++){
                cur.add(pre.get(j) + pre.get(j+1));
            }
            cur.add(1);
            res.add(cur);
        }

        return res;
    }
}
