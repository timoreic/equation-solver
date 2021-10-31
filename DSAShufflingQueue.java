public class DSAShufflingQueue {
  private Object[] stack;
  private int capacity;
  private int count;
  private Object topVal;

  // contructors
  public DSAShufflingQueue() {
    capacity = 100;
    count = 0;
    stack = new Object[100];
  }

  public DSAShufflingQueue(int maxSize) {
    capacity = maxSize;
    count = 0;
    stack = new Object[capacity];
  } // End Constuctors

  // to string
  @Override
  public String toString() {
    String output = "";
    for (Object item : stack) {
      if (item != null) {
        output = output + item.toString() + " ";
      }
    }
    return output;
  } // End to string

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
    } else {
      stack[count] = value;
      count++;
    }
  } // End enqueue

  // dequeue
  public Object dequeue() throws Exception {
    if (this.isEmpty() == true) {
      throw new Exception("Queue is empty");
    } else {
      try {

        for (int i = 0; i < stack.length - 1; i++) {
          stack[i] = stack[i + 1];
        }
        count--;
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
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
