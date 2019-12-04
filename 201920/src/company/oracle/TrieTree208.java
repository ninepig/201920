package company.oracle;

public class TrieTree208 {
    TrieNode root ;
    /** Initialize your data structure here. */
    public TrieTree208() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0 ; i < word.length() ; i++){
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null){
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c-'a'];
        }
        cur.str = word;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0 ; i < word.length() ; i++){
            char c = word.charAt(i);
            if (cur.children[c- 'a'] == null) return false;
            cur = cur.children[c-'a'];
        }
        return word.equals(cur.str);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode ws = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(ws.children[c - 'a'] == null) return false;
            ws = ws.children[c - 'a'];
        }
        return true;
    }

    class TrieNode{
        TrieNode[] children ;
        String str;
        public TrieNode(){}
    }

}
