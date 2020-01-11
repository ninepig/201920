package company.oracle.mianjing.StringRelated;

import java.util.ArrayList;
import java.util.List;

public class removeComment722 {
    public List<String> removeComments(String[] source) {
            if (source == null || source.length == 0) return new ArrayList<>();
            List<String> res = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            int column = 0;
            int row = 0;
            // if /* has showed up.
            boolean comment = false;
            while (row < source.length ){
                if (comment){
                    int index = source[row].indexOf("*/",column);
                    // We dont have */ at this line
                    if (index == -1){
                        column = 0;
                        row++;
                        // it means we jump all this line, since it is all comment content.
                    }else {
                        // We found */
                        column = index + 2;
                        comment = false;
                    }
                }else {
                    int index1 = source[row].indexOf("//",column);
                    int index2 = source[row].indexOf("/*",column);
                    if (index1 == -1){
                        index1 = source[row].length();
                    }
                    if (index2 == -1){
                        index2 = source[row].length();
                    }
                    // put the not comment part in to stringbuilder.
                    for (int i = column ; i < Math.min(index1,index2);i++){
                        sb.append(source[row].charAt(i));
                    }
                    // // is infront of /*
                    if (index1 < index2){
                        if(sb.length() > 0) {
                            res.add(sb.toString());
                            sb.setLength(0);
                        }
                        row++;
                        column = 0;
                    }else {
                        comment = true;
                        column = index2 + 2;
                    }
                }
            }
            return res;
    }
}
