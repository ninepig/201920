package subcategory.strings;

/**
 * Created by yangw on 2019/7/7.
 */
public class CompressString {
    public int compress(char[] chars) {
        if(chars == null || chars.length == 0) return 0;
        int indexAns = 0, index = 0;
        while(index < chars.length){
            char currentChar = chars[index];
            int count = 0;
            while(index < chars.length && chars[index] == currentChar){
                index++;
                count++;
            }
            chars[indexAns++] = currentChar;
            if(count != 1)
                for(char c : Integer.toString(count).toCharArray())
                    chars[indexAns++] = c;
        }
        return indexAns;
    }
}
