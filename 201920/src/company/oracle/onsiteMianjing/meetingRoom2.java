package company.oracle.onsiteMianjing;

import company.oracle.mianjing.array.meetingRoom252253;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class meetingRoom2 {


    public int countMeetingRoom(List<inteval> intervals) {
        if (intervals== null|| intervals.size() == 0) return 0;
        Collections.sort(intervals, new Comparator<inteval>() {
            @Override
            public int compare(inteval o1, inteval o2) {
                if (o1.begin == o2.begin){
                    return o1.end - o2.end;
                }else {
                    return  o1.begin - o2.begin;
                }
            }
        });
        PriorityQueue<inteval> q = new PriorityQueue<>((o1,o2)->
               o1.end  - o2.end );
        q.offer(intervals.get(0));
        for (int i = 1 ; i < intervals.size() ; i++){
            inteval temp = q.poll();
            if (temp.end > intervals.get(i).begin){
                q.offer(intervals.get(i));
            }else{
                temp.end = intervals.get(i).end;
            }
            q.offer(temp);
        }
        return q.size();
    }

}

class inteval{
    int begin;
    int end;
    inteval(int begin , int end){
        this.begin = begin;
        this.end = end;
    }
}