package Math;

/*
不用 abs的方法才是对的。 abs可能直接就报错了！
 */
public class reverseInteger007 {
    public int reverse(int x){
        int res  = 0 ;
        while (x != 0){
            int reminder = x % 10;
            int newRes = res * 10 + reminder;
            // Overflow
            if ((newRes - reminder)/10  != res) return 0;
            res = newRes;
            x /= 10;
        }
        return res;
    }
}
