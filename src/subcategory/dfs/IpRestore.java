package subcategory.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangw on 2019/7/2.
 */
public class IpRestore {
    public List<String> restoreIpAddresses(String s){
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        helper(res, s , 0,0,"");
        return res;
    }

    private void helper(List<String> res, String ip, int index, int dotCount, String temp) {
        if(dotCount >4) return ;
        // 不能是temp 的length 因为temp 多3个.!
        if (dotCount == 4 && index == ip.length()) res.add(temp);

        for (int i = 1 ; i < 4; i++){
            if(index + i > ip.length())break;
            String cur = ip.substring(index, index + i);
            // 筛选条件
            if((cur.startsWith("0")&& cur.length() > 1)||(i == 3 &&Integer.parseInt(cur) > 255)) continue;
            // 进入下一步
            helper(res,ip,index+i,dotCount+1,temp + cur + (dotCount == 3 ? "": "."));
        }

    }
}
