package design;

import java.util.*;

/*
380 不考虑去重 就用hashmap来做
381 考虑去重 就用 hashmap +set 来做
核心观念是把list最后一位和要删除的位互换 ，只要把最后一位设到target 位即可。 不需要换，因为直接删除最后一位。

 */
public class getRemoveRandom380 {

    Random random ;
    HashMap<Integer , Integer> map;
    ArrayList<Integer> list;

    /** Initialize your data structure here. */
    public getRemoveRandom380() {
        random = new Random();
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)){
            return false;
        }
        map.put(val,list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)){
            return false;
        }
        int location = map.get(val);
        // Set location with last element's value. Dont need to exchange!
        if (location < list.size() - 1){
            int temp = list.get(list.size() - 1);
            map.put(temp, location);
            list.set(location,temp);
        }
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return map.get(random.nextInt(list.size()));
    }

}

class RandomizedCollection {

    HashMap<Integer, Set<Integer>> locMap;
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
