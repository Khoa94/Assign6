package problem2;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.NoSuchElementException;

import problem2.ArrayBasedStack.parensPositions;

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

  static class ParensPositions
  {
    char current;
    int index;

    public ParensPositions(char inputCurrent, int inputIndex)
    {
      this.current = inputCurrent;
      this.index = inputIndex;
    }// parensPositions constructor
  }// parensPositions class
  
  public static String printMatching (String str)
      throws Exception
      {
        ArrayBasedStack<ParensPositions> parenStack = new ArrayBasedStack(str.length());
        int i = 0;
        
        PrintWriter pen = new PrintWriter(System.out, true);
        
        while (i < str.length())
          {
            char currentChar = str.charAt(i);
            if (currentChar=='(' || currentChar=='[' || currentChar=='{'  || currentChar=='<' || currentChar=='\'')
              {
                ParensPositions currentPair = new ParensPositions(currentChar, i);
                parenStack.push(currentPair);
              }// if
            
            else {
              switch (currentChar)
              {
                case ')':
                  if ((char) parenStack.peek().current == '(')
                    {
                      parenStack.pop();
                    }// if
                  
          
              }
            
            
            
            
            
            
            }
          }

        
      }
  
  
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
