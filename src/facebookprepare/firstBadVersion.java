package facebookprepare;

/**
 * Created by yangw on 2019/6/21.
 * Leetcode 278
 * 二分法
 * logN
 */
public class firstBadVersion {


    private boolean isBadVersion(int version){
        return true;
    }

    public int firstBadVersion(int number) throws Exception {
        if (number <= 0){
            throw new Exception();
        }
        int start = 1 , end = number;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if(isBadVersion(mid)){
                end = mid;
                }else{
                start = mid;
            }
        }
        if(isBadVersion(start)){
            return start;
        }else{
            return end;
        }
    }

}

