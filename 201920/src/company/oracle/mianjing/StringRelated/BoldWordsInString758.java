package company.oracle.mianjing.StringRelated;

public class BoldWordsInString758 {
    public static String boldWords(String[] words , String s){
        if (s == null || words == null ||s.length() ==0 || words.length == 0) return s;

        boolean[] helper = new boolean[s.length()];

        for (String word : words){
            int start = 0;
            while((start = s.indexOf(word, start)) >= 0){
                for (int i = start ; i < start + word.length() ; i++){
                    helper[i] = true;
                }
                start++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < s.length() ; i++){
            if (helper[i] && (i == 0 || !helper[i-1])){
                sb.append("<b>");
            }
            sb.append(s.charAt(i));
            if (helper[i] &&(i == s.length() - 1 || !helper[i+1])){
                sb.append("</b>");
            }
        }
        return sb.toString();
    }
}
