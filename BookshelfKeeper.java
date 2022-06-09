

import java.lang.Math;

/**
 * Class BookshelfKeeper 
 *
 * The class BookshelfKeeper maintains a bookshelf with books that are kept in a non-decreasing order of heights. 
 * Enables users to perform efficient putPos or pickHeight operation on a bookshelf of books kept in 
 * non-decreasing order by height, with the restriction that single books can only be added 
 * or removed from one of the two *ends* of the bookshelf to complete a higher level pick or put 
 * operation.  Pick or put operations are performed with minimum number of such adds or removes.
 * 
 */
   
public class BookshelfKeeper {

    /**
      Representation invariant:
      The BookshelfKeeper maintains a bookshelf whose books are sorted in a non-decreasing order of heights. 
    */
   
   //Instance variables
   private Bookshelf sortedPileOfBooks;
   private Bookshelf temporaryPileOfBooks;
   private int totalNumberOfMutatorCalls;
   private int lastNumberOfMutatorCalls;

   /**
    * Default constructor: 
    * Creates a BookShelfKeeper object with an empty bookshelf.
    * PRE: none.
    * Postcondition: Creates a BookshelfKeeper object with empty bookshelf.
    * @param none. 
    * @return none.    
    */
   public BookshelfKeeper() {
      
      sortedPileOfBooks = new Bookshelf();
      
      temporaryPileOfBooks = new Bookshelf();
      
      totalNumberOfMutatorCalls = 0;
      
      lastNumberOfMutatorCalls = 0;
      
      assert isValidBookshelfKeeper();
   }

   
   /**
    * Parameterized Constructor (Non-default constructor):
    * Creates a BookshelfKeeper object initialized with the given sorted bookshelf.
    * Note: The method does not make a defensive copy of the bookshelf.
    * PRE: sortedBookshelf.isSorted() is true.
    * Postcondition: Creates a BookshelfKeeper object initialized with the given sorted bookshelf.
    * @param sorted bookshelf which is utilized to create a new BookshelfKeeper object. 
    * @return none.    
    */
   public BookshelfKeeper(Bookshelf sortedBookshelf) {
      
      assert sortedBookshelf.isSorted();    
      
      sortedPileOfBooks = sortedBookshelf;            
      
      temporaryPileOfBooks = new Bookshelf();
      
      totalNumberOfMutatorCalls = 0;
      
      lastNumberOfMutatorCalls = 0;
      
      assert isValidBookshelfKeeper();
   }

   
   /**
    * Removes a book from the specified position in the bookshelf and keeps bookshelf sorted after picking up the book.
    * Returns the number of calls to mutators on the contained bookshelf used to complete this operation. This must be the minimum number to complete the operation.
    * PRE: 0 <= position < getNumBooks()
    * Postcondition: returns minimum number of calls made to the Bookshelf mutators (addFront(), removeFront(), addLast() and removeLast()) while performing this operation.             * 
    * @param integer 'position' - pick the book from that particular position on the main bookshelf. 
    * @return integer - minimum number of mutator calls made to mutator functions upon insertion of a book with the specified height.      
    */
   public int pickPos(int position) {
      
      int numberOfMutatorCalls = 0;      
      
      int middleOfsortedPileOfBooks = (sortedPileOfBooks.size()/2); 
      
      // Compare the position with the middle element on the bookshelf to determine which set of operations to be performed that result in minimum number of mutator calls.
      if (position < middleOfsortedPileOfBooks) {         
      
         numberOfMutatorCalls = removeBookFromLeft(position);         
         
         sortedPileOfBooks.removeFront();         
         
         numberOfMutatorCalls += addBookFromLeft();         
      } 
      
      else {         
         
         numberOfMutatorCalls = removeBookFromRight(position);         
      
         sortedPileOfBooks.removeLast();         
         
         numberOfMutatorCalls += addBookFromRight();         
      }
      
      numberOfMutatorCalls++;
      
      totalNumberOfMutatorCalls += numberOfMutatorCalls;
      
      lastNumberOfMutatorCalls = numberOfMutatorCalls;
      
      assert isValidBookshelfKeeper();
      
      return numberOfMutatorCalls;
   }
    

