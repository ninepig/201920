package subcategory.array;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangw on 2019/7/4.
 */
public class intervalListIntersections {
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0){
            return new Interval[]{};
        }
        int m = A.length , n =B.length;
        int i = 0 , j = 0;
        List<Interval>  res = new ArrayList<>();
        while (i < m && j < n){
            Interval a = A[i];
            Interval b = B[j];

            int startMax = Math.max(a.start, b.start);
            int endMin = Math.min(a.end,b.end);

            if(endMin >= startMax){
                res.add(new Interval(startMax,endMin));
            }

            if(a.end == endMin) i++;
            if (b.end == endMin) j++;
        }
        return res.toArray(new Interval[0]);
    }
}
