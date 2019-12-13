package company.oracle.mianjing.StringRelated;
/*
https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=569693&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B2%5D%3D2%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D7%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline


利口思思三。说下思路，写了一遍有nested while loop，问如果像工作那样交cr的话有什么comments，简单说了一下 之后优化成一个while loop，walk through了一些test cases
剩半个小时，尬聊了一会之后结束。
 */
public class stringComperssion443 {
    //Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
    public int stringCompress(char[] str){
        int indexNew = 0 , index = 0;
        while (index < str.length){
            char cur = str[index];
            int count = 0;
            while (index  < str.length  && str[index] == cur){
                index++;
                count++;
            }
            str[indexNew++] = cur;
            if (count != 1){
                for (char c : Integer.toString(count).toCharArray()){
                    str[indexNew++] = c;
                }
            }
        }
        return indexNew;
    }

    public int compress(char[] chars) {
        int start = 0;
        for(int end = 0, count = 0; end < chars.length; end++) {
            count++;
            if(end == chars.length-1 || chars[end] != chars[end + 1] ) {
                //We have found a difference or we are at the end of array
                chars[start] = chars[end]; // Update the character at start pointer
                start++;
                if(count != 1) {
                    // Copy over the character count to the array
                    char[] arr = String.valueOf(count).toCharArray();
                    for(int i=0;i<arr.length;i++, start++)
                        chars[start] = arr[i];
                }
                // Reset the counter
                count = 0;
            }
        }
        return start;
    }
}
