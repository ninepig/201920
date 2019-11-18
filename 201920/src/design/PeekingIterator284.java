package design;

import java.util.Iterator;

/*
利用了iterator的特性
我们先保存一个next ，如果真的call next（）的时候再把这个next替换掉即可。
也就是说提前做了一次next()。 然后peek 这个next值即可。
 */
public class PeekingIterator284 {

    Integer next;
    Iterator<Integer> iter;
    public PeekingIterator284(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iter  = iterator;
        if (iterator.hasNext()){
            next = iterator.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    public Integer next() {
        Integer res = next;
        next = iter.hasNext() ? iter.next() : null;
        return res;
    }

    public boolean hasNext() {
        return iter.hasNext();
    }
}
