package company.oracle.onsiteMianjing;

import java.util.TreeMap;

/*
 给定range求key
第四问就是 比如 给定 （10, 20), "A" 那么 对于给定value 15应该返回A
可以假定就是三个元素，一个给定范围，一个给定value。
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