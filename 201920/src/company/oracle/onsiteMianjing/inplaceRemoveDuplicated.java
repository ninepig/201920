package company.oracle.onsiteMianjing;

public class inplaceRemoveDuplicated {
    public void removeDuplicated(int[] arr){
        if (arr == null || arr.length == 0) return ;

        int index = 0;
        for (int i = 1 ; i < arr.length ; i++){
            if (arr[i] != arr[i-1]){
                arr[index] = arr[i-1];
                index++;
            }
        }

        for (int i = index ; i < arr.length ; i++){
            arr[i] = 0;
        }
        return;
    }
}
