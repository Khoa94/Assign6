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
 * @author Victoria Tsou
 * @author Khoa Nguyen
 */
public class LinkedStack<T>
    implements
      Stack<T>
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
  } // pop()

  /*
   * pre: only non-negative integers, there's 1 space between numbers and between operations.
   */

  public static void RPNCalculator(String input, LinkedStack<Integer> RPNStack)
    throws NumberFormatException,
      Exception
  {
    StringBuilder currentNum = new StringBuilder();
    PrintWriter pen = new PrintWriter(System.out, true);

    int inputLength = input.length();

    // read through input and push numbers onto the stack. If see operation
    // signs, we perform the operations
    for (int i = 0; i < inputLength; i++)
      {
        char currentChar = input.charAt(i);

        if (currentChar >= '0' && currentChar <= '9')
          {
            currentNum.append(input.charAt(i));
            if (i == inputLength - 1)
              {
                RPNStack.push(Integer.parseInt(currentNum.toString()));
                currentNum.setLength(0);
              }// if
          }// if currentChar is a digit

        else if ((currentChar == ' ' && currentNum.length() != 0))
          {
            RPNStack.push(Integer.parseInt(currentNum.toString()));
            currentNum.setLength(0);
          }// else if

        else if (!RPNStack.isEmpty())
          {
            // operations
            if (currentChar == '+')
              {
                int temp1 = RPNStack.pop();
                int temp2 = RPNStack.pop();
                RPNStack.push(temp2 + temp1);
              }// if
            else if (currentChar == '-')
              {
                int temp1 = RPNStack.pop();
                int temp2 = RPNStack.pop();
                RPNStack.push(temp2 - temp1);
              }// esle if
            else if (currentChar == '*')
              {
                int temp1 = RPNStack.pop();
                int temp2 = RPNStack.pop();
                RPNStack.push(temp2 * temp1);
              }// else if
            else if (currentChar == '/')
              {
                int temp1 = RPNStack.pop();
                int temp2 = RPNStack.pop();
                RPNStack.push(temp2 / temp1);
              }// else if
            else if (currentChar == 'p')
              {
                pen.println(RPNStack.peek());
              }// else if
            else if (currentChar == 's')
              {
                Iterator RPNIterator = RPNStack.iterator();
                pen.println("The stack is:");
                while (RPNIterator.hasNext())
                  {
                    pen.println(RPNIterator.next());
                  }// while
              }// else if
            else if (currentChar == 'c')
              {
                while (!RPNStack.isEmpty())
                  {
                    RPNStack.pop();
                  }// while not empty, keep deleting
                pen.println("We have cleared the Stack");
              }// else if
            else if (currentChar == 'r') // spell out the top element of the
                                         // stack
              {
                String toSpell = (RPNStack.peek().toString());
                for (int j = 0; j < toSpell.length(); j++)
                  {
                    char numToConvertToWord = toSpell.charAt(j);
                      {
                        switch (numToConvertToWord)
                          {
                            case '0':
                              System.out.print("Zero ");
                              break;
                            case '1':
                              System.out.print("One ");
                              break;
                            case '2':
                              System.out.print("Two ");
                              break;
                            case '3':
                              System.out.print("Three ");
                              break;
                            case '4':
                              System.out.print("Four ");
                              break;
                            case '5':
                              System.out.print("Five ");
                              break;
                            case '6':
                              System.out.print("Six ");
                              break;
                            case '7':
                              System.out.print("Seven ");
                              break;
                            case '8':
                              System.out.print("Eight ");
                              break;
                            case '9':
                              System.out.print("Nine ");
                              break;
                          }// switch
                      }// numToConvertToWord
                  }// if number has more than one digit
              }// else if currentChar=='r'
          }// outer else if

        else if (RPNStack.isEmpty())
          {
            pen.println("There's nothing on the stack");
          }// else if
      }// for
  }// RPNCalculator
} // LinkedStack<T>

class LinkedStackIterator<T>
    implements
      Iterator<T>
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
  } // hasNext()

  @Override
  public void remove()
    throws UnsupportedOperationException
  {
    throw new UnsupportedOperationException();
  } // remove()
} // LinkedStackIterator<T>
