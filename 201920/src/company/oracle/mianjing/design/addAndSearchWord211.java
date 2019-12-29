package company.oracle.mianjing.design;

// prefix tree insert & search O(K) time
public class addAndSearchWord211 {

    class TrieNode{
        public TrieNode[] children = new TrieNode[26];
        public String item = "";
    }
    private  TrieNode root = new TrieNode();

    public void addWord(String word){
        TrieNode root = this.root;
        for(int i = 0;i<word.length();i++){
            if(root.children[word.charAt(i)-'a']==null){
                root.children[word.charAt(i)-'a'] = new TrieNode();
            }
            root = root.children[word.charAt(i)-'a'];
        }
        // if it is end of the word, then set the last root's item to String
        root.item = word;
    }
    public boolean search(String word){
        return match(word.toCharArray(),0,root);
    }

    private boolean match(char[] chars, int k, TrieNode root) {
        if(k==chars.length){
            //if target's length eaqul to string , we check if it is the end of word;
            return !root.item.equals("");
        }
        //using dfs to detect all the string.
        //if match is not '.',
        if(chars[k]!='.'){
            return root.children[chars[k]-'a']!=null&&match(chars,k+1,root.children[chars[k]-'a']);
        }else {
            for (int i = 0 ; i < root.children.length;i++){
                //if match is '.' just find a node exist in the childrenNode, then recursive diging it.
                if(root.children[i]!=null){
                    if(match(chars,k+1,root.children[i])){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

