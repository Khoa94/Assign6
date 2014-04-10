package problem1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularArrayBasedQueue<T>
{

  /**
   * @param args
   * 
   */

  // Fields
  T[] values; // Our array
  int front; // where we call get()
  int back; // where we call put()
  int size; // the number of elements in the array

  // Helper
  int back()
  {
    return this.size;
  } // back()

  // Constructor
  public CircularArrayBasedQueue(int capacity) throws Exception
  {
    if (capacity <= 0)
      {
        throw new Exception("Queues must have a positive capacity.");
      } // if (capacity <= 0)
    // Yay Java! It's not possible to say new T[capacity], so
    // we use this hack.
    this.values = (T[]) new Object[capacity];
    this.front = 0;
    this.back = 0;
    this.size = 0;
  } // CircularArayBasedQueue(int capacity)

  public boolean isEmpty()
  {
    return this.size <= 0;
  }// isEmpty

  public boolean isFull()
  {
    return this.size == this.values.length;
  }// isFull

  public void put(T val)
    throws Exception
  {
    if (this.isFull())
      {
        throw new Exception("The array is full. Can't add more elements");
      } // this.isFull()

    this.values[this.back] = val;
    this.back = (this.back + 1) % this.values.length;
    this.size++;
  }// put(T val)

  public T get()
    throws Exception
  {
    if (this.isEmpty())
      {
        throw new Exception("empty");
      } // if empty

    // Grab and clear the element at the front of the queue
    T result = this.values[this.front];
    this.values[this.front] = null;
    this.front = (this.front + 1) % this.values.length;
    this.size--;
    return result;
  }// get()

  public T peek()
    throws Exception
  {
    if (this.isEmpty())
      {
        throw new Exception("empty");
      } // if empty
    return this.values[this.front];
  }// peek()

  // Print every value in the array out
  public void print()
  {
    for (int i = 0; i < this.values.length; i++)
      {
        System.out.print(this.values[i] + " ");
      }// for
    System.out.println();
  }// print()

  public Iterator<T> iterator()
  {
    return new CircularIterator<T>(this);
  } // iterator()

}// class CircularArrayBasedQueue<T>

class CircularIterator<T>
    implements
      Iterator<T>
{
  // +--------+----------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The current position in the iteration.
   */
  int i;
  /**
   * The array that contains the values in the stack.
   */
  T[] values;

  // +--------------+----------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new iterator.
   */
  public CircularIterator(CircularArrayBasedQueue<T> circularArray)
  {
    this.i = -1; // when we first call next(), next() will return values[0]
    this.values = (T[]) circularArray.values;
  } // CircularIterator

  // +---------+---------------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public T next()
    throws NoSuchElementException
  {
    if (!this.hasNext())
      {
        throw new NoSuchElementException("no elements remain");
      } // if no elements
    i = ((i + 1) % values.length);
    return this.values[i];
  } // next()

  @Override
  public boolean hasNext()
  {
    int j = i;
    j = ((j + 1) % values.length);
    return this.values[j] != null;
  } // hasNext()

  @Override
  public void remove()
    throws UnsupportedOperationException
  {
    throw new UnsupportedOperationException();
  } // remove()
} // CircularIterator<T>