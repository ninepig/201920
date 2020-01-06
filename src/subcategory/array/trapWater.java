package subcategory.array;

/**
 * Created by yangw on 2019/7/5.
 */
public class trapWater {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int sum = 0;
        int leftMax = 0 , rightMax = 0;
        while(l < r){
            leftMax = Math.max(leftMax,height[l]);
            rightMax = Math.max(rightMax, height[r]);
            if(leftMax < rightMax){
                sum += leftMax - height[l];
                l++;
            }else{
                sum += rightMax - height[r];
                r--;
            }
        }
        return sum;
    }

    public int trapBrutal(int[] height) {
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
