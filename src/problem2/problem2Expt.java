package problem2;

public class problem2Expt
{
  public static void main(String[] args)
    throws Exception
  {
    LinkedStack.printMatching("(Hello (world)");
    LinkedStack.printMatching("{oh boy] (I am having) (<so> much) fun matching `symbols'}");
    LinkedStack.printMatching("(Hello (world))}  ]");

  }// main(String[] args)

}// problem2Expt
