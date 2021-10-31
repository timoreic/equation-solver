public class DSAStack {
  private Object[] stack;
  private int capacity;
  private int count;
  private Object topVal;

  // contructors
  public DSAStack() {
    capacity = 100;
    count = 0;
    stack = new Object[100];
  }

  public DSAStack(int maxSize) {
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

  // push
  public void push(Object value) throws Exception {
    if (this.isFull() == true) {
      throw new Exception("Stack is full");
    } else {
      stack[count] = value;
      count++;
    }
  } // End push

  // pop
  public Object pop() throws Exception {
    if (this.isEmpty() == true) {
      throw new Exception("Stack is empty");
    } else {
      try {
        topVal = this.top();
        stack[count] = null;
        count--;
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
    return topVal;
  }// End pop

  // top
  public Object top() throws Exception {
    if (this.isEmpty() == true) {
      throw new Exception("Stack is empty");
    } else {
      topVal = stack[this.getCount() - 1];
    }
    return topVal;
  } // End top
}