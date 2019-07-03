package facebookprepare;

/**
 * Created by yangw on 2019/6/30.
 */
public class trappingWater {
    public int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }

        int res = 0;

        for(int i = 1 ; i < height.length - 1 ; i++){
            int maxLeft = 0 , maxRight = 0;
            for(int j = i ; j >= 0 ; j--){
                maxLeft = Math.max(maxLeft, height[j]);
            }
            for(int k = i ; k < height.length ; k++){
                maxRight = Math.max(maxRight, height[k]);
            }
            res += Math.min(maxLeft, maxRight) - height[i];
        }

        return res;
    }
}
