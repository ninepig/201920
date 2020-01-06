package facebookprepare;

/**
 * Created by yangw on 2019/7/4.
 */
public class addAndSearch {
    // Trie
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        String word = "";
    }

    private TrieNode root = new TrieNode();

    public void addWord(String string){
        TrieNode root = this.root;
        for(int i = 0 ; i< string.length() ; i++){
            char cur = string.charAt(i);
            if (root.children[cur - 'a'] == null){
                root.children[cur - 'a'] = new TrieNode();
            }
            root = root.children[cur-'a'];
        }
        root.word = string;
    }

    public boolean search(String word){

        return match(word.toCharArray(),0,root);

    }

    private boolean match(char[] chars, int k, TrieNode root) {
            if ( k == chars.length){
                return !root.word.equals("");
            }

            if (chars[k]!='.'){
                return root.children[chars[k]-'a'] != null &&match(chars,k+1,root.children[chars[k]-'a']);
            }else{
                for (int i = 0 ; i< root.children.length ;i++){
                    if (root.children[i]!= null){
                        if (match(chars,k+1,root.children[i])){
                            return true;
                        }
                    }
                }
            }
            return false;
    }

}
