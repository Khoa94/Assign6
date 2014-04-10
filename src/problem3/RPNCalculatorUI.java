package problem3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RPNCalculatorUI
{

  public static void main(String[] args)
      throws NumberFormatException,
        Exception
    {
      String input = "";
      LinkedStack<Integer> RPNStack = new LinkedStack();
      BufferedReader eyes = new BufferedReader(new InputStreamReader(System.in));
      System.out.println("Welcome to the RPN Calculator");
      System.out.println("It rounds down to the nearest whole integer");
      System.out.println("Put a space in between each val you enter");
      System.out.println("The number of integers needs to be 1 more than the number of operations");
      System.out.println("Only non-negative integers allowed");
      System.out.println("An Example would be like:4 5 + 3 /");
      System.out.println("Type p to print current value, s to print the entire stack, c to clear everything");
      while (true)
        {
          input = eyes.readLine();
          LinkedStack.RPNCalculator(input, RPNStack);
        }// while
    }// main
}//class RPNCalculatorUI

/*
 * Experiment1
4 5 + 3 /
p
3
r
Three 505435 +
p
505438
543 -
p
504895
r
Five Zero Four Eight Nine Five 
c
We have cleared the Stack
p
There's nothing on the stack

 * Experiment2
678 500 -
p
178
1
2
3
4
p
4
+
p
7
s
The stack is:
7
2
1
178
*
p
14
s
The stack is:
14
1
178

*/