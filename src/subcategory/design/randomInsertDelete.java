package subcategory.design;

import java.util.*;

/**
 * Created by yangw on 2019/7/7.
 */
public class randomInsertDelete {

    HashMap<Integer,Integer> helperMap ;
    ArrayList<Integer> helperList;
    Random random;
    /** Initialize your data structure here. */
    public randomInsertDelete() {
        helperMap = new HashMap<>();
        helperList = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(helperMap.containsKey(val)){
            return false;
        }
        // val + lastIndex of array
        helperMap.put(val,helperList.size());
        helperList.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    // put the target val to the end of array. then remove it
    public boolean remove(int val) {
        if(!helperMap.containsKey(val)){
            return false;
        }
        // 用最后一个位置的value,代替要删除的值，同时更新map
        int location = helperMap.get(val);
        if(location < helperList.size()-1) {
            // Last one's value
            int lastValue = helperList.get(helperList.size() - 1);
            helperList.set(location,lastValue);
            helperMap.put(lastValue,location);
        }
        helperList.remove(helperList.size()-1);
        helperMap.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        // 返回 0---n 之间的某个数
        return helperList.get(random.nextInt(helperList.size()));
    }


//381 duplicated 难啊
    class RandomizedCollection {

        HashMap<Integer,Set<Integer>> locMap;
        ArrayList<Integer> nums;
        Random random;

        /** Initialize your data structure here. */
        public RandomizedCollection() {
            locMap = new HashMap<>();
            nums = new ArrayList<>();
            random = new Random();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(!locMap.containsKey(val)){
                locMap.put(val,new HashSet<>());
            }
            locMap.get(val).add(nums.size());
            nums.add(val);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if(!locMap.containsKey(val)){
                return false;
            }
            //get the location of val
            int location = locMap.get(val).iterator().next();
            //remove this location in set
            locMap.get(val).remove(location);

            if(location<nums.size()-1){
                //if val is not the last one,replace the targetone with lastOne,and change the location in map
                int lastOne = nums.get(nums.size()-1);
                nums.set(location,lastOne);
                //remove the orignal postion,add the new location
                locMap.get(lastOne).remove(nums.size()-1);
                locMap.get(lastOne).add(location);
            }
            nums.remove(nums.size()-1);
            if(locMap.get(val).isEmpty()){
                locMap.remove(val);
            }
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return nums.get(random.nextInt(nums.size()));
        }
    }
}
