public class EquationSolver {

  // solve
  public double solve(String equation) {
    DSAShufflingQueue equationQueue = this.parseInfixToPostfix(equation);
    return this.evaluatePostfix(equationQueue);
  } // End solve

  // Parse infix to postfix
  private DSAShufflingQueue parseInfixToPostfix(String infix) {
    DSAShufflingQueue postfix = new DSAShufflingQueue();
    DSAStack operatorStack = new DSAStack();

    String[] infixArray = infix.split(" ");

    try {
      for (String token : infixArray) {
        char c = token.charAt(0);
        if (precedenceOf(c) > 0) {
          while (
            operatorStack.isEmpty() == false &&
            precedenceOf((char) operatorStack.top()) >= precedenceOf(c)
          ) {
            postfix.enqueue((char) operatorStack.pop());
          }
          operatorStack.push(c);
        } else if (c == ')') {
          char x = (char) operatorStack.pop();
          while (x != '(') {
            postfix.enqueue(x);
            x = (char) operatorStack.pop();
          }
        } else if (c == '(') {
          operatorStack.push(c);
        } else {
          postfix.enqueue(Double.parseDouble(token));
        }
      }
      for (int i = 0; i <= operatorStack.getCount(); i++) {
        postfix.enqueue((char) operatorStack.pop());
      }
    } catch (Exception e) {
      System.out.println("parseInfixToPostfix Error: " + e.getMessage());
    }

    return postfix;
  } // End parse infix to postfix

  // evaluate postfix
  private double evaluatePostfix(DSAShufflingQueue postfixQueue) {
    DSAStack operandStack = new DSAStack();
    double result = 0;

    try {
      while (postfixQueue.getCount() >= 1) {
        if (postfixQueue.top() instanceof Double) {
          operandStack.push((double) postfixQueue.top());
          postfixQueue.dequeue();
        } else {
          double temp2 = (double) operandStack.top();
          operandStack.pop();
          double temp1 = (double) operandStack.top();
          operandStack.pop();
          char operator = (char) postfixQueue.top();
          postfixQueue.dequeue();
          operandStack.push(
            (double) this.executeOperation(operator, temp1, temp2)
          );
        }
      }
      result = (double) operandStack.top();
    } catch (Exception e) {
      System.out.println("evaluatePostfix Error: " + e.getMessage());
    }
    return result;
  } // End evaluate postfix

  // precedence of
  private int precedenceOf(char theOp) {
    int out = 0;
    if ((theOp == '+') || (theOp == '-')) {
      out = 1;
    } else if ((theOp == '*') || (theOp == '/')) {
      out = 2;
    } else if (theOp == '^') {
      out = 3;
    }
    return out;
  } // End precedence of

  // execute operation
  private double executeOperation(char op, double op1, double op2) {
    double result = 0;
    if (op == '+') {
      result = op1 + op2;
    } else if (op == '-') {
      result = op1 - op2;
    } else if (op == '*') {
      result = op1 * op2;
    } else if (op == '/') {
      result = op1 / op2;
    } else {
      result = Math.pow(op2, op1);
    }
    return result;
  } // End execute operation

  // Main
  public static void main(String[] args) {
    EquationSolver test = new EquationSolver();

    System.out.println("\n### Test Equation Solver");

    // Test equation solver
    try {
      System.out.println(
        "\nInfix: ( 10.3 * ( 14 + 3.2 ) ) / ( 5 + 2 - 4 * 3 )"
      );

      // Test parse infix to postfix
      // Expected output: 10.3 14.0 3.2 + * 5.0 2.0 + 4.0 3.0 * - /
      System.out.println(
        "Postfix: " +
        test.parseInfixToPostfix("( 10.3 * ( 14 + 3.2 ) ) / ( 5 + 2 - 4 * 3 )")
      );

      // Test solve
      // Expected output: -35.432
      System.out.println(
        "Result: " + test.solve("( 10.3 * ( 14 + 3.2 ) ) / ( 5 + 2 - 4 * 3 )")
      );
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  } // End main
}
