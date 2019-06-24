package binarysearch;

/**
 * Created by yangw on 2019/6/21.
 * lintcode 447
 * 这道题的关键是 没告诉你 最大的值得N
 * 所以你要利用target得值 去找到这个initial right index
 */
public class searchInBigSortedArray {
    /**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return : An integer which is the index of the target number
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        int index = 1;
        // Finding the edge index.
        while (reader.get(index - 1) != -1 && reader.get(index) <= target){
            index *= 2 ;
        }

        int start = 0;
        int end = index;

        while ( start + 1 < end){
            int mid = start + (end - start) / 2;
            if (reader.get(mid) >= target){
                end = mid;
            }else{
                start = mid;
            }
        }
        if(reader.get(start) == target){
            return start;
        }else if (reader.get(end) == target){
            return end;
        }
        return -1 ;
    }

    private class ArrayReader {
        // Fake Api. Gets a number by it index.
        public int get(int k){
            return k;
        }
    }
}
