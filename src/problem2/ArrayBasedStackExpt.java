package problem2;

/**
 * A really simple experiment with ArrayBasedStacks.
 *
 * @author Samuel A. Rebelsky.
 */
public class ArrayBasedStackExpt
{
  /**
   * Do all the work.  (Well, make the helpers do all the work.)
   */
  public static void main(String[] args)
    throws Exception
  {
    //LSExpt.expt01(new ArrayBasedStack<String>(16), "size16.");
    //LSExpt.expt01(new ArrayBasedStack<String>(4), "size04.");
   
    
    String ourString = "(gebvgg[trrrrr]gggg)gt4g4gt";
    System.out.println(ArrayBasedStack.checkMatching(ourString));
    System.out.println(ArrayBasedStack.checkMatching("[(])"));
  } // main(String[])
} // class ArrayBasedStackExpt
