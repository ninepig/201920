package company.oracle.onsiteMianjing;

public class NextPermutation {
    public void findNextPermutation(int[] arr){
        //314254
        // first: first decreasing number from end
        // second: find first number bigger than target from the end
        // third swap two numbers
        // reverse from first found number 's next position.
        if (arr == null || arr.length <= 1) return;
        int index = arr.length - 2;

        // find first index
        while (index >= 0 && arr[index] > arr[index + 1]){
            index--;
        }
        int firstNumber = arr[index];

        // minor bug. if index <= 0 , just reverse everything !
        if(index >= 0) {
            int indexSec = arr.length - 1;
            // find sec index
            while (indexSec >= 0 && arr[indexSec] <= firstNumber) {
                indexSec--;
            }

            // switch
            int temp = arr[indexSec];
            arr[indexSec] = arr[index];
            arr[index] = temp;
        }
        // Reverse
        reverse(arr, index + 1);
    }

    private void reverse(int[] arr, int i) {
        int last = arr.length - 1;
        while ( i < last){
            int temp = arr[last];
            arr[last] = arr[i];
            arr[i] = temp;
            last--;
            i++;
        }
    }
}
