package subcategory.strings;

/**
 * Created by yangw on 2019/7/2.
 */
public class reveseWords {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return s;
        String[] words = s.split("\\s+");

        if(words.length == 1){
            return s.trim();
        }
        StringBuilder sb = new StringBuilder();
        for(int i = words.length - 1 ; i >= 0 ; i-- ){
            if(i!=0){
                sb.append(words[i]).append(" ");
            }else{
                sb.append(words[i]);
            }
        }
        return sb.toString().trim();
    }
}
