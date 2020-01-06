package subcategory.array;

/**
 * Created by yangw on 2019/7/2.
 */
public class MajorElements {
    public int majorityElement(int[] num) {
        int major = num[0], count = 1;
        for ( int i = 1 ; i< num.length ;i++){
            if(count == 0){
                count++;
                major = num[i];
            }else if (major == num[i]) count++;
            else count--;
        }
        return major;
    }
}
