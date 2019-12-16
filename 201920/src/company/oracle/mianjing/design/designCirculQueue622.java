package company.oracle.mianjing.design;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
如果是多线程
利用lock
 */
public class designCirculQueue622 {

    int[] arr;
    int front;
    int back;
    int size;
    int capacity;
    private final Lock lock = new ReentrantLock();

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public designCirculQueue622(int k) {
        this.capacity = k;
        this.arr = new int[k];
        front = 0;
        // 关键点
        back = -1;
        size = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        lock.lock();
        try {
            if (size == capacity) return false;
            back++;
            arr[back % size] = value;
            size++;
        }finally {
            lock.unlock();
        }
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        lock.lock();
        try {
            if (size == 0) return false;
            front++;
            --size;
        }finally {
            lock.unlock();
        }
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (size == 0) return -1;
        return arr[front % arr.length];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (size == 0) return -1;
        return arr[back % arr.length];
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
