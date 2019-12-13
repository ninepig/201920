package company.oracle.mianjing.array;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
关键是画图！
https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=541994&extra=page%3D3%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B2%5D%3D2%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D7%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
面的是OCI 在 西雅图的组。

楼主今天一天都不在状态，而且烙印面试官还迟到了10分钟左右。

问了大约25-30分钟 简历
还剩不到半小时剩下的时间就面了一道 会议室2。

很简单的题，但是每一步面试官都会问是为了什么  还要先写pseudo code 把想法先写出来, 写成comment。

楼主脑子抽，很早之前做过的题，加上面试官一行一个问题，问的一时间有点大脑空白，只记得用priorityQueue做。后来我提出用PriorityQueue 又让把带有priorityQueue的 peseudo code写出来。因为说错了priorityQueue 的default排序方式不让继续了。。。卡到最后剩下两行没写完，应该是挂了。
 */
public class meetingRoom252253 {
    class inteval{
        int begin;
        int end;
        inteval(int begin , int end){
            this.begin = begin;
            this.end = end;
        }
    }

    public boolean canAttend(List<inteval> intervals){
        if (intervals == null || intervals.size() == 0) return false;

        Collections.sort(intervals, new Comparator<inteval>() {
            @Override
            public int compare(inteval o1, inteval o2) {
                if (o1.begin  == o2.begin){
                    return o1.end - o2.end;
                }
                return o1.begin - o2.begin;
            }
        });

        int end = intervals.get(0).end;

        for (int i = 1 ; i < intervals.size() ; i++){
            if (intervals.get(i).begin < end){
                return false;
            }else {
                end = intervals.get(i).end;
            }
        }
        return true;
    }

    public int countMeetingRoom(List<inteval> intervals){
        if (intervals == null || intervals.size() == 0) return 0;

        Collections.sort(intervals, new Comparator<inteval>() {
            @Override
            public int compare(inteval o1, inteval o2) {
                if (o1.begin  == o2.begin){
                    return o1.end - o2.end;
                }
                return o1.begin - o2.begin;
            }
        });

//        Collections.sort(intervals, (o1,o2)->{
//            if (o1.begin  == o2.begin){
//                return o1.end - o2.end;
//            }
//            return o1.begin - o2.begin;
//        });
        // 这个很关键。 画图一画就出来
        PriorityQueue<inteval> pq = new PriorityQueue<>((a,b) -> (a.end - b.end));

        pq.offer(intervals.get(0));

        for (int i = 1 ; i < intervals.size() ; i++){
            inteval temp = pq.poll();
            if (temp.end > intervals.get(i).begin){
                pq.offer(intervals.get(i));
            }else{
                temp.end = intervals.get(i).end;
            }
            pq.offer(temp);
        }
        return pq.size();
    }
}
