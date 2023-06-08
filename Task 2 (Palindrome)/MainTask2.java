import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MainTask2 {
    public static void main(String[] args)
    {
        //main function
        Scanner sc = new Scanner(System.in);

        //ask the user to enter input
        System.out.print("\nEnter the input string : ");
        String inputString = sc.next();

        char[] trashSymbols = trashSymbol(inputString);

        // Print out the trash symbols
        System.out.print("Trash Symbols: ");

        for (int i = 0; i < trashSymbols.length; i++) {
            // Get the trash symbol at the current index.
            char trashSymbol = trashSymbols[i];
            
            // Print the trash symbol followed by a space.
            System.out.print(trashSymbol);
            System.out.print(" ");
        }

        //show the result
        if(isPalindrome(inputString, trashSymbols))
        {
            System.out.print("\nThe input string is Palindrome !");
        }
        else
        {
            System.out.print("\nThe input string is not Palindrome !");
        }
        
    }


    //trash symbol function
    public static char[] trashSymbol(String inputString)
    {
        // This line declares a Set of Characters. This Set will be used to store the "trash symbols"
        Set<Character> trashSymbolsSet = new HashSet<>();   

        // This loop will iterate through each character of the input string.
        char[] characters = inputString.toCharArray();
        for (int index = 0; index < characters.length; index++) 
        {
            char currentCharacter = characters[index];

            // If the current character is neither a letter nor a digit, it is a trash symbol
            boolean isCurrentCharacterLetterOrDigit = Character.isLetterOrDigit(currentCharacter);

            // then add it to our Set of trash symbols.
            if (isCurrentCharacterLetterOrDigit == false) {
                trashSymbolsSet.add(currentCharacter);
            }
        }

        // Now that we've collected all the unique trash symbols, let's put them into a char array.

        // First, we create an empty char array with the same size as our Set of trash symbols.
        int numberOfUniqueTrashSymbols = trashSymbolsSet.size();
        char[] trashSymbols = new char[numberOfUniqueTrashSymbols];

        // Next, we'll fill this array with the trash symbols from our Set.
        int arrayIndex = 0;
        for (char trashSymbol : trashSymbolsSet) {
            trashSymbols[arrayIndex] = trashSymbol;
            arrayIndex++;
        }

        // Now, trashSymbols is a char array that contains all the unique trash symbols from the input string.
        // We return this array.
        return trashSymbols;
    }

    public static boolean isPalindrome(String inputString, char[] trashSymbols) {
        // Initialize two pointers to point to the start (leftPointer) and end (rightPointer) of the string.
        int leftPointer = 0;
        int rightPointer = inputString.length() - 1;
    
        // Convert the array of trash symbols to a String for easier searching
        String trashSymbolsString = new String(trashSymbols);
    
        // Start a loop that will continue until the two pointers meet in the middle of the string.
        while (leftPointer < rightPointer) {

            // Skip over any trash symbols from the start of the string
            // If we find a trash symbol, move the left pointer one step to the right and continue the loop
            while (trashSymbolsString.indexOf(inputString.charAt(leftPointer)) != -1) {
                
                //check next value from left, 
                leftPointer++;
    
                // If the left pointer has reached or crossed the right pointer, exit the loop.
                if (leftPointer >= rightPointer) {
                    break;
                }
            }
    
            // Skip over any trash symbols from the end of the string
            // If we find a trash symbol, move the right pointer one step to the left and continue the loop
            while (trashSymbolsString.indexOf(inputString.charAt(rightPointer)) != -1) {
                
                //check next value from right,
                rightPointer--;
    
                // If the right pointer has reached or crossed the left pointer, exit the loop.
                if (rightPointer <= leftPointer) {
                    break;
                }
            }
    
            // After skipping all trash symbols, if the left pointer is still to the left of the right pointer,
            // compare the characters at the left and right pointers (ignoring case)
            if (leftPointer < rightPointer) {
                if (Character.toLowerCase(inputString.charAt(leftPointer)) != Character.toLowerCase(inputString.charAt(rightPointer))) {
                    // If the characters don't match, the string is not a palindrome, so return false
                    return false;
                }
    
                // Move the left pointer one step to the right and the right pointer one step to the left
                // This sets us up for the next round of comparison in the while loop
                leftPointer++;
                rightPointer--;
            }
        }
    
        // If we made it through the entire string without finding mismatched characters, the string is a palindrome,
        // so return true
        return true;
    }
    

        
}
