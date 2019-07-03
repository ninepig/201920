package facebookprepare;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by yangw on 2019/6/30.
 */
public class read4andFollowUp {
    private int readOnce(char[] buffer,int n) {
        int count = 0;
        char[] mybuf = new char[4];
        while (count<n){
            int num = read4(mybuf);
            if(num==0){
                break;
            }
            int index = 0;
            while (index<num&&count<n){
                buffer[count++] = mybuf[index++];
            }
        }
        return count;
    }

    private int read4(char[] mybuf) {
        return 0;
    }




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
//                int last = total--;
//                if(buf[last] == '\n'){
//                    break;
//                }
            }
            if(inSize == 0){
                break;
            }
        }
        return total;
    }
}
