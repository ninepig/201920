package subcategory.array;

/**
 * Created by yangw on 2019/7/5.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height){
        if(height == null || height.length == 0) return 0;
        int l = 0 , r = height.length - 1;
        int max = 0;
        while(l < r){
            max = Math.max(max,Math.min(height[l],height[r]) *(r - l));
            if(height[l] < height[r]){
                l++;
            }else{
                r--;
            }

        }
        return max;
    }
}
