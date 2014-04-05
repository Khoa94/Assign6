package taojava.util;

/**
 * Simple nodes for linked structures.
 */
public class Node<T>
{
  // +--------+----------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The value stored in the ndoe.
   */
  T value;

  /**
   * The next node.
   */
  Node<T> next;

  // +--------------+----------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new node that contains val and that links to
   * next.
   */
  public Node(T value, Node<T> next)
  {
    this.value = value;
    this.next = next;
  } // Node(T, Node<T>)
} // class Node<T>
