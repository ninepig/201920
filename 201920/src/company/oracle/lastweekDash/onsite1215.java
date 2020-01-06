package company.oracle.lastweekDash;

import tree.TreeNode;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by yangw on 2020/1/5.
 * https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=578230&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B3%5D%3D3%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D7%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
 */
public class onsite1215 {
    int res = 0;
    public int diameterOfBt(TreeNode root){
        if (root == null) return 0;
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null) return  0;
        int left =helper(root.left);
        int right = helper(root.right);
        res = Math.max(res, left+right);
        return Math.max(left,right) + 1;
    }


    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) return  res;
        HashMap<String , Integer> counter = new HashMap<>();
        for (String word : words){
            counter.put(word, counter.getOrDefault(word,0) + 1);
        }
        // Priority queue method
//        PriorityQueue<String> q = new PriorityQueue<>(new Comparator<String>() {
//            @Override
//            public int compare(String s1, String s2) {
//                if (counter.get(s1) == counter.get(s2)){
//                    return s2.compareTo(s1);
//                }else {
//                    return counter.get(s1) - counter.get(s2);
//                }
//            }
//        });
//
//        for (String key : counter.keySet()){
//            if (q.size() > k ){
//                q.poll();
//            }
//            q.offer(key);
//        }
//
//        while (!q.isEmpty()){
//            res.add(q.poll());
//        }
//
//        return res;
        ArrayList<String>[] buckets = new ArrayList[words.length] ;
        for (String key : counter.keySet()){
            if (buckets[counter.get(key)] == null){
                buckets[counter.get(key)] = new ArrayList<>();
            }
            buckets[counter.get(key)].add(key);
        }

        for (int i = buckets.length - 1 ; i >= 0 ; i++){
            if (buckets[i] != null) {
                if (res.size() <= k) {
                    // if size doest not match , add it one by one.
                    res.addAll(buckets[i]);
                }
            }
        }

        return res;
    }

    // TODO need understanding this
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return  res;
         HashMap<TreeNode, List<TreeNode>> map = new HashMap<>();
         buildMap(map , root, null);
         if (!map.containsKey(target)) return res;
         Queue<TreeNode> q = new LinkedList<>();
         HashSet<TreeNode> set = new HashSet<>();
         q.offer(target);
         set.add(target);
         int k = K;
        while (!q.isEmpty()){
            int size = q.size();
            if (k == 0){
                for (int i = 0 ; i < size ; i++ ){
                    res.add(q.poll().val);
                }
                return res;
            }
            for (int i = 0 ; i < size ; i++){
                TreeNode temp = q.poll();
                for (TreeNode next : map.get(temp)){
                    if (!set.contains(next)){
                        set.add(next);
                        q.offer(next);
                    }
                }
            }
            k--;
        }
        return res;
    }

    private void buildMap(HashMap<TreeNode, List<TreeNode>> map, TreeNode root, TreeNode parent) {
        if (root == null) return;
        if (!map.containsKey(root)){
            map.put(root , new ArrayList<>());
            if (parent != null){
                map.get(parent).add(root);
                map.get(root).add(parent);
            }
            buildMap(map,root.left,root);
            buildMap(map,root.right,root);
        }
    }
}
