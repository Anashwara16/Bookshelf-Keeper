

import java.util.*;

/**
 * Class TestAssert
 *
 * This is a unit test to test the isValidBookshelf method implementation of the Bookshelf class.
 *
 */


public class TestAssert{

   public static void main(String[] args){
   
      ArrayList<Integer> firstBooks = new ArrayList<Integer>();
      firstBooks.add(1);
      firstBooks.add(2);   
      firstBooks.add(3);
      firstBooks.add(4);
      firstBooks.add(5);
      
      Bookshelf firstBookshelf = new Bookshelf(firstBooks);
           
      System.out.println("Display first bookshelf which has valid book heights.");
      System.out.println("Expected result of first bookshelf: [1, 2, 3, 4, 5]");
      System.out.println("Actual result of first bookshelf: " + "  " + firstBookshelf.toString());
      System.out.println();
      
      ArrayList<Integer> secondBooks = new ArrayList<Integer>();
      secondBooks.add(11);
      secondBooks.add(12);   
      secondBooks.add(-13);
      secondBooks.add(14);
      secondBooks.add(-15);
      
      Bookshelf secondBookshelf = new Bookshelf(secondBooks);
           
      System.out.println("Display second bookshelf which has invalid book heights.");
      System.out.println("Expected result of second bookshelf: [ ]");
      System.out.println("Actual result of second bookshelf: " + "  " + secondBookshelf.toString());
      System.out.println();
   
   
   }
   
}