package problem1;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Iterator;

import junit.framework.Assert;

import org.junit.Test;

public class CircularArrayBasedQueueTest
{

  @Test
  public void test()
    throws Exception
  {
    // test put()
    CircularArrayBasedQueue<String> circularQueue1 =
        new<String> CircularArrayBasedQueue(4);
    circularQueue1.put("abdf");
    circularQueue1.put("b");
    circularQueue1.put("c");
    circularQueue1.put("d");

    String expected1[] = { "abdf", "b", "c", "d" };
    assertArrayEquals(circularQueue1.values, expected1);

    // test get()
    circularQueue1.get();
    circularQueue1.get();
    circularQueue1.get();
    circularQueue1.get();
    String expected2[] = { null, null, null, null };
    assertArrayEquals(circularQueue1.values, expected2);

    // test put() with longer strings
    CircularArrayBasedQueue<String> circularQueue2 =
        new<String> CircularArrayBasedQueue(10);
    circularQueue2.put("I");
    circularQueue2.put("Hate");
    circularQueue2.put("Cookies");
    circularQueue2.put("especially");
    circularQueue2.put("chocolate");
    circularQueue2.put("chips");
    circularQueue2.put("said");
    circularQueue2.put("no");
    circularQueue2.put("one");
    circularQueue2.put("ever");
    circularQueue2.print();

    String expected3[] =
        { "I", "Hate", "Cookies", "especially", "chocolate", "chips", "said",
         "no", "one", "ever" };
    assertArrayEquals("Array Output is abcd", circularQueue2.values, expected3);

    // test the iterator
    Iterator<String> it = circularQueue2.iterator();
    assertEquals(it.hasNext(), true);
    assertEquals(it.next(), "I");

  }

}
