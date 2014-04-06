package problem2;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.NoSuchElementException;



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
    char paren;
    int index;

    public ParensPositions(char inputCurrent, int inputIndex)
    {
      this.paren = inputCurrent;
      this.index = inputIndex;
    }// parensPositions constructor
  }// parensPositions class

  public static void printDashesParens(ParensPositions charOnStack,
                                       char closingParen,
                                       int indexOfClosingParen)
  {
    for (int i = 0; i < charOnStack.index ; i++)
      {
        System.out.print(" ");
      }

    System.out.print(charOnStack.paren);

    for (int i = charOnStack.index; i < indexOfClosingParen-1; i++)
      {
        System.out.print("-");
      }

    System.out.print(closingParen);
    System.out.println();
  }
  
  public static void printUnmatchedMessage(ParensPositions new1)
  {
    char currentClosingParen= new1.paren;
    int indexOfCurrentClosingParen= new1.index;
    for (int j = 0; j < indexOfCurrentClosingParen ; j++)
      {
        System.out.print(" ");
      }
      System.out.println(currentClosingParen + "<- UNMATCHED");
  }

  public static void printMatching(String str)
    throws Exception
  {
    System.out.println(str);
    LinkedStack<ParensPositions> parenStack =
        new LinkedStack();
    int i = 0;

    PrintWriter pen = new PrintWriter(System.out, true);

    ParensPositions charOnStack1;
    while (i < str.length())
      {
        char currentChar = str.charAt(i);
        if (currentChar == '(' || currentChar == '[' || currentChar == '{'
            || currentChar == '<' || currentChar == '\'')
          {
            ParensPositions currentPair = new ParensPositions(currentChar, i);
            parenStack.push(currentPair);
          }// if
        else
          {
            if (!parenStack.isEmpty())
              {
            
            switch (currentChar)
              {
                case ')':
                  if (parenStack.peek().paren == '(')
                    {
                      charOnStack1 = parenStack.pop();
                      printDashesParens(charOnStack1, currentChar, i);
                    }// if
                  else 
                    {
                    ParensPositions unmatchedParen = new ParensPositions(currentChar, i); 
                    printUnmatchedMessage(unmatchedParen);
                    }
                  break;

                case ']':
                  if ( parenStack.peek().paren == '[')
                    {

                      charOnStack1 = parenStack.pop();
                      printDashesParens(charOnStack1, currentChar, i);
                    }// if
                  else 
                    {
                      ParensPositions unmatchedParen = new ParensPositions(currentChar, i); 
                      printUnmatchedMessage(unmatchedParen);
                      }
                  break;

                case '}':
                  if (parenStack.peek().paren == '{')
                    {
                      charOnStack1 = parenStack.pop();
                      printDashesParens(charOnStack1, currentChar, i);
                    }// if
                  else 
                    {
                      ParensPositions unmatchedParen = new ParensPositions(currentChar, i); 
                      printUnmatchedMessage(unmatchedParen);
                      }
                  break;

                case '>':
                  if (parenStack.peek().paren == '<')
                    {
                      charOnStack1 = parenStack.pop();
                      printDashesParens(charOnStack1, currentChar, i);
                    }// if
                  else 
                    {
                      ParensPositions unmatchedParen = new ParensPositions(currentChar, i); 
                      printUnmatchedMessage(unmatchedParen);
                      }
                  break;

                case '\'':
                  if ( parenStack.peek().paren =='\'')
                    {
                      charOnStack1 = parenStack.pop();
                      printDashesParens(charOnStack1, currentChar, i);
                    }// if
                  else 
                    {
                      ParensPositions unmatchedParen = new ParensPositions(currentChar, i); 
                      printUnmatchedMessage(unmatchedParen);
                      }
                  break;
              }//switch
              }//if not empty
            else if (currentChar == ')' || currentChar == ']' || currentChar == '}'
                  || currentChar == '>' || currentChar == '\''){
            ParensPositions Gross = new ParensPositions (currentChar,i);
            printUnmatchedMessage(Gross);
              }
              
          }//else
     
        i++;
      }//while

    while(!parenStack.isEmpty())
      {
       
        
        printUnmatchedMessage(parenStack.pop());

        //ParensPositions hello = parenStack.pop();
        //printUnmatchedMessage(hello.paren,hello.index);
        //pen.println(parenStack.pop().paren + "< - UNMATCHED");
        //printUnmatchedMessage()
      }
  }//printMatching(String str)
  
  public static void main(String[] args)
      throws Exception
      {
       String str1 = "(He)ll)o (world)";
      String str2= "{oh boy] (I am having) (<so> much) fun matching )symbols}";
       printMatching(str1);
         
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
