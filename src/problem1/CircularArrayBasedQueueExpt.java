package problem1;

import java.util.Iterator;

public class CircularArrayBasedQueueExpt
{

  /**
   * @param args
   * @throws Exception
   */
  public static void main(String[] args)
    throws Exception
  {
    CircularArrayBasedQueue<String> array1 =
        new<String> CircularArrayBasedQueue(4);

    System.out.println(array1.isEmpty());
    array1.print();
    array1.put("A");
    array1.print();
    array1.put("B");
    array1.print();
    array1.put("C");
    array1.print();
    array1.put("D");
    array1.print();

    Iterator<String> it = array1.iterator();

    System.out.println(it.hasNext());
    System.out.println(it.next());
    System.out.println(it.hasNext());
    System.out.println(it.next());
    System.out.println(it.hasNext());
    System.out.println(it.next());
    System.out.println(it.hasNext());
    System.out.println(it.next());

    System.out.println(it.hasNext());

  }// main
}// CircularArrayBasedQueueExpt