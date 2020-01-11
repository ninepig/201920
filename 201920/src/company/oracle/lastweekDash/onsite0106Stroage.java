package company.oracle.lastweekDash;

import java.util.Arrays;
import java.util.HashSet;

/*
https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=582849&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B3%5D%3D3%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D7%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
Storage Group
 */
public class onsite0106Stroage {
    //刷题网 起舞
    public void sortColor(int[] arr){
        if (arr == null || arr.length == 0) return;
        int zeroCount = 0 , oneCount = 0;
        for (int i = 0 ; i < arr.length ; i++){
            if (arr[i] == 0){
                zeroCount++;
            }else if (arr[i] == 1){
                oneCount++;
            }
        }
        for (int i = 0 ; i < arr.length ; i++){
            if (i < zeroCount && i >= 0){
                arr[i] = 0;
            } else if (i >= zeroCount && i < zeroCount + oneCount){
                arr[i] = 1;
            }else {
                arr[i]= 2;
            }
        }
    }
    public void sortColorOnePass(int[] arr){
        if (arr == null || arr.length == 0) return;
        int index = 0 , p0 = 0 , p2 = arr.length - 1;
        // Key
        // 2 0 1
        while (index <= p2){
            if (arr[index] == 0){
                int temp = arr[index];
                arr[index] = arr[p0];
                arr[p0] = temp;
                index++;
                p0++;
            }else if (arr[index] == 2){
                int temp = arr[index];
                arr[index] = arr[p2];
                arr[p2] = temp;
                index--;
                p2--;
            }
            index++;
        }
    }

    // 146 LRU

    // 设计一个 failure detection，然后问service down了咋办，或者太多host了怎么办
    /*
       1 Based Heart beat
       2 Based on gossip passing

     */

    // From 1--N check if it exists in array from 1--N
    class solution {
        // ON SPACE O1 TIME
        public boolean checkIfExistsHashSet(int N , int[] arr){
            HashSet<Integer>  set = new HashSet<>();
            for (int number : arr){
                if (number > N || number <= 0){
                    return false;
                }
                set.add(number);
            }

            return  set.size() == N;
        }

        // o(NLOGN) O1 SPACE
        public boolean checkIfExistSorting(int N, int[] arr){
            Arrays.sort(arr);
            for (int i = 0 , index = 1  ; i < arr.length ; i++ , index++){
                if (arr[i]  != index) return false;
            }
            return true;
        }

        // public boolean checkIfExitNegetiveIndexWay
        public boolean checkIfExistNegtiveIndex(int N , int[] arr){
            for (int i = 0 ; i < arr.length ; i++){
                if (arr[i] > N || arr[i] < 0) return false;
                int index = Math.abs(arr[i]) - 1;
                if (arr[index] < 0){
                    return false;
                    // add to result
                }
                arr[index] = -arr[index];
            }
            return true;
        }


    }


}
