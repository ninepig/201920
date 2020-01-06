package subcategory.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by yangw on 2019/7/4.
 */
public class mergeIntervals {
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() == 0) return intervals;
        List<Interval> res = new ArrayList<>();

        Collections.sort(intervals,(i1, i2)->{
            if(i1.start == i2.start){
                return i1.end - i2.end;
            }else {
                return i1.start - i2.start;
            }
        });

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for(int i = 1 ; i < intervals.size() ; i++){
            // Overlap
            if(intervals.get(i).start <= end){
                end = Math.max(intervals.get(i).end,end);
            }else{
                res.add(new Interval(start,end));
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            }
        }
        res.add(new Interval(start,end));
        return res;
    }
}
