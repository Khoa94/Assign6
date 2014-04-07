package problem1;

import static org.junit.Assert.*;

import org.junit.Test;

public class CircularArrayBasedQueueTest
{

  @Test
  public void test () 
      throws Exception
  {
    CircularArrayBasedQueue<String> array1 = new <String> CircularArrayBasedQueue(4);
    array1.put ("abdf");
    array1.put ("b");
    array1.put ("c");
    array1.put ("d");

//    String[] tester0= "abdf";
//    tester[1]= "b";
//    tester[2]= "c";
//    tester[3]= "d";
//
//      
//    assertEquals("Array Output is abcd", array1.values, tester);
    array1.get ();
    array1.get ();
    array1.get ();
    array1.get();

    String tester1[]= {null, null, null, null};
    assertEquals("Array Output is abcd", array1.values, tester1);
    
    CircularArrayBasedQueue<String> array2 = new <String> CircularArrayBasedQueue(10); 
    array2.put("I");
    array2.put("Hate");
    array2.put("Cookies");
    array2.put("especially");
    array2.put("chocolate");
    array2.put("chips");
    array2.put("said");
    array2.put("no");
    array2.put("one");
    array2.put("ever");
    array2.print();
    
    String tester2[] = {"I", "Hate", "Cookies", "especially", "chocolate", "chips", "said", "no", "one", "ever"};
    assertEquals("Array Output is abcd", array2.values, tester2);
  }
  
//  @Test
//  public void
//    test2 () throws Exception
//    {
//      CircularArrayBasedQueue<String> array1 = new <String> CircularArrayBasedQueue(4);
//      array1.put ("abdf");
//      array1.put ("b");
//      array1.put ("c");
//      array1.put ("d");
//      
//      String[] tester= new String[4];
//      tester[0]= "abdf";
//      tester[1]= "b";
//      tester[2]= "c";
//  //    A
//      
//    }
}
