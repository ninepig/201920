package company.oracle.todo;
/*
http://liadbiz.github.io/leetcode-single-number-problems-summary/
 */
public class singleNumberTodo {

    public static int singleNumber(int[] nums) {
        int x1 = 0;
        int x2 = 0;
        int x3  = 0;
        int mask = 0;

        for (int i : nums) {
            x3 ^= x2 & x1 & i;
            x2 ^= x1 & i;
            x1 ^= i;
            mask = ~(x1 & ~x2 & x3);
            x3 &= mask;
            x2 &= mask;
            x1 &= mask;
        }

        return x1;
    }

    public static void main(String...args){
      int[] arr = new int[] {1,1,1,2,2,2,2,1,2,1,3,3};
      System.out.println(singleNumber(arr));
    }
}