   /**
    * Inserts book with the specified height into the bookshelf. Keeps the contained bookshelf sorted after the insertion.
    * Returns the number of calls to mutators on the contained bookshelf used to complete this operation. This must be the minimum number to complete the operation.
    * PRE: height > 0
    * Postcondition: Returns minimum number of calls made to Bookshelf mutators (addFront(), removeFront(), addLast() and removeLast()) while performing this operation on the main bookshelf. 
    * @param integer 'height' - insert book with specified height into the main bookshelf. 
    * @return integer - minimum number of mutator calls made to mutator functions upon insertion of a book with the specified height.  
    */
   public int putHeight(int height) {
      
      int numberOfMutatorCalls = 0;
      
      int middleOfsortedPileOfBooks = (sortedPileOfBooks.size()/2); 
      
      if (sortedPileOfBooks.size() == 0){
      
         sortedPileOfBooks.addFront(height);
      }
      
      else if (height < sortedPileOfBooks.getHeight(middleOfsortedPileOfBooks)) {
         
         numberOfMutatorCalls = heightLessThanMiddleBook(height);
      }
      
      else {
         
         numberOfMutatorCalls = heightMoreThanMiddleBook(height); 
      }
      
      numberOfMutatorCalls++;
      
      totalNumberOfMutatorCalls += numberOfMutatorCalls;
      
      lastNumberOfMutatorCalls = numberOfMutatorCalls;
      
      assert isValidBookshelfKeeper();
      
      return numberOfMutatorCalls;
   }

   
   /**
    * Inserts book with the specified height from the left end of the bookshelf. Keeps the contained bookshelf sorted after the insertion.
    * Precondition: given height of the book which needs to be inserted must be greater than zero.    
    * Postcondition: Returns minimum number of calls made to Bookshelf mutators (addFront(), removeFront(), addLast() and removeLast()) while performing this operation on the main bookshelf. 
    * @param integer 'height' - insert book with specified height into the main bookshelf. 
    * @return integer - minimum number of mutator calls made to mutator functions upon insertion of a book with the specified height from the left end of the bookshelf. 
    */   
   private int heightLessThanMiddleBook(int height){
      
      int numberOfMutatorCalls = 0;
      
      while (sortedPileOfBooks.getHeight(0) < height) {            
         
         int firstBookOnSortedPileOfBooks = sortedPileOfBooks.removeFront();
         
         temporaryPileOfBooks.addLast(firstBookOnSortedPileOfBooks);
         
         numberOfMutatorCalls++;
      }
      
      sortedPileOfBooks.addFront(height);
      
      numberOfMutatorCalls += addBookFromLeft();
      
      return numberOfMutatorCalls;
   }
   
   
   /**
    * Inserts book with the specified height from the right end of the bookshelf. Keeps the contained bookshelf sorted after the insertion.
    * Precondition: given height of the book which needs to be inserted must be greater than zero.    
    * Postcondition: Returns minimum number of calls made to Bookshelf mutators (addFront(), removeFront(), addLast() and removeLast()) while performing this operation on the main bookshelf. 
    * @param integer 'height' - insert book with specified height into the main bookshelf. 
    * @return integer - minimum number of mutator calls made to mutator functions upon insertion of a book with the specified height from the right end of the bookshelf. 
    */      
   private int heightMoreThanMiddleBook(int height){
      
      int numberOfMutatorCalls = 0;
      
      while (sortedPileOfBooks.getHeight(sortedPileOfBooks.size()-1) > height) {
      
         numberOfMutatorCalls++;
         
         int lastBookOnSortedPileOfBooks = sortedPileOfBooks.removeLast();
         
         temporaryPileOfBooks.addFront(lastBookOnSortedPileOfBooks);
       }
      
      sortedPileOfBooks.addLast(height);
      
      numberOfMutatorCalls += addBookFromRight();
      
      return numberOfMutatorCalls;
   }   
   

