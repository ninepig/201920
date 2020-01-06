package subcategory.PQ;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by yangw on 2019/7/3.
 * pq nlogn + quickSelect n
 */
public class kClosetPoint {
    public int[][] kClosest(int[][] points, int K) {

        if (points == null || points.length ==0) return new int[][]{};
        PriorityQueue<int[]> pq = new PriorityQueue<>(K,(a,b)->(a[0]*a[0] + a[1]*a[1] - b[0]*b[0] - b[1]*b[1]));
        for (int[] point : points){
            pq.offer(point);
            if (pq.size() > K){
                pq.poll();
            }
        }

        int[][] res = new int[K][2];
        while (K > 0){
            res[--K] = pq.poll();
        }
        return  res;
    }

    public int[][] kClosetQS(int[][] points, int K){
        if (points == null || points.length ==0) return new int[][]{};
        int l = 0 , r = points.length - 1;
        while ( l <= r){
            // Get pivot's index.
            int mid = partition(l,r,points);
            if(mid == K)  break;
            else if (mid < K) {
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return Arrays.copyOf(points,K);
    }

    private int partition(int l, int r, int[][] points) {
        int[] pivot = points[l];
        // switch left and right based pivot , asdending
        while (l < r){
            // find first smaller element from right
            while (l < r && compare(points[r],pivot) >= 0) r--;
            points[l] = points[r];
            // find first bigger element from left
            while (l < r && compare(points[l],pivot) <= 0) l++;
            points[r] = points[l];
        }
        points[l] = pivot;
        return l;
    }

    private int compare(int[] p1, int[] p2) {
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }
}
