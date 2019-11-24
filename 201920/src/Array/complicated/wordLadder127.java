package Array.complicated;

import java.util.HashSet;
import java.util.List;

public class wordLadder127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dict = new HashSet<>(wordList);
        HashSet<String> reach = new HashSet<>();
        reach.add(beginWord);
        int ladder = 1;

        while (!reach.isEmpty()){
            HashSet<String> canGet = new HashSet<>();
            for (String word : reach){
                // remember this. how to get a new String
                for (int i = 0 ; i < word.toCharArray().length; i++) {
                    char[] array = word.toCharArray();
                    for (char c = 'a'  ; c <= 'z' ; c++) {
                        array[i] = c;
                        if (array.toString().equals(endWord)) {
                            return ladder;
                        }
                        if (dict.contains(array.toString())) {
                            canGet.add(array.toString());
                        }
                    }
                }
            }
            if (canGet.size() == 0) return 0;
            reach = canGet;
            ladder++;
        }
        return 0;
    }
}