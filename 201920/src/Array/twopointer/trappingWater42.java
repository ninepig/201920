package Array.twopointer;

public class trappingWater42 {
    // 这个双指针 是需要画图理解的
    // 对于一个slot， 只需要考虑他最左侧 和最右侧 有2个bar 可以给他存水就可以了。所以不需要考虑左边或者右边，只需要有东西阻拦他即可。
    // 也就是左边最高 以及右边最高是多少即可。 那他们减去这个最高值（较小的）就是他的存水量了！
    // o(n)
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int res = 0;
        int leftMax = 0, rightMax = 0;
        int l = 0 , r = height.length - 1;
        while (l < r){
            leftMax  = Math.max(leftMax , height[l]);
            rightMax = Math.max(rightMax, height[r]);
            if (leftMax < rightMax){
                res += leftMax - height[l];
                l++;
            }else {
                res += rightMax - height[r];
                r--;
            }
        }
        return res;
    }
    // Time exceeds
    public int trapBrutalForce(int[] height) {
        if (height == null || height.length ==0) return 0;
        int res = 0;
        for ( int i = 1 ; i < height.length ; i++){
            int left = 0;
            int right = 0;
            for (int j = i  ;  j >= 0 ; i-- ){
                left = Math.max(height[j], left);
            }
            for (int k = i  ; k < height.length ; k++){
                right = Math.max(height[k] , right);
            }
            res += Math.min(left, right) - height[i];
        }
        return res;
    }
}
