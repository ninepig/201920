package company.oracle.onsiteMianjing;

public class splitAssemebldString {
    public String splitLoopedString(String[] str){
//        if (str == null || str.length == 0) return "";
        // get the biggest string first (reverse or not)
        for (int i = 0 ; i < str.length ; i++){
            String rev = new StringBuilder(str[i]).reverse().toString();
            if (str[i].compareTo(rev) < 0){
                str[i] = rev;
            }
        }

        // Test all posibility to get the largest one.
        String res = "";
        for (int i = 0 ; i < str.length ; i++){
            String rev = new StringBuilder(str[i]).reverse().toString();
            for (String st : new String[]{rev, str[i]}){
                for (int k = 0 ; k < st.length() ; i++){
                    StringBuilder sb = new StringBuilder(st.substring(k));
                    for (int j = i + 1 ; j < str.length ; j++){
                        sb.append(str[j]);
                    }
                    for (int l = 0 ; l < i ; l++){
                        sb.append(str[l]);
                    }
                    sb.append(st.substring(0,k));
                    if (res.compareTo(sb.toString())<0){
                        res = sb.toString();
                    }
                }
            }
        }
        return res;
    }
}
