package company.oracle.onsiteMianjing;

import java.util.TreeMap;

/*
 给定range求key
第四问就是 比如 给定 （10, 20), "A" 那么 对于给定value 15应该返回A
可以假定就是三个元素，一个给定范围，一个给定value。
第二轮 亚裔小姐姐
实现一个rangeMap 实现以下操作：
public void put(int start, int end, String value){
// return if [start, end] collides with an eixisting range

}

public String get(int key){

}

例如

put(1,10, "foo");
get(5); // return "foo"

put(15,25,"bar");

get(20);// return "bar"

put(9,14,"foo2") // do nothing since [9,14] collides with [1,10]

和小姐姐讨论了很久，最后她说要用binary search tree 来实现

 */
public class rangeToKey {

    // If has overlap condition?
    // if not. treemap
    public static int getValue(Range[] ranges , int targetKey){
        if (ranges == null || ranges.length == 0) return -1;
        TreeMap<Integer , Integer> treeMap = new TreeMap<>();
        for (Range range : ranges){
            treeMap.put(range.begin,range.value);
            treeMap.put(range.end,range.value);
        }
        int floorValue = treeMap.get(treeMap.floorKey(targetKey));
        int ceilValue = treeMap.get(treeMap.ceilingKey(targetKey));
        return floorValue == ceilValue ? floorValue : -1;
    }

    public  static  void main(String ... args){
        Range a = new Range(1,5,3);
        Range b = new Range(6,8,5);
        Range c = new Range(9,12,4);
        Range[] test = new Range[]{a,b,c};
        System.out.println(getValue(test,10));
    }
}

class Range{
    int begin;
    int end;
    int value;
    public  Range(int begin, int end, int value){
        this.begin = begin;
        this.end = end;
        this.value = value;
    }
}