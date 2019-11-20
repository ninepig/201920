package company.oracle;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
关键是画图！
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
