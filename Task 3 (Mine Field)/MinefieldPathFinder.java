import java.util.ArrayList;
import java.util.List;

public class MinefieldPathFinder {
    
    private int[][] minefield;  // 2D array representing the minefield
    private int rows;           // Number of rows in the minefield
    private int columns;        // Number of columns in the minefield

    // Constructor: Initializes the minefield and its dimensions
    public MinefieldPathFinder(int[][] minefield) {
        this.minefield = minefield;
        this.rows = minefield.length;
        this.columns = minefield[0].length;
    }

    // Main method to find a safe path through the minefield
    public List<int[]> findPath() {
        // Loop through each spot in the first row
        for (int i = 0; i < columns; i++) {
            // Check if the current spot is safe (contains 1)
            if (minefield[0][i] == 1) {
                // Try finding a path starting from this spot
                List<int[]> path = findPathFromStart(new int[]{0, i});
                // If a complete path is found, return it
                if (path != null) {
                    return path;
                }
            }
        }
        // If no safe path is found after trying all starting spots, return null
        return null;
    }

    // This method tries to find a safe path starting from a given spot
    private List<int[]> findPathFromStart(int[] startPosition) {
        List<int[]> path = new ArrayList<>();
        int[] currentPosition = startPosition;

        // Add the starting position to the path
        path.add(currentPosition);

        // Continue finding the next safe positions until the final row is reached
        while (currentPosition[0] < rows - 1) {
            int[] nextPosition = findNext(currentPosition);

            // If there's no valid next position, the path is incomplete; return null
            if (nextPosition == null) {
                return null;
            }
            // Add the next position to the path
            path.add(nextPosition);
            // Update the current position for the next iteration
            currentPosition = nextPosition;
        }

        // Return the found safe path from the given start position
        return path;
    }

    // This method finds the next safe spot adjacent to the current position
    private int[] findNext(int[] currentPosition) {
        int row = currentPosition[0];
        int col = currentPosition[1];

        // Loop through the spots in the next row that are adjacent to the current spot
        for (int j = Math.max(0, col - 1); j <= Math.min(columns - 1, col + 1); j++) {
            // If a safe spot is found, return its coordinates
            if (minefield[row + 1][j] == 1) {
                return new int[]{row + 1, j};
            }
        }
        // If no safe spot is found, return null
        return null;
    }
}


