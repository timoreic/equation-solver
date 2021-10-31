public class DSACircularQueue {
  private Object[] stack;
  private Object topVal;
  private int capacity, count;
  private int front, rear = -1;

  // contructors
  public DSACircularQueue() {
    capacity = 100;
    count = 0;
    stack = new Object[100];
  }

  public DSACircularQueue(int maxSize) {
    capacity = maxSize;
    count = 0;
    stack = new Object[capacity];
  } // End Constuctors

  // get count
  public int getCount() {
    return count;
  } // End get count

  // is empty
  public boolean isEmpty() {
    boolean result;
    if (this.getCount() == 0) {
      result = true;
    } else {
      result = false;
    }
    return result;
  } // End is empty

  // is full
  public boolean isFull() {
    boolean result;
    if (this.getCount() == capacity) {
      result = true;
    } else {
      result = false;
    }
    return result;
  } // End is full

  // enqueue
  public void enqueue(Object value) throws Exception {
    if (this.isFull() == true) {
      throw new Exception("Queue is full");
    } else if (this.isEmpty() == true) {
      front = 0;
      rear = 0;
      stack[rear] = value;
      count++;
    } else {
      rear = (rear + 1) % capacity;
      stack[rear] = value;
      count++;
    }
  } // End enqueue

  // dequeue
  public Object dequeue() throws Exception {
    if (this.isEmpty() == true) {
      throw new Exception("Queue is empty");
    } else if (front == rear) {
      topVal = stack[front];
      front = -1;
      rear = -1;
      count--;
    } else {
      topVal = stack[front];
      front = (front + 1) % capacity;
      count--;
    }
    return topVal;
  }// End dequeue

  // top
  public Object top() throws Exception {
    if (this.isEmpty() == true) {
      throw new Exception("Queue is empty");
    } else {
      topVal = stack[0];
    }
    return topVal;
  } // End top

}
