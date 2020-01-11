package company.oracle.lastweekDash;

/*
https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=573658&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B3%5D%3D3%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D7%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
 */
import java.util.LinkedList;
import java.util.Queue;

public class onsite1126 {
    //第一轮，国人小姐姐，口语非常好，利口而起起、而灵气。白板、walk through一下。
    // i does not know anyone else  and anyone else know i.
    // Two pass.
    public int findCelebrity(int[] arr){
        if(arr == null || arr.length == 0) return -1;
        // Brutal force
//        boolean[] helper =  new boolean[arr.length];
//        for (int i = 0 ; i < arr.length ; i++){
//            for (int j = 0; j < arr.length ;j++){
//                if ( i!=j && !know(j,i) && know(i,j)){
//                   helper[i] = false;
//                }
//            }
//        }
//        for (int i = 0 ; i < arr.length; i++){
//            if (helper[i]){
//                return i;
//            }
//        }
//        return -1;
        int candidate = 0;
        for (int i = 1 ; i < arr.length ; i++){
            if (know(candidate,i)){
                candidate = i;
            }
        }
        for (int i = 0 ; i < arr.length ;i++){
            if (candidate!=i && know(candidate,i) && !know(i,candidate)){
                return  -1;
            }
        }
        return candidate;
    }

    /*
  from candidate + 1 --- n  we dont need do know (candidate , i) again , it has been down in finding stage.
   */
    public int findWellKnowsImprove(int n ){
        if (n <= 0) return -1;
        int candidate = 0;
        // Find candidate.
        for (int i = 1 ; i <= n ;i++){
            if (know(i , i + 1)) candidate = i + 1;
        }

        // Verify
        for (int i = 1 ; i< candidate ; i++){
            if (!know(i,candidate) || know(candidate,i)){
                return -1;
            }
        }
        for (int i = candidate + 1 ; i <= n ; i++){
            if (know(candidate , i )){
                return -1;
            }
        }
        return candidate;
    }
    boolean know(int i , int j){
        return false;
    }
    // Topo logical sorting
    public boolean courseSechudle(int[][] courses, int courseNumber){
       if (courses == null || courses.length == 0) return false;
       LinkedList<Integer>[] map = new LinkedList[courses.length];
       for (int i = 0 ; i < map.length ; i++){
           map[i] = new LinkedList<>();
       }
       int[] indegree = new int[courses.length];
       for (int[] course : courses){
           // Precourse is u , v is curcourse.
           int u = course[1];
           int v = course[0];
           map[u].add(v);
           indegree[v]++;
       }
        Queue<Integer> q = new LinkedList<>();

       for (int i = 0 ; i < indegree.length ;i++){
            if (indegree[i] == 0){
                q.offer(i);
            }
       }
       int count = 0;
       while (!q.isEmpty()){
           int temp = q.poll();
           count++;
           for (int next : map[temp]){
               if (--indegree[next] == 0){
                   q.offer(next);
               }
           }
       }
       return count == courseNumber;
    }

    /*
    第三轮，穆罕默德的老板，先问了半个多小时行为面试，问有没有看乌龟壳的价值观、工作中的困难及怎样克服、为什么要来乌龟壳等等等等
    ，然后问了一个无厘头的系统设计题，怎样把二叉搜索树分布式地部署在多台机器上。我说了一个master slave的方法。

    单是储存当然可以，随便一种KV数据库都能存，简单来说二叉树就是一个(key, left_key, right_key, val)的元组，把key shard一下，就能存下了。

    他提了一个非常直接的方法，然后问我说他的方法有什么优点。我觉得他设计的不太好，但他好像很得意，我就尬夸了一下您确实设计的好。无语。
     */

    /*
    第四轮，MIT帅气白人小哥，给了一个长长的字符串和俩子串，问这俩子串出现的位置的最小距离是多少。楼主说出来算法以后，他问如果是data stream怎么办。。。写了满满一个白版。。。

ex1:
s = "abcdefaabc", s0 = "abc", s1 = "def", output: 3

子串可以重合

ex2:
s = "abcdefaabc", s0 = "abc", s1 = "bcd", output: 1
     */
    //todo 真的会。
    /*
    白人大叔工作了二十多年。问了俩行为面：职业目标是什么、解决过的最大的一个技术问题是什么。

没有问很难的算法题，而是问了一个非常简单的题，基本需求是算一个二叉树的所有结点的和。
写完以后，问觉得如果是一个library的话，开发过程中会有什么实际的问题，需要怎样处理。比如说：数值溢出啊、二叉树不合法有环啊之类的。
     */
    //真的会 ， 二叉树环 UF

}
