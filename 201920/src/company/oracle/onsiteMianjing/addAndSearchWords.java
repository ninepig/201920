package company.oracle.onsiteMianjing;

import company.oracle.WordLadder126;

public class addAndSearchWords {

    TrieNode root;
    public addAndSearchWords(){
        root = new TrieNode();
    }

    public void add(String word){
        TrieNode cur = root;
        for (int i = 0 ; i < word.length() ; i ++){
            char temp = word.charAt(i);
            if (cur.children[temp - 'a'] == null){
                cur.children[temp- 'a'] = new TrieNode();
            }
            cur = cur.children[temp - 'a'];
        }
        cur.word = word;
    }

    public boolean searchWord(String word){
        return helper(word.toCharArray(), 0 ,root);
    }

    private boolean helper(char[] wordArray, int index, TrieNode root) {
        if (index == wordArray.length){
            // Not equal to empty.
            return !root.word.equals("");
        }else {
            // when it is not . , find current level is valid and recursive do that.
            if (wordArray[index] != '.'){
                return root.children[wordArray[index] - 'a'] != null
                        && helper(wordArray,index+1,root.children[wordArray[index] - 'a']);
            }else {
                // do 26 times to find a valid one.
                for (int i = 0 ; i < root.children.length ; i++){
                    if (root.children[i] != null){
                        if (helper(wordArray,index+1, root.children[i]))
                            return true;
                    }
                }
            }
        }
        return false;
    }
}

class TrieNode{
    TrieNode root;
    TrieNode[] children = new TrieNode[26];
    String word;
}