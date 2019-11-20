package Array.twopointer;

public class containerWithMostWater11 {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) return  0;
        int curHeight = 0;
        int result = 0;
        int l = 0 , r = height.length - 1;
        while (l < r){
            curHeight = Math.min( height [l] , height [r]);
            result = Math.max(result , curHeight * (r - l));
            if (height[l] < height[r]){
                l++;
            }else {
                r--;
            }
        }
        return result;
    }
}
