package problem1;

import java.util.Iterator;

import taojava.util.Queue;

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
  }//isEmpty

  public boolean isFull()
  {
    return this.size == this.values.length;
  }//isFull

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
  }//put(T val)

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
  }//get()

  public T peek()
    throws Exception
  {
    if (this.isEmpty())
      {
        throw new Exception("empty");
      } // if empty
    return this.values[this.front];
  }//peek()

  public void print()
  {
    for (int i =0; i < this.values.length; i++)
      {System.out.print(this.values[i]+ " ");
  }System.out.println();
  }
}
