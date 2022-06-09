
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class BookshelfKeeperProg 
 *
 * PROGRAM DESCRIPTION:
 * The Bookshelf-keeper program that maintains a bookshelf in non-decreasing order by height, that enables users to perform a series of put & pick operations via a BookshelfKeeper object. 
 * The pick operation refers to a case where you need to pick a book from a given position (index), and the put operation refers to putting a book of given height on the shelf. 
 * Books can be added (put) or removed (pick) from the bookshelf only from either of the two ends and it is required to perform this using minimum number of calls to its mutator functions. 
 * The bookshelf is always maintained in a sorted order after completing any operation. 
 *
 *
 * The program consists of the following:
 *
 * 1) Bookshelf:
 * The class Bookshelf implements idea of arranging books into a bookshelf. 
 * Books on a bookshelf can only be accessed in a specific way so books don’t fall down. 
 * Books can be added or removed from only one of the ends of the shelf. They can be accessed by specifying their location. 
 * Books are identified only by their height; 2 books of the same height can be considered as 2 copies of the same book.
 *
 * 
 * 2) BookshelfKeeper:
 * The class BookshelfKeeper maintains a bookshelf with books that are kept in a sorted state of non-decreasing order of heights. 
 * Enables users to perform efficient putPos or pickHeight operation on a bookshelf of books kept in non-decreasing order by height. 
 * Restriction: single books can only be added or removed from one of the two *ends* of the bookshelf to complete a higher level pick or put operation.  
 * Pick or put operations are performed with a minimum number of such adds or removes.
 *
 *
 * 3) BookshelfKeeperProg:
 * The class BookshelfKeeperProg main method takes user input of a list of integers and ensures that all the books on the bookshelf are positive and in non-decreasing order.
 * It enables the user to perform a series of pickPos and putHeight operations on the bookshelf with user commands "pick" and "put".  
 *
 *
 * SUMMARY:
 * The BookshelfKeeperProg takes user input and creates an initial bookshelf. The Bookshelf has the interface for arranging the books on the bookshelf and its mutator functions. The BookshelfKeeper ensures the sorted state of the bookshelf and the validity of the mutator functions on the bookshelf. 
 *
 * 
 * RUNNING THE PROGRAM:
 * To observe the implementation of the BookshelfKeeper, compile and run as follows: 
 * javac Bookshelf*.java
 * java -ea BookshelfKeeperProg
 *
 *
 * CLASS DESCRIPTION: 
 * Class BookshelfKeeperProg's main method takes user input of a list of integers that make-up the initial arrangement of the bookshelf. 
 * It ensures that all the books on the bookshelf are positive and in non-decreasing order.
 * Once the initial configuration is read the only commands allowed are pick, put, and end.
 * It enables the user to perform a series of pickPos and putHeight operations on a BookshelfKeeper object in an interactive mode with user commands "pick" and "put".  
 * For put operation, the height given must be positive.
 * For pick operation, the position given must be within the valid bounds for the bookshelf. 
 * The user can then submit the user command "end", once all the required operations have been completed. 
 *	
 */

public class BookshelfKeeperProg {

   // Initialize constant string variables for each of the user commands 
   private static final String PICK = "pick";
   private static final String PUT = "put";
   private static final String END = "end";
   
   public static void main(String[] args){

      Scanner in = new Scanner(System.in);   
      
      ArrayList<Integer> temporaryListOfBooks;
      
      System.out.println("Please enter initial arrangement of books followed by newline:");
                                             
      temporaryListOfBooks = getInitialBooks(in);
 
      if(!isValidBookshelf(temporaryListOfBooks)){
            return;
      }     
      
      Bookshelf pileOfBooks = new Bookshelf(temporaryListOfBooks);      
     
      BookshelfKeeper bookshelfKeeper = new BookshelfKeeper(pileOfBooks);          
         
      System.out.println(bookshelfKeeper.toString());  
      
      System.out.println("Type pick <index> or put <height> followed by newline. Type end to exit.");      
      
      userOperations(in, bookshelfKeeper);      
         
      System.out.println("Exiting Program.");                 
      
   }
   
      private static ArrayList<Integer> getInitialBooks(Scanner in){
      
         String inputLine = in.nextLine();
                  
         String[] inputString = inputLine.trim().split("\\s+");          
         
         ArrayList<Integer> temporaryListOfBooks = new ArrayList<Integer>();
         
         for (int i = 0; i < inputString.length; i++) {
         
         if(!isInteger(inputString[i])){
            ArrayList<Integer> emptyListOfBooks = new ArrayList<Integer>();
            return emptyListOfBooks; 
         }
            
            
         int book = Integer.parseInt(inputString[i]);
         
         temporaryListOfBooks.add(book);           
            
         }
                  
         return temporaryListOfBooks;
     }   
   
        
   private static boolean isInteger(String s) {

      boolean isValidInteger = false;
      
      try
      {
         Integer.parseInt(s);

         // s is a valid integer 
         isValidInteger = true;
      }
      
      catch (NumberFormatException ex)
      {
       //  System.out.println("ERROR: Height of a book must be positive.");         
      }
 
      return isValidInteger;
   }      
      
