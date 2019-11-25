package Array.complicated;

import java.util.ArrayList;
import java.util.List;

public class insertInterval57 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        int i = 0;
        int n = intervals.size();
        int newStart = newInterval.start;
        int newEnd = newInterval.end;

        while(i < n && intervals.get(i).end < newInterval.start){
            res.add(intervals.get(i));
            i++;
        }
        // Border Case. Till the last one.
        if(i == n){
            res.add(newInterval);
            // If it is last one , return res.
            return res;
        }
        // Found new Start value.
        newStart = Math.min(newStart, intervals.get(i).start);

        // Found new End value.
        while(i < n && intervals.get(i).start <= newInterval.end){
            newEnd = Math.max(newInterval.end,intervals.get(i).end);
            i++;
        }
        res.add(new Interval(newStart,newEnd));

        while(i<n){
            res.add(intervals.get(i++));
        }

        return res;

    }

    class Interval {
        int start;
        int end;
        Interval(int begin, int end){
            this.start  = begin;
            this.end = end;
        }
    }
}
