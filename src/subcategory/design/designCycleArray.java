package subcategory.design;

/**
 * Created by yangw on 2019/7/6.
 */
public class designCycleArray {
    private final int[] ary;
    private int size;
    private int front;
    private int rear;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        ary = new int[k];
        size = 0;
        front = 0;
        rear = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull()) {
            return false;
        }
        front = front == 0 ? ary.length - 1 : front - 1;
        ary[front] = value;
        size++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull()) {
            return false;
        }
        ary[rear] = value;
        rear = (rear + 1) % ary.length;
        size++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty()) {
            return false;
        }
        front = (front + 1) % ary.length;
        size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty()) {
            return false;
        }
        rear = rear == 0 ? ary.length - 1 : rear - 1;
        size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(isEmpty()) {
            return -1;
        }
        return ary[front];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(isEmpty()) {
            return -1;
        }
        return ary[rear == 0 ? ary.length - 1 : rear - 1];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == ary.length;
    }
}
