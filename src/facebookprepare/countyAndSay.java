package facebookprepare;

/**
 * Created by yangw on 2019/7/2.
 */
public class countyAndSay {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        StringBuilder pre,cur = new StringBuilder();

        cur.append("1");
        for(int i = 2 ; i <= n ; i++){
            pre = cur;
            char say = pre.charAt(0);
            int count = 1;
            cur = new StringBuilder();
            for(int j = 1 ; j < pre.length(); j++){
                if(say != pre.charAt(j)){
                    cur.append(count).append(say);
                    count = 1;
                    say = pre.charAt(j);
                }else{
                    count++;
                }
            }
            cur.append(count).append(say);
        }
        return cur.toString();
    }
}
