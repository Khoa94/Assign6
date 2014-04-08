package problem3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.NoSuchElementException;



/**
 * A simple array-based stack.
 *
 * @author Samuel A. Rebelsky
 * @author Your Name Here
 */
public class LinkedStack<T>
    implements Stack<T>
{
  // +--------+----------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The top of the stack.
   */
  Node<T> top;

  // +--------------+----------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new stack.
   */
  public LinkedStack()
  {
    this.top = null;
  } // LinkedStack(int)

  // +-------------------------+-----------------------------------------
  // | LinearStructure Methods |
  // +-------------------------+

  @Override
  public boolean isEmpty()
  {
    return this.top == null;
  } // isEmpty()

  @Override
  public boolean isFull()
  {
    return false;
  } // isFull()

  @Override
  public T peek()
  {
    return this.top.value;
  } // peek()

  @Override
  public void put(T val)
    throws Exception
  {
    if (this.isFull())
      {
        throw new Exception("full");
      } // if full
    this.top = new Node<T>(val, this.top);
  } // put(T)

  @Override
  public T get()
    throws Exception
  {
    if (this.isEmpty())
      {
        throw new Exception("empty");
      } // if empty
    T result = this.top.value;
    this.top = this.top.next;
    return result;
  } // get()

  @Override
  public Iterator<T> iterator()
  {
    return new LinkedStackIterator<T>(this);
  } // iterator()

  // +---------------+---------------------------------------------------
  // | Stack Methods |
  // +---------------+

  @Override
  public void push(T val)
    throws Exception
  {
    this.put(val);
  } // push(T)

  @Override
  public T pop()
    throws Exception
  {
    return this.get();
  } // pop

  
  /*
   * pre: no fractions, no negative numbers
   */

  public static void RPNCalculator(String input, LinkedStack<Integer> RPNStack)
    throws NumberFormatException,
      Exception
  {
    // LinkedStack<Integer> RPNStack = new LinkedStack();
    // String input= "";
    // BufferedReader eyes = new BufferedReader(new
    // InputStreamReader(System.in));
    // System.out.println("Welcome to the Calculator! ");
    StringBuilder currentNum = new StringBuilder();
    PrintWriter pen = new PrintWriter(System.out, true);

    // input=eyes.readLine();
    int inputLength = input.length();
    for (int i = 0; i < inputLength; i++)
      {
        char currentChar = input.charAt(i);

        if (currentChar >= '0' && currentChar <= '9')
          {
            currentNum.append(input.charAt(i));
          }
        else if (currentChar == ' ')
          {
            if (currentNum.length() != 0)
              {
                RPNStack.push(Integer.parseInt(currentNum.toString()));
                // currentNum = null;
                currentNum.setLength(0);
              }
          }
        else if (currentChar == '+')
          {
            int temp1 = RPNStack.pop();
            int temp2 = RPNStack.pop();
            RPNStack.push(temp2 + temp1);
          }
        else if (currentChar == '-')
          {
            int temp1 = RPNStack.pop();
            int temp2 = RPNStack.pop();
            RPNStack.push(temp2 - temp1);
          }
        else if (currentChar == '*')
          {
            int temp1 = RPNStack.pop();
            int temp2 = RPNStack.pop();
            RPNStack.push(temp2 * temp1);
          }
        else if (currentChar == '/')
          {
            int temp1 = RPNStack.pop();
            int temp2 = RPNStack.pop();
            RPNStack.push(temp2 / temp1);
          }
        else if (currentChar == 'p')
          {
            pen.println(RPNStack.peek());
          }
        else if (currentChar == 's')
          {
            Iterator RPNIterator = RPNStack.iterator();
            pen.println("The stack is:");
            while (RPNIterator.hasNext())
              {
                pen.println(RPNIterator.next());
              }
          }
        else if (currentChar == 'c')
          {
            Iterator RPNIterator = RPNStack.iterator();
            while (RPNIterator.hasNext())
              {
                RPNIterator.next();
                RPNIterator.remove();
              }// while
            pen.println("We have cleared the Stack");
          }// else if
      }
  }//

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
    System.out.println("An Example would be like: 4 5 + 3 /");
    System.out.println("Type p to print current value, s to print the entire stack, c to clear everything");
    while (true)
      {
        input = eyes.readLine();
        RPNCalculator(input, RPNStack);
      }//while
  }// main
} // LinkedStack<T>

class LinkedStackIterator<T>
    implements Iterator<T>
{
  // +--------+----------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The next node in the iteration.
   */
  Node<T> next;

  // +--------------+----------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new iterator.
   */
  public LinkedStackIterator(LinkedStack<T> abs)
  {
    this.next = abs.top;
  } // LinkedStackIterator

  // +---------+---------------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public T next()
    throws NoSuchElementException
  {
    T result = this.next.value;
    this.next = this.next.next;
    return result;
  } // next()

  @Override
  public boolean hasNext()
  {
    return (this.next != null);
  } // hasNext9)

  @Override
  public void remove()
    throws UnsupportedOperationException
  {
    throw new UnsupportedOperationException();
  } // remove()
} // LinkedStackIterator<T>
