package company.oracle.mianjing.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=553045&extra=page%3D2%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B2%5D%3D2%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D7%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
蠡寇舞溜变种，没问啥别的了

If it is float
float.Compare(a,b)


followup: 如果output object有三种类型如何改output，1) enum : "can be merged" or "cannot be merged" 2) boolean 3）List after merged

 直接做题刷题网舞流，follow up是如果是float怎么办，float比较的话有的时候会不准确该怎么办
float.Compare(a,b)

 */
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
