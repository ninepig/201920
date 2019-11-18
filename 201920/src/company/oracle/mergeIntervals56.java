package company.oracle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class mergeIntervals56 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0){
            return intervals;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        int start = intervals[0][0];
        int end = intervals[0][1];

        List<interval> resList = new ArrayList<>();

        for (int i = 1 ; i < intervals.length ; i++){
            if (intervals[i][0] < end){
                end = Math.max(end,intervals[i][1]);
            }else {
                resList.add(new interval(start,end));
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        resList.add(new interval(start,end));

        int[][] res = new int[resList.size()][2];

        for (int i = 0 ; i < resList.size() ; i++){
            res[i][0] = resList.get(i).start;
            res[i][1] = resList.get(i).end;
        }
        return res;
    }

    class interval{
        int start;
        int end ;
        public interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}
