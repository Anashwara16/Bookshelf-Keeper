// Name: Anashwara Rajinkumar Puthlat
// USC NetID: puthlat
// USC NetID: 2138-2056-39
// CSCI455 PA2
// Fall 2021

import java.util.*;

/**
 * Class Bookshelf
 * Implements idea of arranging books into a bookshelf.
 * Books on a bookshelf can only be accessed in a specific way so books don’t fall down;
 * You can add or remove a book only when it’s on one of the ends of the shelf.   
 * However, you can look at any book on a shelf by giving its location (starting at 0).
 * Books are identified only by their height; two books of the same height can be
 * thought of as two copies of the same book.
*/

public class Bookshelf {

    /**
      Representation invariant:

      < All the books must have a height that is greater than 0 (only positive values) and they must be integers. >

   */
   
   // <add instance variables here>
   private ArrayList<Integer> pileOfBooks;
   

   /**
    * Creates an empty Bookshelf object i.e. with no books
    */
   public Bookshelf() {
      
      pileOfBooks = new ArrayList<Integer>();
      
      assert isValidBookshelf();  // sample assert statement (you will be adding more of these calls)
      
   }

   /**
    * Creates a Bookshelf with the arrangement specified in pileOfBooks. Example
    * values: [20, 1, 9].
    * 
    * PRE: pileOfBooks contains an array list of 0 or more positive numbers
    * representing the height of each book.
    */
   public Bookshelf(ArrayList<Integer> pileOfBooks) {
      
      this.pileOfBooks = new ArrayList<Integer>();
        
      for(int i = 0; i < pileOfBooks.size(); i++){
         
         this.pileOfBooks.add(pileOfBooks.get(i));      
         
      }
                 
      assert isValidBookshelf();
   }

   /**
    * Inserts book with specified height at the start of the Bookshelf, i.e., it
    * will end up at position 0.
    * 
    * PRE: height > 0 (height of book is always positive)
    */
   public void addFront(int height) {
      
   }

   /**
    * Inserts book with specified height at the end of the Bookshelf.
    * 
    * PRE: height > 0 (height of book is always positive)
    */
   public void addLast(int height) {
      
   }

   /**
    * Removes book at the start of the Bookshelf and returns the height of the
    * removed book.
    * 
    * PRE: this.size() > 0 i.e. can be called only on non-empty BookShelf
    */
   public int removeFront() {
      
      return 0;   // dummy code to get stub to compile
      
   }

   /**
    * Removes book at the end of the Bookshelf and returns the height of the
    * removed book.
    * 
    * PRE: this.size() > 0 i.e. can be called only on non-empty BookShelf
    */
   public int removeLast() {
      return 0;   // dummy code to get stub to compile      
   }

   /*
    * Gets the height of the book at the given position.
    * 
    * PRE: 0 <= position < this.size()
    */
   public int getHeight(int position) {
      
      return 0;   // dummy code to get stub to compile
      
   }

   /**
    * Returns number of books on the this Bookshelf.
    */
   public int size() {
      
      return 0;   // dummy code to get stub to compile

   }

   /**
    * Returns string representation of this Bookshelf. Returns a string with the height of all
    * books on the bookshelf, in the order they are in on the bookshelf, using the format shown
    * by example here:  “[7, 33, 5, 4, 3]”
    */
   public String toString() {
  
      int numberOfBooks = pileOfBooks.size();
      
      if(numberOfBooks <= 0){
         return "[ ]";
      }
            
      String books = "[";
                                               
      for(int i = 0; i < (numberOfBooks-1); i++){
         
         books += pileOfBooks.get(i) + ", ";
         
      }
      
      books += pileOfBooks.get(numberOfBooks-1) + "]";
      
      return books;   

   }

   /**
    * Returns true iff the books on this Bookshelf are in non-decreasing order.
    * (Note: this is an accessor; it does not change the bookshelf.)
    */
   public boolean isSorted() {
      
      return false;  // dummy code to get stub to compile
   }

   /**
    * Returns true iff the Bookshelf data is in a valid state.
    * (See representation invariant comment for more details.)
    */
   private boolean isValidBookshelf() {
      
      return true;  // dummy code to get stub to compile

   }
   
}
