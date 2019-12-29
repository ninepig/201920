package company.oracle.mianjing.design;

/*
5.环形缓存，有点像刷题网陆儿儿，只不过自己定义数据结构。这轮是个大牛，follow up问的多而深，讨论到多线程，写操作对系统的影响，还有个问题关于conditional variable的，我是完全没听说过
Ringbuffer is designed to some operation for one producer and one consumer.
ringbuffer write opertion can save space for some opertion for system， like log handling , can save memeory for lock , don't need assign lock to some thread.
Condition variables are synchronization primitives that enable threads to wait until a particular condition occurs. Condition variables are user-mode objects
that cannot be shared across processes. Condition variables enable threads to atomically release a lock and enter the sleeping state


关键是明白 用数组 和2根指针来做
写指针
读指针
写指针往后走
读指针往后走（删除操作，这样覆盖）

 */
public class ringbuffer622 {

    int size ;
    int front;
    int end;
    int capacity;
    int[] array ;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public ringbuffer622(int k) {
        this.capacity = k;
        this.front = 0;
        this.end = -1;
        this.size = 0;
        this.array = new int[k];
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (size == capacity) return false;
        end++;
        array[end%capacity] = value;
        size++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    // 读指针往后移 说明再也没有机会访问之前的节点了， 所以形成了删除操作！
    public boolean deQueue() {
        if (size == 0) return false;
        front++;
        size--;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (size == 0) return -1;
        return array[front % capacity];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (size == 0) return -1;
        return array[end % capacity];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
    return size == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
    return size == capacity;
    }

}
