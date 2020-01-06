package company.oracle.lastweekDash;

/**
 * Created by yangw on 2020/1/5.
 * Object storage
 * Alot todo
 * https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=582397&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B3%5D%3D3%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D7%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
 */
public class onsite0102 {
    /*
    两道BQ，一道SystemDesign。
    BQ1犯过的错误，学到了什么。
    BQ2不记得了。
    SystemDesign tinyUrl。
     */

    /*
    两道BQ，一道算法。
    BQ1 你正在做一个project，这时候有另外一个task，怎么prioritize
    BQ2 你同事要deploy一个新system，你要oncall了，你会问你同事什么问题。
     */

    /*
    第三轮，印度小哥哥？
    简历，一道算法。
    算法， 给一个为大小为N的数组， 判断是否包含了1-N所有元素。
    给出了几乎所有我能想道的解法，不同的空间和时间复杂度。
     */
    public boolean contain(int[] arr){
        // 1 sorted arr , loop from 1 --- N
        // ---> nLogn  + o(n) no extra space

        // 2 HashSet 1---N
        // if there is one not there , bad
        // o(n) + space o(n)

        // 3 brutal force
        // n^2
        return false;
    }


    /*
    第四轮，美国大叔？
    Bar Raiser
    问了我简历。深入探讨了我现在组的system architecture，他随性问了关于数据库，LoadBalancer，Cache，metric，latency， hosts等问题。
    [\hide]
    中午吃饭，和经理，主要聊了我的家乡和美食。
     */
}
