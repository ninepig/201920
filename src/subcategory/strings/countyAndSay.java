package subcategory.strings;

public class countyAndSay {

    public String countAndSay(int n) {
    StringBuilder curr = new StringBuilder();
    StringBuilder pre = new StringBuilder();
    curr.append(1);

    for(int i = 2 ; i <= n ; i++){
        pre = curr;
        // Set count to 1!!
        int count = 1;
        // Key point
        char say = pre.charAt(0);
        curr = new StringBuilder();
        for(int j = 1 ; j < pre.length() ; j++){
            if(pre.charAt(j) != say){
                curr.append(count).append(say);
                count = 1;
                say = pre.charAt(j);
            }else{
                count++;
            }
        }
        curr.append(count).append(say);
    }
    return curr.toString();
}
}
