public class CallStack {

  DSAStack callStackNested = new DSAStack();
  DSAStack callStackRecursive = new DSAStack();
  Object out;
  int gcd;

  // Nested

  // func1
  public Object func1(String a, String b) {
    String func1String = "func1: " + a + ", " + b;
    try {
      callStackNested.push(func1String);
      System.out.println(callStackNested.top());
      this.func2("c", "d");
      out = callStackNested.pop();
    } catch (Exception e1) {
      System.out.println(e1.getMessage());
    }
    return out;
  } // End func1

  // func2
  public Object func2(String c, String d) {
    String func2String = "func2: " + c + ", " + d;
    try {
      callStackNested.push(func2String);
      System.out.println(callStackNested.top());
      this.func3("e", "f");
      out = callStackNested.pop();
    } catch (Exception e2) {
      System.out.println(e2.getMessage());
    }
    return out;
  } // End func2

  // func3
  public Object func3(String e, String f) {
    String func3String = "func3: " + e + ", " + f;
    try {
      callStackNested.push(func3String);
      System.out.println(callStackNested.top());
      out = callStackNested.pop();
    } catch (Exception e3) {
      System.out.println(e3.getMessage());
    }
    return out;
  } // End func2

  // Recursive

  // greatest common denominator
  public int greatestCommonDeonominator(int num1, int num2) {
    String gcdString = "gcdString: " + Integer.toString(num1) + ", " + Integer.toString(num2);
    try {
      callStackRecursive.push(gcdString);
      System.out.println(callStackRecursive.top());
      int smaller = Math.min(num1, num2);
      int larger = Math.max(num1, num2);
      if ((larger % smaller) == 0) {
        gcd = smaller;
        callStackRecursive.pop();
      } else {
        gcd = greatestCommonDeonominator(smaller, larger % smaller);
        callStackRecursive.pop();
      }
    } catch (Exception e3) {
      System.out.println(e3.getMessage());
    }
    return gcd;
  }

  // Main
  public static void main(String[] args) {

    // Test nested
    System.out.println("\nTest nested:");
    CallStack testNested = new CallStack();
    testNested.func1("a", "b");

    // Test recursive
    System.out.println("\nTest recursive:");
    CallStack testRecursive = new CallStack();
    testRecursive.greatestCommonDeonominator(97, 33);

  }
}
