package problem1;

public class CircularArrayBasedQueueExpt
{

  /**
   * @param args
   * @throws Exception 
   */
  public static void main(String[] args) throws Exception
  {
    CircularArrayBasedQueue<String> array1 = new <String> CircularArrayBasedQueue(4);  

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

    System.out.println(array1.get());
    array1.print();
    array1.put("E");
    array1.print();
    System.out.println(array1.get());
    array1.print();
    System.out.println(array1.get());
    array1.print();
    System.out.println(array1.get());
    array1.print();
    array1.put("Ending");
    array1.print();
    array1.put("Done");
    array1.print();
    
  }

}
