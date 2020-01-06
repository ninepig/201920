package subcategory.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by yangw on 2019/7/5.
 */
public class intersectionOfTwoArraysDup {
//    sort数组 然后维护两个pointer 即可！

    public int[] intersect2(int[] nums1, int[] nums2) {
        if(nums1==null|| nums1.length==0||nums2.length==0||nums2==null){
            return new int[0];
        }

        ArrayList<Integer> result = new ArrayList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        //two pointer
        int i = 0;
        int j = 0;

        while (i<nums1.length && j<nums2.length){
            if (nums1[i]==nums2[j]){
                result.add(nums1[i]);
                i++;
                j++;
            }else if (nums1[i]<nums2[j]){
                i++;
            }else {
                j++;
            }
        }
        int[] resultInt = new int[result.size()];
        for (int k = 0 ; k< result.size();k++){
            resultInt[k] = result.get(k);
        }
        return resultInt;
    }

//    hashmap version

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        ArrayList<Integer> arr=new ArrayList<>();
        for(int num:nums1){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else{
                map.put(num,1);
            }
        }
        for(int num:nums2){
            if(map.containsKey(num)&&map.get(num)>0){
                arr.add(num);
                map.put(num,map.get(num)-1);
            }
        }
        int[] res=new int[arr.size()];
        int k=0;
        for(Integer num:arr){
            res[k++]=num;
        }
        return res;
    }
}