   /**    
    * Returns the total number of calls made to mutators on the contained bookshelf
    * so far, i.e., all the ones done to perform all of the pick and put operations
    * that have been requested up to now.
    * Precondition: none.    
    * Postcondition: Returns minimum number of calls made to Bookshelf mutators (addFront(), removeFront(), addLast() and removeLast()) while performing this operation on the main bookshelf. 
    * @param none.         
    * @return integer - minimum number of calls made to the Bookshelf mutators (addFront(), removeFront(), addLast() and removeLast()) upon performing all the operations so far.      
    */
   public int getTotalOperations() {      
      
      return totalNumberOfMutatorCalls;
   }

   
   /**
    * Returns the number of books on the contained bookshelf.
    * Precondition: none.    
    * Postcondition: Returns the total number of books on the main bookshelf. 
    * @param none.         
    * @return integer - total number of books on the main bookshelf.     
    */
   public int getNumBooks() {      
      
      return sortedPileOfBooks.size();
   }

   
   /**
    * Returns string representation of this BookshelfKeeper. Returns a String containing height
    * of all books present in the bookshelf in the order they are on the bookshelf, followed 
    * by the number of bookshelf mutator calls made to perform the last pick or put operation, 
    * followed by the total number of such calls made since we created this BookshelfKeeper.
    * Precondition: none.    
    * Postcondition: Returns a string consisting of the main bookshelf along with the number of calls in the last operation and the total number of calls. 
    * @param none.      
    * Example return string showing required format: “[1, 3, 5, 7, 33] 4 10”
    * @return string - string consisting of the main bookshelf along with the number of calls in the last operation and the total number of calls. 
    */
   public String toString() {            
      
      return sortedPileOfBooks.toString() + " " + lastNumberOfMutatorCalls + " " + totalNumberOfMutatorCalls;
   }

   
   /**
    * Returns true iff the BookshelfKeeper data is in a valid state.
    * Representation invariant: The bookshelf must always remain in a sorted state of non-decreasing order of book heights.
    * Precondition: Size of the main bookshelf must be greater than 0.    
    * Postcondition: Returns true if the bookshelf is sorted, else false. 
    * @param none.    
    * @return boolean - true if the bookshelf is sorted, else false. 
    */
   private boolean isValidBookshelfKeeper() {
      
      return sortedPileOfBooks.isSorted();
   }

   
   /**
    * Helper method to remove book from left of the bookshelf and storing it in a temporary bookshelf.
    * Precondition: Size of the main bookshelf must be greater than 0.    
    * Postcondition: Returns minimum number of calls made to Bookshelf mutators (addFront(), removeFront(), addLast() and removeLast()) while performing this operation on the main bookshelf. 
    * @param int 'pos' - position until which books will be removed from the bookshelf.
    * @return integer - minimum number of calls made to the Bookshelf mutators (addFront(), removeFront(), addLast() and removeLast()) while performing this operation on the main bookshelf. 
    */         
   private int removeBookFromLeft(int pos){
      
      int numberOfMutatorCalls = 0;
      
      for (int i=0; i < pos; i++){              

         int firstBookOnSortedPileOfBooks = sortedPileOfBooks.removeFront();         
         
         temporaryPileOfBooks.addLast(firstBookOnSortedPileOfBooks);         
         
         numberOfMutatorCalls++;
      }
      
      return numberOfMutatorCalls;
   }

   
   /**
    * Helper method to add book from the left end of the bookshelf by obtaining books from the right end of the temporary bookshelf.
    * Precondition: Size of the temporary bookshelf must be greater than 0.    
    * Postcondition: Returns minimum number of calls made to Bookshelf mutators (addFront(), removeFront(), addLast() and removeLast()) while performing this operation on the main bookshelf. 
    * @param none.
    * @return integer - minimum number of calls made to the Bookshelf mutators (addFront(), removeFront(), addLast() and removeLast()) while performing this operation on the main bookshelf. 
    */     
   private int addBookFromLeft(){
      
      int numberOfMutatorCalls = 0;
      
      while (temporaryPileOfBooks.size() > 0){         
         
         int lastBookOnTemporaryPileOfBooks = temporaryPileOfBooks.removeLast();         
         
         sortedPileOfBooks.addFront(lastBookOnTemporaryPileOfBooks);         
         
         numberOfMutatorCalls++;
      }
      
      return numberOfMutatorCalls;
   }

   
   /**
    * Helper method removes element from the right end of the bookshelf and storing it in a temporary bookshelf.
    * Precondition: Size of the main bookshelf must be greater than 0.    
    * Postcondition: Returns minimum number of calls made to Bookshelf mutators (addFront(), removeFront(), addLast() and removeLast()) while performing this operation on the main bookshelf. 
    * @param int 'pos' - position until which books will be removed from the bookshelf.
    * @return integer - minimum number of calls made to the Bookshelf mutators (addFront(), removeFront(), addLast() and removeLast()) while performing this operation on the main bookshelf. 
    */      
   private int removeBookFromRight(int pos){
      
      int numberOfMutatorCalls = 0;
      
      for (int i = sortedPileOfBooks.size()-1; i > pos; i--){      
         
         int lastBookOnSortedPileOfBooks = sortedPileOfBooks.removeLast();         
         
         temporaryPileOfBooks.addFront(lastBookOnSortedPileOfBooks);         
         
         numberOfMutatorCalls++;         
      }
      
      return numberOfMutatorCalls;
   }

   
   /**
    * Helper method to add an element from the right end of the bookshelf by accessing elements from the temporary bookshelf.
    * Precondition: Size of the temporary bookshelf must be greater than 0.    
    * Postcondition: Returns minimum number of calls made to Bookshelf mutators (addFront(), removeFront(), addLast() and removeLast()) while performing this operation on the main bookshelf. 
    * @param - none. 
    * @return integer - minimum number of calls made to the Bookshelf mutators (addFront(), removeFront(), addLast() and removeLast()) while performing this operation. 
    */   
   private int addBookFromRight(){
      
      int numberOfMutatorCalls = 0;
      
      while (temporaryPileOfBooks.size() > 0){         
         
         int firstBookOnTemporaryPileOfBooks = temporaryPileOfBooks.removeFront();        
         
         sortedPileOfBooks.addLast(firstBookOnTemporaryPileOfBooks);         
         
         numberOfMutatorCalls++;
      }
      
      return numberOfMutatorCalls;
   }

}


