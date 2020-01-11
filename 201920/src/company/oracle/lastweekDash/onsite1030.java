package company.oracle.lastweekDash;

public class onsite1030 {
    /*

1, tiny url
2. word match. char "." in a string matches everything（应该用trie吧，当时没写出来）
3. 蠡口 起舞 sort color
     */

    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        String str ;
        TrieNode(){
        }
    }

    //https://textbin.net/rrIJLdulPb
    class solution{
        TrieNode root = new TrieNode();

        public boolean checkifExit(String a , String b){
            addString(a);
            return search(b);
        }
        public void addString(String str){
            TrieNode cur = root;
            for(int i = 0 ; i < str.length() ; i++){
                char c = str.charAt(i);
                if (cur.children[c - 'a'] == null){
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c-'a'];
            }
            cur.str = str;
        }

        public boolean search(String str){
            TrieNode cur = root;
            return searchDfs(str.toCharArray(), cur ,0);
        }

        private boolean searchDfs(char[] toCharArray, TrieNode cur, int index) {
            if (index == toCharArray.length){
                return !cur.str.equals("");
            }else {
                // If it is not ? mark.
                if (toCharArray[index] != '?'){
                    return (cur.children[toCharArray[index] - 'a'] != null && searchDfs(toCharArray,cur.children[toCharArray[index] - 'a'], index+1));
                }else{
                    // if ? means any character
                    for (int i = 0 ; i < 26; i++){
                        if (cur.children[i] != null){
                            // if any one here get true;
                            if (searchDfs(toCharArray,cur.children[i] , index+1)){
                                return true;
                            }
                        }
                    }
                    // if ? means empty char , just jump to next level.
                    return searchDfs(toCharArray, cur , index+1);
                    // if ? means many char we can do like this
//                    String restQuestionMart = toCharArray.toString().substring(index);
//                    String orignal ="fale";
//                    return checkifExit(orignal.substring(orignal.length() - restQuestionMart.length()), restQuestionMart);
                }
            }
        }
    }

}
