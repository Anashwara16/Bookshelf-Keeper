// Name: Anashwara Rajinkumar Puthlat
// USC NetID: puthlat
// USC NetID: 2138-2056-39
// CSCI455 PA2
// Fall 2021

import java.util.*;

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
      
      // Test Bookshelf containing pileOfBooks
      System.out.println("Expected result for bookshelf containing pileOfBooks: " + "[1, 5, 18, 9, 7]");
      System.out.println("Actual result for bookshelf containing pileOfBooks: " + "  " + bookshelf.toString());
      System.out.println();
         
            
   }
   
}