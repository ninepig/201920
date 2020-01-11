package company.oracle.lastweekDash;

import com.sun.xml.internal.ws.addressing.WsaTubeHelperImpl;

import java.util.*;

/*
https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=566503&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B3%5D%3D3%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D7%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
 */
public class onsite1102network {
    /*
听说在地里发帖有锦鲤附体，我就来啦！大家觉得有参考价值，请加波米～
OCI networking team onsite四轮
1. bar raiser来自隔壁组，问了 merge k sorted array,看了下代码work就没问followup。 behavior question: have u ever heard critical feedback from others
2. merger interval,
followup: 如果output object有三种类型如何改output，1) enum : "can be merged" or "cannot be merged" 2) boolean 3）List after merged, 介绍完简历项目，就基于项目描述问了系统设计，microservice如何做migration,如何同步db

午饭轮 manager看起来十分忙，问了很多简历上提到的项目，有没有network, cloud service相关经验，restful api使用，如何call external service
3. longest palindrome substring, 同样基于简历项目问了系统设计，如果user 同时修改db该怎么办，batch processing优缺点

4. find kth index node in BST. 又一次问了很多简历项目细节。
总体体验 coding题目中规中矩，面试官经验丰富，喜欢深挖项目细节，技术硬核。准备下oracle LP也是有必要的。
     */
    public List<Integer> mergeSortedKarrays(List<List<Integer>> arrays){
        List<Integer> res = new ArrayList<>();
        if (arrays == null || arrays.size() == 0) return  res;
        PriorityQueue<node> pq = new PriorityQueue<>(new Comparator<node>() {
            @Override
            public int compare(node o1, node o2) {
                return o1.value - o2.value;
            }
        });

        for(int i = 0 ; i < arrays.size() ; i++){
            if (arrays.get(i)!=null){
                node temp = new node(i,0,arrays.get(i).get(0));
                pq.offer(temp);
            }
        }

        while (!pq.isEmpty()){
            node temp = pq.poll();
            res.add(temp.value);
            if (temp.y + 1 < arrays.get(temp.x).size()){
                pq.offer(new node(temp.x , temp.y + 1, temp.value));
            }
        }

        return res;
    }

    class node{
        int x;
        int y;
        int value;

        public node(int i, int i1, Integer integer) {
        }
    }
}
