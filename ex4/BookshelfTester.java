// Name: Anashwara Rajinkumar Puthlat
// USC NetID: puthlat
// USC NetID: 2138-2056-39
// CSCI455 PA2
// Fall 2021

import java.util.*;
import java.util.Scanner;

/**
 * Class BookshelfTester 
 *
 * This is a unit test to test the implementation of the Bookshelf class.
 * It has hard-coded data (no user input), shows expected as well as actual results, tests various combinations of calling the methods, and tests both general 
 * and edge cases.
 *
 */

public class BookshelfTester {
   
   public static void main(String[] args){     
      
      //EX2
      // Creates an empty Bookshelf (i.e. with no books).
      Bookshelf emptyBookshelf = new Bookshelf();
           
      // Test empty bookshelf with no books
      System.out.println();
      System.out.println("Expected result for empty bookshelf: " + "[ ]");
      System.out.println("Actual result for empty bookshelf: " + "  " + emptyBookshelf.toString());
      System.out.println();
      
      // Creates an ArrayList pileOfBooks storing their heights.
      ArrayList<Integer> pileOfBooks = new ArrayList<Integer>();
      pileOfBooks.add(1);
      pileOfBooks.add(5);   
      pileOfBooks.add(18);
      pileOfBooks.add(9);
      pileOfBooks.add(7);
      
      // Creates a Bookshelf with the arrangement specified in pileOfBooks.
      Bookshelf bookshelf = new Bookshelf(pileOfBooks);
      
      // Creates an ArrayList otherPileOfBooks storing their heights.
      ArrayList<Integer> otherPileOfBooks = new ArrayList<Integer>();
      otherPileOfBooks.add(1);
      otherPileOfBooks.add(2);   
      otherPileOfBooks.add(3);
      otherPileOfBooks.add(4);
      otherPileOfBooks.add(5);
      
      // Creates a Bookshelf with the arrangement specified in pileOfBooks.
      Bookshelf otherBookshelf = new Bookshelf(otherPileOfBooks);
      
      // Test Bookshelf containing pileOfBooks
      System.out.println("Expected result for bookshelf containing pileOfBooks: " + "[1, 5, 18, 9, 7]");
      System.out.println("Actual result for bookshelf containing pileOfBooks: " + "  " + bookshelf.toString());
      System.out.println();
          
      //EX3
      // Test addFront method with greater than 0, equal to 0 & less than 0 book height values   
      bookshelf.addFront(10);
      System.out.println("Adding a book of height 10 to the front of the bookshelf.");
      System.out.println("Expected result for bookshelf containing pileOfBooks: " + "[10, 1, 5, 18, 9, 7]");
      System.out.println("Actual result for bookshelf containing pileOfBooks: " + "  " + bookshelf.toString());
      System.out.println();
      
/*      bookshelf.addFront(0);
      System.out.println("Adding a book of height 0 to the front of the bookshelf.");
      System.out.println("Expected result for bookshelf containing pileOfBooks: " + "[10, 1, 5, 18, 9, 7]");
      System.out.println("Actual result for bookshelf containing pileOfBooks: " + "  " + bookshelf.toString());
      System.out.println();
      
      bookshelf.addFront(-10);
      System.out.println("Adding a book of height (-10) to the front of the bookshelf.");
      System.out.println("Expected result for bookshelf containing pileOfBooks: " + "[10, 1, 5, 18, 9, 7]");
      System.out.println("Actual result for bookshelf containing pileOfBooks: " + "  " + bookshelf.toString());
      System.out.println();
*/
      
      // Test addLast method with greater than 0, equal to 0 & less than 0 book height values     
      bookshelf.addLast(20);
      System.out.println("Adding a book of height 20 to the last of the bookshelf.");
      System.out.println("Expected result for bookshelf containing pileOfBooks: " + "[10, 1, 5, 18, 9, 7, 20]");
      System.out.println("Actual result for bookshelf containing pileOfBooks: " + "  " + bookshelf.toString());
      System.out.println();
/*      
      bookshelf.addLast(0);
      System.out.println("Adding a book of height 0 to the last of the bookshelf.");
      System.out.println("Expected result for bookshelf containing pileOfBooks: " + "[10, 1, 5, 18, 9, 7, 20]");
      System.out.println("Actual result for bookshelf containing pileOfBooks: " + "  " + bookshelf.toString());
      System.out.println();
      
      bookshelf.addLast(-20);
      System.out.println("Adding a book of height (-20) to the last of the bookshelf.");
      System.out.println("Expected result for bookshelf containing pileOfBooks: " + "[10, 1, 5, 18, 9, 7, 20]");
      System.out.println("Actual result for bookshelf containing pileOfBooks: " + "  " + bookshelf.toString());
      System.out.println();
*/           
      // Test removeFront method on a non-empty bookshelf     
      bookshelf.removeFront();
      System.out.println("Removing the first book from the bookshelf.");
      System.out.println("Expected result after removing the first book from the bookshelf: " + "[1, 5, 18, 9, 7, 20]");
      System.out.println("Actual result after removing the first book from the bookshelf: " + "  " + bookshelf.toString());
      System.out.println();
      
/*      // Test removeFront method on an empty bookshelf     
      emptyBookshelf.removeFront();
      System.out.println("Removing the first book from the bookshelf.");
      System.out.println("Expected result after removing the first book from the bookshelf: " + "[ ]");
      System.out.println("Actual result after removing the first book from the bookshelf: " + "  " + emptyBookshelf.toString());
      System.out.println();
*/
      
      // Test removeLast method on a non-empty bookshelf     
      bookshelf.removeLast();
      System.out.println("Removing the last book from the bookshelf.");
      System.out.println("Expected result after removing the last book from the bookshelf: " + "[1, 5, 18, 9, 7]");
      System.out.println("Actual result after removing the last book from the bookshelf: " + "  " + bookshelf.toString());
      System.out.println();
      
/*      // Test removeLast method on an empty bookshelf     
      emptyBookshelf.removeLast();
      System.out.println("Removing the last book from the bookshelf.");
      System.out.println("Expected result after removing the last book from the bookshelf: " + "[ ]");
      System.out.println("Actual result after removing the last book from the bookshelf: " + "  " + bookshelf.toString());
      System.out.println();
*/      
      //EX4   
      // Test getHeight method with greater than 0, equal to 0 & less than 0 book position values 
 /*     bookshelf.getHeight(-1);
      System.out.println("Expected result of height of the book at position (-1) on the bookshelf: " + " ");
      System.out.println("Actual result of height of the book at position (-1) on the bookshelf: " + "  " + bookshelf.getHeight(-1));
      System.out.println();
   */   
      bookshelf.getHeight(0);
      System.out.println("Expected result of height of the book at position 0 on the bookshelf: " + " 1 ");
      System.out.println("Actual result of height of the book at position 0 on the bookshelf: " + "   " + bookshelf.getHeight(0));
      System.out.println();
      
      bookshelf.getHeight(3);
      System.out.println("Expected result of height of the book at position 3 on the bookshelf: " + " 9 ");
      System.out.println("Actual result of height of the book at position 3 on the bookshelf: " + "   " + bookshelf.getHeight(3));
      System.out.println();
      
      bookshelf.getHeight(4);
      System.out.println("Expected result of height of the book at position 4 on the bookshelf: " + " 7 ");
      System.out.println("Actual result of height of the book at position 4 on the bookshelf: " + "   " + bookshelf.getHeight(4));
      System.out.println();
      
/*      bookshelf.getHeight(5);
      System.out.println("Expected result of height of the book at position 5 on the bookshelf: " + " ");
      System.out.println("Actual result of height of the book at position 5 on the bookshelf: " + "  " + bookshelf.getHeight(5));
      System.out.println();
 */      
      // Get size of the empty bookshelf
      System.out.println("Size of the empty bookshelf: ");
      System.out.println("Expected size of the empty bookshelf: " + 0);
      System.out.println("Actual size of the empty bookshelf: " + "  "+ emptyBookshelf.size());
      System.out.println();
    
      //Get size of the non-empty bookshelf
      System.out.println("Size of the non-empty bookshelf: ");
      System.out.println("Expected size of the non-empty bookshelf: " + 5);
      System.out.println("Actual size of the non-empty bookshelf: " + "  " + bookshelf.size());
      System.out.println();

/*      // Test isSorted method on empty bookshelf
      System.out.println("Is the empty bookshelf sorted?");
      System.out.println("Expected result of bookshelf being sorted: false");
      System.out.println("Actual result of bookshelf being sorted: " + emptyBookshelf.isSorted());
      System.out.println();
*/      
      // Test isSorted method on an unsorted non-empty bookshelf
      System.out.println("Is the bookshelf sorted?");
      System.out.println("Expected result of bookshelf being sorted: false");
      System.out.println("Actual result of bookshelf being sorted: " + bookshelf.isSorted());
      System.out.println();
      
      // Test isSorted method on a sorted non-empty bookshelf
      System.out.println("Is the bookshelf sorted?");
      System.out.println("Expected result of bookshelf being sorted: true");
      System.out.println("Actual result of bookshelf being sorted: " + otherBookshelf.isSorted());
      System.out.println();
      
      
            
   }
   
}