   /**
   * Static method to verify if the bookshelf is valid or not. 
   * Precondition: User provided bookshelf must have a size greater than 0 to verify whether the books have a height > 0 & sorted in non-decreasing order of heights.  
   * Postcondition: returns true if all the books on the bookshelf have heights more than zero (height > 0) and if they are all arranged in non-decreasing order of heights, else false. 
   * @param An integer ArrayList 'temporaryListOfBooks' is the initial arrangement of books on the bookshelf provided by the user.
   * @return boolean - true if all the books on the bookshelf have heights more than zero (height > 0) and if they are all arranged in non-decreasing order of heights, else false. 
   */    
   private static boolean isValidBookshelf(ArrayList<Integer> temporaryListOfBooks){
      
      for(int i=0; i<temporaryListOfBooks.size(); i++){         
      
         if(temporaryListOfBooks.get(i) <= 0){            
         
            System.out.println("ERROR: Height of a book must be positive.");            
            
            System.out.println("Exiting Program.");           
            
            return false;         
         }  
      }
         
      for(int i=0; i < temporaryListOfBooks.size()-1; i++){         
         
         if(temporaryListOfBooks.get(i) > temporaryListOfBooks.get(i+1)){            
         
            System.out.println("ERROR: Heights must be specified in non-decreasing order.");            
            
            System.out.println("Exiting Program.");           
            
            return false;         
         }  
      }            
      return true;  
   }        
   
   /**
   * Method to verify and process the requested user input operations.
   * Precondition: User requested operation must be valid: must either be pick or put or end.  
   * Postcondition: Performs the requested operations & display the newly updated bookshelfkeeper.    
   * @param Scanner object 'in' to receive input from the console.
   * @param BookshelfKeeper object 'bookshelfkeeper', is the object upon which the requested operations are undertaken.
   * @return none.
   */   
   private static void userOperations(Scanner in, BookshelfKeeper bookshelfKeeper){      
      
      String action;      
      
      while(true){         
      
         action = in.nextLine();         
         
         action = action.replaceAll("\\s", "");    
         
         String string1 = action.replaceAll("[^A-Za-z]", "");
         String string2 = action.replaceAll("[^\\d-]+", "");
         
         String operation = string1; 
         
         if(operation.equals(END)){
         
            return;
         }      
                  
         int bookHeight = Integer.parseInt(string2); 
         
         if(operation.equals(END) || !(isValidOperation(operation))){
         
            return;
         }             
         
         if(operation.equals(PUT)){            
         
            if(!isValidHeight(bookHeight)){
               return;
            }  
            
            bookshelfKeeper.putHeight(bookHeight);                                        
         }  
         
         else if(operation.equals(PICK)){            
            
            if(!isValidPick(bookHeight, bookshelfKeeper)){
                    return;
            }
            
            bookshelfKeeper.pickPos(bookHeight);  
         }  
         
         System.out.println(bookshelfKeeper.toString());
      }
   }
     
  
   /**
   * Helper method to check whether the user command input is valid or not. Valid user inputs are: put, pick, and end.  
   * Precondition: User requested operation must be valid: must either be pick or put or end. 
   * Postcondition: returns true if operation is valid, else false. 
   * @param string 'operation' is the user requested operation. 
   * @return boolean - true if operation is valid, else false. 
   */
   private static boolean isValidOperation(String operation){      
      
      if(!(operation.equals(PUT)) && !(operation.equals(PICK)) && !(operation.equals(END))) {                  
         
         System.out.println("ERROR: Invalid command. Valid commands are pick, put, or end.");         
         
         return false;      
      }
      
      return true;
   }
      
   /**
   * Helper method to check whether the user entered a book with a valid height or not. Valid height of a book is required to be greater than zero (height > 0).
   * Precondition: height of the book must be greater than 0. 
   * Postcondition: returns true if height of the book is greater than 0, else false.
   * @param integer 'height' is the height of the book entered by the user.
   * @return boolean - true if height of the book is valid, else false. 
   */
   private static boolean isValidHeight(int height){      
      
      if(height <= 0){        
         
         System.out.println("ERROR: Height of a book must be positive.");                      
         
         return false;      
      }
      
      return true;
   }        

   /**
   * Helper method to check whether the user has requested for a valid pick or not. Valid pick inputs are within the bounds of the bookshelf.  
   * Precondition: BookshelfKeeper size must be greater than 0. 
   * Postcondition: returns true if operation is valid, else false.
   * @param integer 'position' is the user requested 'pick position' on the bookshelf.
   * @param BookshelfKeeper object 'bookshelfKeeper' is the object which requires to be checked for its pick validity.
   * @return boolean - true if operation is valid, else false. 
   */   
   private static boolean isValidPick(int position, BookshelfKeeper bookshelfKeeper){  
      
      if(position < 0 || (position >= bookshelfKeeper.getNumBooks())){             
         
         System.out.println("ERROR: Entered pick operation is invalid on this shelf.");
         
         return false;      
      }
      
      return true;
   }

                 
   
}
