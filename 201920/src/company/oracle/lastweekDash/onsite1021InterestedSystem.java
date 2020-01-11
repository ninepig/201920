package company.oracle.lastweekDash;

import java.util.ArrayList;
import java.util.List;

/*
https://www.1point3acres.com/bbs/thread-562256-1-1.html
system design detail in discuss
 */
public class onsite1021InterestedSystem {
    /*
    第一轮国人小哥哥, 灰常Nice。面试时脸离白板太近了，有些小bug看不过来，直晃脑袋，小哥哥每次都友好提醒。题目是LC 其实就。Follow up是而异尔，只说了想法，分析时间复杂度。BQ一个。
    第二轮白人大叔，有点严肃但也很友好。给个大文件里一堆string，一个一行，再给个target string，问有多少个string的末尾是以target string结束的。比如【apple， maple， lemon】和 target=ple，就返回2。Follow up如果文件很大string很多怎么办。 BQ两个。
    中午和HM吃饭，闲聊。
    第三轮，白人小哥哥，相当严肃，但是好像也很好相处，只是不爱笑。深度问项目，后系统设计能接受不同类型的扑克游戏，再问问怎么分布式，work flow，后又让写2小算法，洗牌，和，5张牌判断3张牌数字一样。BQ两三个。
    就是不限制扑克牌游戏规则 什么都能玩 可以假设你有个game engine 其实就是希望面试的人不要把重点放在设计游戏规则上

    第四轮，白人大叔，黑人小哥。纯BQ，聊的不错，挺平易近人的，一点都不aggressive。
     */

    public boolean wordSearch(char[][] board, String word){
        if (board == null || board.length == 0) return false;
        boolean[][] helper = new boolean[board.length][board[0].length];
        for (int i = 0 ; i < board.length ; i++){
            for (int j = 0 ; j < board[0].length; j++){
                if (dfs(board, i , j , word,0 , helper)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int index, boolean[][] helper) {
        if (index == word.length()){
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j>= board[0].length || word.charAt(index) != board[i][j] || !helper[i][j] ){
            return false;
        }
        helper[i][j] = true;
        boolean res =  dfs(board,i+1,j,word,index,helper)||
        dfs(board,i-1,j,word,index,helper)||
                dfs(board,i,j+1,word,index,helper)
                || dfs(board,i, j-1 , word,index,helper);
        helper[i][j] = false;
        return res;
    }



    public List<String> wordSearchII(char[][] board, String[] strs){
        // coner case
        TrieNode root = buildTrieTree( strs);
        List<String> res = new ArrayList<>();

        for (int i = 0 ; i < board.length; i++){
            for (int j = 0 ; j < board[0].length ; j++){
                dfs2(board, i , j , root,res);
            }
        }
        return res;
    }

    private void dfs2(char[][] board, int i, int j, TrieNode root, List<String> res) {
       char c = board[i][j];
       if (c == '#' || root.children[c-'a']==null) return;
       root = root.children[c-'a'];
       if (root.word != null){
           res.add(root.word);
           // Remove duplcated.
           root.word = null;
       }
       // Set a flag to avoid duplicated visit
       board[i][j] = '#';
       if (i > 0 ||  j > 0 || i + 1 < board.length || j + 1< board[0].length ){
           dfs2(board, i+1 , j , root,res);
           dfs2(board,i-1, j, root,res);
           dfs2(board,i, j+1, root,res);
           dfs2(board,i, j-1 ,root,res);
       }
       board[i][j] = c;
    }

    private TrieNode buildTrieTree( String[] strs) {
        // trie tree build
        TrieNode root = new TrieNode();
        for (String w : strs) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.children[i] == null) p.children[i] = new TrieNode();
                p = p.children[i];
            }
            p.word = w;
        }
        return root;
    }

    private class TrieNode{
        TrieNode[] children = new TrieNode[26];
        String word;
    }


}
