package subcategory.array;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by yangw on 2019/7/3.
 */
public class read4OnceAndMul {
//1 文件可能比N大，最多读N个
//2 文件可能比N小，最多读文件的char个数
    private int readOnce(char[] buffer,int n) {
        int count = 0;
        char[] mybuf = new char[4];
        while (count<n){
            int num = read4(mybuf);
            if(num==0){
                break;
            }
            int index = 0;
            // 读至多N个，如果读不到那么多，那至多count数量
            while (index<num&&count<n){
                buffer[count++] = mybuf[index++];
            }
        }
        return count;
    }

    private int read4(char[] mybuf) {
        return 0;
    }

    private int readOnce2(char[] buff , int n){
        int count = 0;
        char[] mybuf = new char[4];
        while (count < n){
            int num = read4(mybuf);
            if (num == 0) break;
            int index = 0;
            while (index < num && count < n){
                buff[count++] = mybuf[index++];
            }
        }
        return count;
    }

// READ 可以读多次，所以每次read读多了 要存起来
    Queue<Character> buff = new ArrayDeque<>();
    public int read(char[] buf, int n) {
        int total = 0;
        while (true){
            //use temp char to store read4 result
            char[] temp = new char[4];
            int number = read4(temp);
            for (int i = 0 ; i <number;i++){
                buff.offer(temp[i]);
            }
            // 判断还需要写入多少个到结果， 比如读了4个，但是只要3个；或者要4个，只有3个了
            int inSize = Math.min(n-total,buff.size());
            for (int i = 0 ; i<inSize;i++){
                buf[total++] = buff.poll();
            }
            if(inSize == 0){
                break;
            }
        }
        return total;
    }
}
