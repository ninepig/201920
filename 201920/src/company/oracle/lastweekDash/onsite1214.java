package company.oracle.lastweekDash;

import java.util.*;

/**
 * Created by yangw on 2020/1/5.
 * Could be IAM
 * todo reservation system
 * https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=578116&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B3%5D%3D3%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D7%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
 */
public class onsite1214 {

    public List<Integer> twoSum(int[] arr , int target){
        List<Integer> res = new ArrayList<>();
        if (arr == null || arr.length == 0){
            return res;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i < arr.length ; i++){
            if (map.containsKey(target - arr[i])){
                res.add(map.get(target-arr[i]));
                res.add(i);
            }else {
                map.put(arr[i],i);
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum(int[] arr){
        List<List<Integer>> res = new ArrayList<>();
        if (arr == null || arr.length == 0){
            return res;
        }
        Arrays.sort(arr);

        for (int i = 0 ; i < arr.length - 2; i++){
            if (i == 0 || arr[i] != arr[i-1]){
                int low = i + 1 ,  high = arr.length - 1 ;
                int target =  0 - arr[i];
                while (low < high){
                    if (target == arr[low] + arr[high]){
                        res.add(Arrays.asList(arr[low],arr[high],arr[i]));
                        while (low < high && arr[low] == arr[low+1]){
                            low++;
                        }
                        while (low < high && arr[high] == arr[high-1]){
                            high--;
                        }
                        low++;
                        high--;
                    }else if (target < arr[low] + arr[high]){
                        low++;
                    }else {
                        high--;
                    }
                }
            }
        }
        return res;
    }



    public List<List<Integer>> fourSum(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return res;
        }
        Arrays.sort(arr);
        for (int i = 0 ; i < arr.length - 3; i++){
            if (i == 0 || arr[i] != arr[i-1]){
                for (int j = i + 1  ; j < arr.length - 2 ; j++){
                    if (j == 0 || arr[j] != arr[j - 1]) {
                        int target = -arr[i] - arr[j];
                        int low = j + 1, high = arr.length - 1;
                        while (low < high) {
                            if (target == arr[low] + arr[high]) {
                                res.add(Arrays.asList(arr[low], arr[high], arr[i], arr[j]));
                                while (low < high && arr[low] == arr[low + 1]) {
                                    low++;
                                }
                                while (low < high && arr[high] == arr[high - 1]) {
                                    high--;
                                }
                                low++;
                                high--;
                            } else if (target < arr[low] + arr[high]) {
                                low++;
                            } else {
                                high--;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    public  List<List<Integer>> nSum(int[] arr , int target , int k){
        if (arr == null || arr.length == 0) return null;
        Arrays.sort(arr);
        return helper(arr, target, k, 0);
    }

    private List<List<Integer>> helper(int[] arr, int target, int k, int index) {
        List<List<Integer>> res = new ArrayList<>();
        if (index >= arr.length){
            return res;
        }
        if (k == 2 ){
            int low = index , high = arr.length - 1;
            while (low < high){
                if (arr[low] + arr[high] == target){
                    res.add(Arrays.asList(arr[low] , arr[high]));
                    while (low < high && arr[low] == arr[low + 1]) {
                        low++;
                    }
                    while (low < high && arr[high] == arr[high - 1]) {
                        high--;
                    }
                    low++;
                    high--;
                } else if (target < arr[low] + arr[high]) {
                    low++;
                } else {
                    high--;
                }
            }
        }else {
            for (int i = index ; i < arr.length - k + 1 ; i++){
                List<List<Integer>> temps = helper(arr,target - arr[i] , k - 1 , i+1);
                if (temps!=null){
                    for (List<Integer> temp : temps){
                        temp.add(arr[i]);
                    }
                    res.addAll(temps);
                }
                // Remvoe duplicated
                while (i < arr.length - 1 && arr[i] == arr[i+1]){
                    i++;
                }
            }
        }
        return res;
    }

    /*
    2. 设计restarant reservation system
     */

    public List<Integer> commonCoinsInTreeArrays(int[] arr1 , int [] arr2 , int[] arr3){
        // Judge corner case
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for (int num : arr1){
            set.add(num);
        }
        for (int num : arr2){
            if (set.contains(num)){
                set2.add(num);
            }
        }
        for (int num : arr3){
            if (set2.contains(num)){
                res.add(num);
                set2.add(num);
            }
        }
        return  res;
    }

    public int[] inplaceRemoveDuplciated(int[] arr){
        if (arr == null || arr.length == 0) return arr;
        int index = 1;
        int cur = arr[0];
        for (int i = 1 ; i < arr.length ; i++){
            if (cur != arr[i]){
                // 直接替换位新的value， 这样可以避免数组尾部的问题
                arr[index++] = arr[i];
                cur = arr[i];
            }
        }
        for (int i = index ; i < arr.length ; i++){
            arr[i] = 0;
        }
        return arr;
    }

    public int[] inplaceMergeArray(int[] arr , int[] arr2 , int[] arr3){
        // Coner case
        int index1 = arr.length - 1 , index2 = arr2.length - 1 ,index3 = arr3.length -1;
        int mergeFirstTwo = arr.length + arr2.length - 1;
        while (index1 >= 0 && index2 >= 0){
            if (arr[index1] <= arr2[index2]){
                arr[mergeFirstTwo] = arr2[index2];
                index2--;
            }else {
                arr[mergeFirstTwo] = arr[index1];
                index1--;
            }
            mergeFirstTwo--;
        }

        while (index2 >= 0){
            arr[mergeFirstTwo--] = arr2[index2--];
        }

        // Merge new with thirdOne

        int mergeThree = arr.length + arr2.length - 1 + arr3.length;
        int indexFirstTwo = arr.length + arr2.length - 1;

        while (indexFirstTwo >= 0 && index3 >= 0){
            if (arr[indexFirstTwo] <= arr3[index3]){
                arr[mergeThree] = arr3[index3];
                index3--;
            }else {
                arr[mergeThree] = arr[indexFirstTwo];
                indexFirstTwo--;
            }
            mergeThree--;
        }

        while (index3 >= 0){
            arr[mergeThree--] = arr3[index3--];
        }
        return arr;
    }
    /*
    same as first and last .
     */
    public int firstAndLastSameCoin(){
        return 0;
    }
}
