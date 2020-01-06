package subcategory.classicalproblem;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by yangw on 2019/7/3.
 */
public class meetingRoomSerial {
    private class Interval{
            int start;
            int end;
    }
    // 252 简单版本
    public boolean canAttendAllMeeting(Interval[] intervals){
        if (intervals == null || intervals.length == 0) return true;

        Arrays.sort(intervals,(a,b)->(
                a.start - b.start
                ));
//        Arrays.sort(intervals,(a,b)->(
//                a.start == b.start ? a.end - b.end : a.start -b.start
//                )
//        );
        for (int i = 1; i < intervals.length ; i++){
            if (intervals[i].start < intervals[i-1].end){
                return false;
            }
        }
        return true;
    }

    // 253 how many room version
    // 用pq 记录结束时间。 然后最后获取pq的size即可
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        Arrays.sort(intervals,(a,b)->(
                a.start - b.start
        ));

        PriorityQueue<Integer> endTime = new PriorityQueue<>();
        endTime.offer(intervals[0].end);

        for (int i = 1; i < intervals.length ; i++){
            if (endTime.peek() <= intervals[i].start){
                endTime.poll();
            }
            endTime.offer(intervals[i].end);
        }

        return endTime.size();

    }




}
