import java.util.List;
import java.util.Random;

public class MinefieldGenerator {
    public static void main(String[] args) {
        // Set the size of the minefield
        int rows = 6;
        int columns = 10;

        // Generate the minefield
        int[][] minefield = generateMinefield(rows, columns);

        // Print out the minefield to the console
        printMinefield(minefield);

        // Instantiate a path finder with the generated minefield
        MinefieldPathFinder pathFinder = new MinefieldPathFinder(minefield);

        // Find a safe path through the minefield for Totoshka
        List<int[]> pathTotoshka = pathFinder.findPath();
        if (pathTotoshka != null) {
            System.out.println("Started before Ally");
            for (int i = 0; i < pathTotoshka.size(); i++) {
                int[] positionTotoshka = pathTotoshka.get(i);
                System.out.print("Totoshka: Row: " + positionTotoshka[0] + ", Column: " + positionTotoshka[1]);

                if (i > 0) {
                    int[] positionAlly = pathTotoshka.get(i - 1);
                    System.out.println(" ... Ally: Row: " + positionAlly[0] + ", Column: " + positionAlly[1]);
                } else {
                    System.out.println(" ... Ally: Not started yet");
                }
            }
            System.out.println("Totoshka: Finished ... Ally: Row: " + pathTotoshka.get(pathTotoshka.size() - 1)[0] 
                               + ", Column: " + pathTotoshka.get(pathTotoshka.size() - 1)[1]);
        } else {
            System.out.println("No safe path found for Totoshka.");
            System.out.println("No safe path found for Ally.");
        }
    }

    public static int[][] generateMinefield(int rows, int columns) 
    {
        int[][] minefield = new int[rows][columns];
        Random random = new Random();

        int[] safeColumnsPrevRow = null ;
        int[] safeColumnsThisRow;

        // For each row, determine the number of safe spots and their locations
        for (int row = 0; row < rows; row++) 
        {
            //create random number for each row to insert the safe spot, if 3, then that row have 3 safe spot
            int numSafeSpots = random.nextInt(columns) + 1;

            //to store the value of safe spot in this row
            safeColumnsThisRow = new int[numSafeSpots];

            // Create safe spots, ensuring each is adjacent to at least one safe spot from the previous row
            for (int i = 0; i < numSafeSpots; i++) 
            {
                int colToPlaceSafeSpot;

                do {
                    //create random int 
                    colToPlaceSafeSpot = random.nextInt(columns);

                } while (!isValidSafeSpot(row, colToPlaceSafeSpot, safeColumnsPrevRow));

                //insert safe spot value to the particular row and column that safe
                minefield[row][colToPlaceSafeSpot] = 1;

                //store inside the safe columns total
                safeColumnsThisRow[i] = colToPlaceSafeSpot;

                //repeat until all rows have their own safe spot(s)
            }

            //pass it to the previous row 
            safeColumnsPrevRow = safeColumnsThisRow;
        }

        // For each spot that isn't a safe spot, place a bomb
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if (minefield[row][col] != 1) {
                    minefield[row][col] = 0;
                }
            }
        }

        return minefield;
    }

    // Check if the spot is valid as a safe spot. A spot is valid if it's adjacent to at least one safe spot from the previous row.
    public static boolean isValidSafeSpot(int row, int col, int[] safeColumnsIndex) {
       
        if (row == 0) {
            return true; // First row doesn't need to check connectivity
        }

        //safeColumns total, example if 3 safeColumns random generated, then only 3 safe spot can be input
        for (int i = 0; i < safeColumnsIndex.length; i++) 
        {
            int prevRow = row - 1; //is current row of that minefield
            int prevCol = safeColumnsIndex[i]; //initialized by getting safeColumns 
            
            if (isAdjacent(prevRow, prevCol, row, col)) {
                return true;
            }
        }

        return false;
    }

    // Check if two spots are adjacent. Two spots are adjacent if they are at most one row and one column apart.
    public static boolean isAdjacent(int row1, int col1, int row2, int col2) 
    {
        //return true if value either 0 or 1
        return Math.abs(row1 - row2) <= 1 && Math.abs(col1 - col2) <= 1;
    }

    // Print the minefield to the console. Safe spots are represented by '1', bomb spots by '0'.
    public static void printMinefield(int[][] minefield) {
        for (int row = 0; row < minefield.length; row++) {
            for (int col = 0; col < minefield[row].length; col++) {
                System.out.print(minefield[row][col] + " ");
            }
            System.out.println();
        }
    }
}
