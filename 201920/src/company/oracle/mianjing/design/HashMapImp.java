package company.oracle.mianjing.design;

import java.util.HashMap;

/*
https://www.zhihu.com/question/47258682

	Separate Chaining	                                                                                    Open Addressing
1.	Chaining is Simpler to implement.	                                                                    |Open Addressing requires more computation.
2.	In chaining, Hash table never fills up, we can always add more elements to chain.	                    |In open addressing, table may become full.
3.	Chaining is Less sensitive to the hash function or load factors.	                                    |Open addressing requires extra care for to avoid clustering and load factor.
4.	Chaining is mostly used when it is unknown how many and how frequently keys may be inserted or deleted.	|Open addressing is used when the frequency and number of keys is known.
5.	Cache performance of chaining is not good as keys are stored using linked list.	                        |Open addressing provides better cache performance as everything is stored in the same table.
6.	Wastage of Space (Some Parts of hash table in chaining are never used).	                                |In Open addressing, a slot can be used even if an input doesn’t map to it.
7.	Chaining uses extra space for links.	                                                                |No links in Open addressing

继续问：计算时间复杂度BigO的方法是什么，这个我真忘了，想了一下才强行想到是Amortized Time，继续问，什么是AmortizedTime。
go through line of code
caclulate the excution times of each block
a loop will  be o(n) .. a single line will be o(1)
so it will be o (n) + o(1) we get the most time using case as it's time complexity
Amoritieed , some operatio nwill take longer / some will take less.
Amortized time
An amortized time analysis gives a much better understanding of the algorithm.

Consider a sequence of n append operations, where we start with an array of length 1. A careful analysis shows that the total time of these operations is only Θ(n).
 */

public class HashMapImp {

    static class Entry<K,V> {
        final K key;
        V value;
        Entry<K, V> next;
        int hash;

        Entry(int h, K k, V v, Entry<K, V> n) {
            key = k;
            value = v;
            next = n;
            hash = h;
        }
    }

        static final int DEFUALT_INIT_CAPACITY = 1 << 4;
        static final float DEFAULT_LOAD_FACTOR = 0.75f;
        static final int MAXIMUM_CAPACITY = 1 << 30;

        /*
        Hashmap size
         */
        private int size = 0;

        float loadFactor;

        // threshold for  re-size
        int threshold;

        Entry<K,V>[] table;

        public HashMapImp(){
            this(DEFUALT_INIT_CAPACITY , DEFAULT_LOAD_FACTOR);
        }

    public HashMapImp(int defualtInitCapacity, float defaultLoadFactor) {
        if (defualtInitCapacity < 0) {
            throw new IllegalArgumentException("...");
        }
        if (defualtInitCapacity > MAXIMUM_CAPACITY) {
            defualtInitCapacity = MAXIMUM_CAPACITY;
        }

        if (defaultLoadFactor <= 0 || Float.isNaN(defaultLoadFactor)) {
            throw new IllegalArgumentException("...");
        }
        this.loadFactor = defaultLoadFactor;

        this.threshold = (int) (defualtInitCapacity * defaultLoadFactor);

        table = new Entry[defualtInitCapacity];
    }
    private void addEntry(int hash, K key, V value, int i) {
        Entry<K,V> oldEntry = table[i];
        table[i] = new Entry<>(hash, key , value , oldEntry);
        size++;
    }

    public V put (K key, V value) {
            if (key == null) {
                return putForNullKey(value);
            }
            int hash = key.hashCode();
            int i  = hash % table.length;
            for (Entry<K, V> e = table[i] ; e != null; e = e.next) {
                Object k ;
                if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
                    V oldValue = e.value;
                    e.value = value;
                    return oldValue;
                }
            }
            addEntry(hash, key, value , i);
            return null;
    }

    private V putForNullKey(V value) {
            for (Entry<K,V> entry = table[0] ; entry != null ; entry = entry.next) {
                if (entry.key == null) {
                    V oldValue = entry.value;
                    entry.value = value;
                    return oldValue;
                }
            }
            addEntry(0, null , value , 0);
            return null;
    }

    public V get(K key) {
            if (key == null) {
                return getForNullKey();
            }
            int hash = key.hashCode();
            int i = hash % table.length;
            for (Entry<K,V> e = table[i] ; e != null ; e = e.next) {
                Object k;
                if (e.hash == hash && ((k = e.key) == key || k.equals(key))) {
                    return e.value;
                }
            }
            return null;
    }

    private V getForNullKey() {
            if (size == 0) return null;
            for (Entry<K,V> e = table[0] ; e != null ; e= e.next) {
              if (e.key == null) {
                return e.value;
              }
            }
            return null;
        }

    void resize(int newCapacity) {   //传入新的容量
        Entry[] oldTable = table;    //引用扩容前的Entry数组
        int oldCapacity = oldTable.length;
        if (oldCapacity == MAXIMUM_CAPACITY) {  //扩容前的数组大小如果已经达到最大(2^30)了
            threshold = Integer.MAX_VALUE; //修改阈值为int的最大值(2^31-1)，这样以后就不会扩容了
            return;
        }

        Entry[] newTable = new Entry[newCapacity];  //初始化一个新的Entry数组
        transfer(newTable);                         //！！将数据转移到新的Entry数组里
        table = newTable;                           //HashMap的table属性引用新的Entry数组
        threshold = (int) (newCapacity * loadFactor);//修改阈值
    }


    void transfer(Entry[] newTable) {
        Entry[] src = table;                   //src引用了旧的Entry数组
        int newCapacity = newTable.length;
        for (int j = 0; j < src.length; j++) { //遍历旧的Entry数组
            Entry<K, V> e = src[j];             //取得旧Entry数组的每个元素
            if (e != null) {
                src[j] = null;//释放旧Entry数组的对象引用（for循环后，旧的Entry数组不再引用任何对象）
                do {
                    Entry<K, V> next = e.next;
                    int i = indexFor(e.hash, newCapacity); //！！重新计算每个元素在数组中的位置
                    e.next = newTable[i]; //标记[1]
                    newTable[i] = e;      //将元素放在数组上
                    e = next;             //访问下一个Entry链上的元素
                } while (e != null);
            }
        }
    }

    static int indexFor(int h, int length) {
        return h & (length - 1);
    }
    class K {
    }

     class V {
    }
}

