package company.oracle.onsiteMianjing;

public class sortColor {
    public void sortColor(int[] arr) {
        if (arr == null || arr.length == 0) return;
        int zeroCount = 0, oneCount = 0;
        for (int num : arr) {
            if (num == 0) zeroCount++;
            if (num == 1) oneCount++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (zeroCount > 0) {
                arr[i] = 0;
                zeroCount--;
                continue;
            }
            if (oneCount > 0) {
                oneCount--;
                arr[i] = 1;
                continue;
            }
            arr[i] = 2;
        }
        return;
    }


    public void sortColorTwoPointer(int[] arr) {
        if (arr == null || arr.length == 0) return;
        int p0 = 0 , p2 = arr.length - 1 ;
        int index = 0;
        // 2, 0, 1 就能证明 这个了！
        while (index <= p2){
            if (arr[index] == 0){
                int temp = arr[p0];
                arr[p0] = 0;
                arr[index] = temp;
                p0++;
            }else if (arr[index] == 2){
                int temp = arr[p2];
                arr[p2] = 2;
                arr[index] = temp;
                index--;
                p2--;
            }
            index++;
        }
    }
}