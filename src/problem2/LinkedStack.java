package problem2;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A simple array-based stack.
 * 
 * @author Samuel A. Rebelsky
 * @author Victoria Tsou
 * @author Khoa Nguyen
 */
public class LinkedStack<T>
    implements
      Stack<T>
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
  } // pop()

  /*
   * The class that store the symbols and its position.
   */
  static class ParensAndPositions
  {
    char paren;
    int index;

    public ParensAndPositions(char inputCurrent, int inputIndex)
    {
      this.paren = inputCurrent;
      this.index = inputIndex;
    }// ParensAndPositions constructor
  }// ParensAndPositions class

  /*
   * Print the dashes between the left paren and the right paren
   */
  public static void printDashesParens(ParensAndPositions charOnStack,
                                       char closingParen,
                                       int indexOfClosingParen)
  {
    // Print the space before the left paren
    for (int i = 0; i < charOnStack.index; i++)
      {
        System.out.print(" ");
      }// for

    // Print the left paren
    System.out.print(charOnStack.paren);

    // Print the dashes
    for (int i = charOnStack.index; i < indexOfClosingParen - 1; i++)
      {
        System.out.print("-");
      }// for

    // Print the right paren
    System.out.print(closingParen);
    System.out.println();
  }// printDashesParens(ParensAndPositions charOnStack, char closingParen, int
   // indexOfClosingParen)

  /*
   * Print the "<- UNMATCHED" next to the unmatched paren
   */
  public static void printUnmatchedMessage(ParensAndPositions unmatchedParen)
  {
    char currentClosingParen = unmatchedParen.paren;
    int indexOfCurrentClosingParen = unmatchedParen.index;
    for (int j = 0; j < indexOfCurrentClosingParen; j++)
      {
        System.out.print(" ");
      }// for
    System.out.println(currentClosingParen + "<- UNMATCHED");
  }// printUnmatchedMessage(ParensAndPositions new1)

  /*
   * Go through the string. For each pair of parens, print the left and right
   * parens with dashes in between them at appropriate positions
   */
  public static void printMatching(String str)
    throws Exception
  {
    System.out.println(str);
    LinkedStack<ParensAndPositions> parenStack = new LinkedStack();
    int i = 0;

    PrintWriter pen = new PrintWriter(System.out, true);

    ParensAndPositions charOnStack1;

    // go through the string
    while (i < str.length())
      {
        char currentChar = str.charAt(i);

        // check whether currentChar is a left paren. If it is, push it onto the
        // stack
        if (currentChar == '(' || currentChar == '[' || currentChar == '{'
            || currentChar == '<' || currentChar == '`')
          {
            ParensAndPositions currentPair =
                new ParensAndPositions(currentChar, i);
            parenStack.push(currentPair);
          }// if

        // if currentChar is not left paren, check to see if it is a right
        // paren, or letter and then do appropriate actions
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
                        // when the right paren doesn't have a correspondence
                        // left paren
                        {
                          ParensAndPositions unmatchedParen =
                              new ParensAndPositions(currentChar, i);
                          printUnmatchedMessage(unmatchedParen);
                        }// else
                      break;

                    case ']':
                      if (parenStack.peek().paren == '[')
                        {

                          charOnStack1 = parenStack.pop();
                          printDashesParens(charOnStack1, currentChar, i);
                        }// if
                      else
                        {
                          ParensAndPositions unmatchedParen =
                              new ParensAndPositions(currentChar, i);
                          printUnmatchedMessage(unmatchedParen);
                        }// else
                      break;

                    case '}':
                      if (parenStack.peek().paren == '{')
                        {
                          charOnStack1 = parenStack.pop();
                          printDashesParens(charOnStack1, currentChar, i);
                        }// if
                      else
                        {
                          ParensAndPositions unmatchedParen =
                              new ParensAndPositions(currentChar, i);
                          printUnmatchedMessage(unmatchedParen);
                        }// else
                      break;

                    case '>':
                      if (parenStack.peek().paren == '<')
                        {
                          charOnStack1 = parenStack.pop();
                          printDashesParens(charOnStack1, currentChar, i);
                        }// if
                      else
                        {
                          ParensAndPositions unmatchedParen =
                              new ParensAndPositions(currentChar, i);
                          printUnmatchedMessage(unmatchedParen);
                        }// else
                      break;

                    case '\'':
                      if (parenStack.peek().paren == '`')
                        {
                          charOnStack1 = parenStack.pop();
                          printDashesParens(charOnStack1, currentChar, i);
                        }// if
                      else
                        {
                          ParensAndPositions unmatchedParen =
                              new ParensAndPositions(currentChar, i);
                          printUnmatchedMessage(unmatchedParen);
                        }// else
                      break;
                  }// switch
              }// if not empty

            // currentChar is a right paren but there's no left paren on
            // parenStack.
            else if (currentChar == ')' || currentChar == ']'
                     || currentChar == '}' || currentChar == '>'
                     || currentChar == '\'')
              {
                ParensAndPositions unclosedLeftSidedParen =
                    new ParensAndPositions(currentChar, i);
                printUnmatchedMessage(unclosedLeftSidedParen);
              } // else if. There is a right paren that has no left brace on the
                // parenStack.
          }// else
        i++;
      }// while

    // If there is an extra left paren on the parenStack after iterating through
    // the whole string.
    while (!parenStack.isEmpty())
      {
        printUnmatchedMessage(parenStack.pop());
      }
  }// printMatching(String str).
} // LinkedStack<T>

class LinkedStackIterator<T>
    implements
      Iterator<T>
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
