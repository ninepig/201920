package Array.complicated;

import java.util.ArrayList;
import java.util.List;

/*
太牛逼了 trie的方法！
 */
public class wordSearch79212 {
    public boolean exist(char[][] board, String word) {
            if(board == null || board.length == 0 || word== null || word.length()==0)
                return false;
            Boolean[][] helper = new Boolean[board.length][board[0].length];
            for (int i = 0 ; i < board.length ; i++){
                for (int j = 0 ; j < board[0].length ; j++){
                    if (helper(board,helper,word,i,j ,0))
                        return true;
                }
            }
            return false;
    }

    private boolean helper(char[][] board, Boolean[][] helper, String word, int i, int j, int index) {
        if (word.length() == index) return true;
        if (i < 0 && j < 0 && i >= board.length && j >= board[0].length && helper[i][j] != false && word.charAt(index) != board[i][j]){
            return false;
        }
        helper[i][j] = true;
        boolean res = helper(board,helper,word,i+1,j,index+1) &&
                helper(board,helper,word,i-1,j,index+1) &&
                helper(board,helper,word,i,j+1,index+1) &&
                helper(board,helper,word,i,j-1,index+1);
        helper[i][j] = false;
        return res;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);

        for (int i = 0 ; i < board.length ; i++){
            for (int j = 0 ; j < board[0].length ; j++){
                dfs(root,i,j,res,board);
            }
        }
        return res;
    }

    private void dfs(TrieNode root, int i, int j, List<String> res, char[][] board) {
        char c = board[i][j];
        if (c == '#' || root.next[c - 'a'] == null) return;
        root = root.next[c-'a'];
        if (root.word != null){
            res.add(root.word);
            // remove duplicated , so clever, but we can use a set to replace.
            root.word = null;
        }

        board[i][j] = '#';
        if (i > 0) dfs(root, i - 1, j , res, board);
        if (j > 0) dfs(root, i, j - 1, res, board);
        if (i < board.length - 1) dfs(root, i + 1, j, res, board);
        if (j < board[0].length - 1) dfs(root, i, j + 1, res, board);
        board[i][j] = c;

    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words){
            TrieNode p  = root;
            for (Character c : word.toCharArray()){
                int i = c - 'a';
                if (p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = word;
        }
        return root;
    }

    private class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}
