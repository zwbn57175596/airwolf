package chap04;// brackets.java
// stacks used to check matching brackets
// to run this program: C>java bracketsApp

import java.io.*;                 // for I/O

////////////////////////////////////////////////////////////////
@SuppressWarnings("ALL")
class Stackchar {
  private int maxSize;
  private char[] stackArray;
  private int top;

  //--------------------------------------------------------------
  public Stackchar(int s)       // constructor
  {
    maxSize = s;
    stackArray = new char[maxSize];
    top = -1;
  }

  //--------------------------------------------------------------
  public void push(char j)  // put item on top of stack
  {
    stackArray[++top] = j;
  }

  //--------------------------------------------------------------
  public char pop()         // take item from top of stack
  {
    return stackArray[top--];
  }

  //--------------------------------------------------------------
  public char peek()        // peek at top of stack
  {
    return stackArray[top];
  }

  //--------------------------------------------------------------
  public boolean isEmpty()    // true if stack is empty
  {
    return (top == -1);
  }

  //--------------------------------------------------------------
  public int size()         // return size
  {
    return top + 1;
  }

  //--------------------------------------------------------------
  public char peekN(int n)  // return item at index n
  {
    return stackArray[n];
  }

  //--------------------------------------------------------------
  public void displayStack(String s) {
    System.out.print(s);
    System.out.print("Stack (bottom-->top): ");
    for (int j = 0; j < size(); j++) {
      System.out.print(peekN(j));
      System.out.print(' ');
    }
    System.out.println("");
  }
  ////--------------------------------------------------------------
}  // end class StackX

////////////////////////////////////////////////////////////////
class BracketChecker {
  private String input;                   // input string

  //--------------------------------------------------------------
  public BracketChecker(String in)        // constructor
  {
    input = in;
  }

  //--------------------------------------------------------------
  public void check() {
    int stackSize = input.length();      // get max stack size
    Stackchar theStack = new Stackchar(stackSize);  // make stack

    for (int j = 0; j < input.length(); j++)  // get chars in turn
    {
      char ch = input.charAt(j);        // get char
      switch (ch) {
      case '{':                      // opening symbols
      case '[':
      case '(':
        theStack.push(ch);          // push them
        break;

      case '}':                      // closing symbols
      case ']':
      case ')':
        if (!theStack.isEmpty())   // if stack not empty,
        {
          char chx = theStack.pop();  // pop and check
          if ((ch == '}' && chx != '{') ||
              (ch == ']' && chx != '[') ||
              (ch == ')' && chx != '('))
            System.out.println("Error: " + ch + " at " + j);
        } else                        // prematurely empty
          System.out.println("Error: " + ch + " at " + j);
        break;
      default:    // no action on other characters
        break;
      }  // end switch
    }  // end for
    // at this point, all characters have been processed
    if (!theStack.isEmpty())
      System.out.println("Error: missing right delimiter");
  }  // end check()
  //--------------------------------------------------------------
}  // end class BracketChecker

////////////////////////////////////////////////////////////////
class BracketsApp {
  public static void main(String[] args) throws IOException {
    String input;
    while (true) {
      System.out.print(
          "Enter string containing delimiters: ");
      System.out.flush();
      input = getString();     // read a string from kbd
      if (input.equals(""))   // quit if [Enter]
        break;
      // make a BracketChecker
      BracketChecker theChecker = new BracketChecker(input);
      theChecker.check();      // check brackets
    }  // end while
  }  // end main()

  //--------------------------------------------------------------
  public static String getString() throws IOException {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    return br.readLine();
  }
  //--------------------------------------------------------------
}  // end class BracketsApp
////////////////////////////////////////////////////////////////
