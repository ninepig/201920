package subcategory.Tree;

/**
 * Created by yangw on 2019/6/4.
 * Special data structure
 */
public class TrieTree {
        class TrieNode{
            public char val;
            public boolean isWord;
            public TrieNode[] children = new TrieNode[26];
            public TrieNode(){
            }
            public TrieNode(char c){
                TrieNode node = new TrieNode(c);
                node.val = c;
            }
        }
         TrieNode root ;

        public TrieTree(){
            root = new TrieNode();
            root.val = ' ';
        }

        public void insert(String word){
            TrieNode currentNode = root;
            for (int i = 0 ; i < word.length() ; i++){
                char c = word.charAt(i);
                if(currentNode.children[c - 'a'] == null){
                    currentNode.children[c - 'a'] = new TrieNode(c);
                }
                currentNode = currentNode.children[c - 'a'];
            }

            currentNode.isWord = true;
        }

        public boolean search(String word){
            TrieNode currentNode = root;

            for (int i = 0 ; i < word.length() ; i++){
                char current = word.charAt(i);
                if (currentNode.children[current - 'a'] == null){
                    return false;
                }
                currentNode = currentNode.children[current - 'a'];
            }
            return currentNode.isWord;
        }

        public boolean startWith(String word){

            TrieNode cur = root;
            for (int i = 0 ; i < word.length() ; i++){
                char current = word.charAt(i);
                if(cur.children[current - 'a'] == null){
                    return false;
                }
                cur = cur.children[current - 'a'];
            }
            return true;
        }
}
