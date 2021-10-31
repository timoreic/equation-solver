public class DSACircularQueueTest {
  public static void main(String[] args) {

    System.out.println("\n### Test Harness for DSA Circular Queue:");

    DSACircularQueue test = new DSACircularQueue();

    // Test 1: getCount
    // Expected output: 0
    System.out.println("\n# Test 1: get count");
    System.out.println("# Expected output: 0");
    System.out.print("Count: ");
    System.out.println(test.getCount());

    // Test 2: isEmpty
    // Expected output: true
    System.out.println("\n# Test 2: is empty");
    System.out.println("# Expected output: true");
    System.out.print("Is empty: ");
    System.out.println(test.isEmpty());

    // Test 3: isFull
    // Expected output: false
    System.out.println("\n# Test 3: is full");
    System.out.println("# Expected output: false");
    System.out.print("Is full: ");
    System.out.println(test.isFull());

    // Test 4: enqueue
    // Expected output (get count): 3
    System.out.println("\n# Test 4: enqueue");
    System.out.println("# Expected output (get count): 3");
    try {
      test.enqueue(1);
      System.out.println("enqueued 1");
      test.enqueue(2);
      System.out.println("enqueued 2");
      test.enqueue(3);
      System.out.println("enqueued 3");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    System.out.print("Get count: ");
    System.out.println(test.getCount());

    // Test 5: top
    // Expected output: 1
    System.out.println("\n# Test 5: top");
    System.out.println("# Expected output: 1");
    System.out.print("Top: ");
    try {
      System.out.println(test.top());
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    // Test 6: dequeue
    // Expected output (get count): 1
    System.out.println("\n# Test 6: pop");
    System.out.println("# Expected output (is empty): true");
    try {
      test.dequeue();
      System.out.println("dequeued top");
      test.dequeue();
      System.out.println("dequeued top");
      test.dequeue();
      System.out.println("dequeued top");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    System.out.print("Is Empty: ");
    System.out.println(test.isEmpty());
  }

}
