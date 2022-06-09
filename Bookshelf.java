

import java.util.*;
import java.lang.Exception;

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
      All the books must have a height that is greater than 0 (only positive values) and they must be integers. 
   */
   
   // Instance variables
   private ArrayList<Integer> pileOfBooks;
   
   /**
    * Creates an empty Bookshelf object i.e. with no books
    * PRE: none.
    * Postcondition: A new empty bookshelf is created.  
    * @param none. 
    * @return none.        
    */
   public Bookshelf() {      
      
      pileOfBooks = new ArrayList<Integer>();      
      
      assert isValidBookshelf();        
   }

   /**
    * Creates a Bookshelf with the arrangement specified in pileOfBooks. Example
    * values: [20, 1, 9].
    * 
    * PRE: pileOfBooks contains an array list of 0 or more positive numbers
    * representing the height of each book.
    * Postcondition: A new bookshelf is created with the initial arrangement provided by the array list. Its validity is also checked.  
    * @param ArrayList (integer) consisting of the initial arrangement of books. 
    * @return none.    
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
    * PRE: height > 0 (height of book is always positive)
    * Postcondition: A new book with the given height is added to the left end (front end) of the bookshelf. 
    * @param integer 'height' - add a book with this height to the left end (front) of the bookshelf. 
    * @return none.
    */    
   public void addFront(int height) {              
      
      assert (height > 0) : "Book cannot be added to the front of the bookshelf. Height of a book must always be positive and greater than 0. Height is: " + height;       
      
      pileOfBooks.add(0, height);       
      
      assert isValidBookshelf();
   }

   /**
    * Inserts book with specified height at the end of the Bookshelf.
    * PRE: height > 0 (height of book is always positive)
    * Postcondition: A new book with the given height is added to the right end (last) of the bookshelf. 
    * @param integer 'height' - add a book with this height to the right end of the bookshelf. 
    * @return none.
    */
   public void addLast(int height) {          
      
      assert (height > 0) : "Book cannot be added to the last of the bookshelf. Height of a book must always be positive and greater than zero. Height is: " + height;
      
      pileOfBooks.add(height); 
      
      assert isValidBookshelf();           
   }

   /**
    * Removes book at the start of the Bookshelf and returns the height of the
    * removed book. 
    * PRE: this.size() > 0 i.e. can be called only on non-empty BookShelf. 
    * Postcondition: Returns the height of the first book removed from the bookshelf. 
    * @param none.      
    * @return integer - height of the first book removed from the bookshelf. 
    */
   public int removeFront() {
      
      assert (pileOfBooks.size() > 0) : "First book on the bookshelf can only be removed from a non-empty bookshelf. Bookshelf is of size: " + pileOfBooks.size();
      
      int firstBook = pileOfBooks.remove(0);      
      
      return firstBook;            
   }

   /**
    * Removes book at the end of the Bookshelf and returns the height of the
    * removed book.  
    * PRE: this.size() > 0 i.e. can be called only on non-empty BookShelf
    * Postcondition: Returns the height of the last book removed from the bookshelf. 
    * @param none.      
    * @return integer - height of the last book removed from the bookshelf. 
    */
   public int removeLast() {            
      
      assert (pileOfBooks.size() > 0) : "Last book on the bookshelf can only be removed from a non-empty bookshelf. Bookshelf is of size: " + pileOfBooks.size();           
      
      int lastBook = pileOfBooks.remove(pileOfBooks.size()-1);      
      
      assert isValidBookshelf();      
      
      return lastBook; 
    }

   /*
    * Gets the height of the book at the given position. 
    * PRE: 0 <= position < this.size() 
    * Postcondition: Returns the height of the book at the given position. 
    * @param integer 'position' - get the height of the book at this position on the bookshelf.     
    * @return height of the book at the given position.
    */
   public int getHeight(int position){
              
      assert (position > 0 || position <= pileOfBooks.size()) : "Position of the book entered is not valid. Position is: " + position;
           
      int bookHeight = pileOfBooks.get(position);
      
      return bookHeight;        
   }

   /**
    * Returns number of books on the this Bookshelf.
    * Precondition: none. 
    * Postcondition: Returns the size of the bookshelf. 
    * @param - none.     
    * @return integer - size of the bookshelf. 
    */
   public int size() {      
      
      return pileOfBooks.size();   
   }

   /**
    * Returns string representation of this Bookshelf. Returns a string with the height of all
    * books on the bookshelf, in the order they are in on the bookshelf, using the format shown
    * by example here:  “[7, 33, 5, 4, 3]”
    * Precondition: none. 
    * Postcondition: Returns a string using the format shown by the example “[7, 33, 5, 4, 3]”. 
    * @param - none.     
    * @return a string using the format shown by the example “[7, 33, 5, 4, 3]”. 
    */
   public String toString() {     
      
      int numberOfBooks = pileOfBooks.size();      
      
      if(numberOfBooks <= 0){
         
         return "[]";
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
    * Precondition: Size of the bookshelf must be greater than 0.    
    * Postcondition: Returns true if the bookshelf is sorted in non-decreasing order of heights, else false. 
    * @param - none.    
    * @return boolean - true if the bookshelf is sorted in a non-decreasing order of heights, else false. 
    */
   public boolean isSorted() {     
    
//      assert (pileOfBooks.size() > 0) : "Only a non-empty bookshelf can be sorted. Bookshelf is of size: " + pileOfBooks.size();      
      
      for (int i = 0; i < pileOfBooks.size() - 1; i++) {
      
         if (pileOfBooks.get(i) > pileOfBooks.get(i+1)){
         
            return false;
         }   
      }
      
      return true;  
   }

   /**
    * Returns true iff the Bookshelf data is in a valid state.
    * (See representation invariant comment for more details.)
    * All the books must have a height that is greater than 0 (only positive values) and they must be integers. 
    * Precondition: Size of the bookshelf must be greater than 0.    
    * Postcondition: Returns true if the bookshelf has only valid heights (positive - height > 0), else false. 
    * @param - none. 
    * @return boolean - true if the bookshelf has only valid heights (positive - height > 0), else false. 
    */
   private boolean isValidBookshelf() {
                          
      for (int i = 0; i < pileOfBooks.size(); i++){
      
         if (pileOfBooks.get(i) <= 0){
         
            assert (pileOfBooks.get(i) > 0) : "Bookshelf has books with negative heights. Height of a book must always be positive and greater than zero. Height is: " + pileOfBooks.get(i);
            
            return false;
         }
      }      
      
      for (int i = 0; i < pileOfBooks.size() - 1; i++) {
         
         if (pileOfBooks.get(i) > pileOfBooks.get(i+1)){
         
            return false;
         }   
      }
      
      return true;
   }
}
