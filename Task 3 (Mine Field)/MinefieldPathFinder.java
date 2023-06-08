import java.util.ArrayList;
import java.util.List;

public class MinefieldPathFinder {
    private int[][] minefield;  // 2D array representing the minefield
    private int rows;           // Number of rows in the minefield
    private int columns;        // Number of columns in the minefield

    // Constructor to initialize the minefield and its dimensions
    public MinefieldPathFinder(int[][] minefield) {
        this.minefield = minefield;
        this.rows = minefield.length;
        this.columns = minefield[0].length;
    }

    // Public method to find a safe path through the minefield
    public List<int[]> findPath() {
        List<int[]> path = new ArrayList<>();
        int[] currentPosition = findStart();  // Find the starting position

        // If there's no valid start, return null (no safe path)
        if (currentPosition == null) {
            return null;
        }
        path.add(currentPosition);  // Add the starting position to the path

        // Continue finding next safe positions until reaching the final row
        while (currentPosition[0] < rows - 1) {
            int[] nextPosition = findNext(currentPosition);
            
            // If there's no valid next position, return null (no safe path)
            if (nextPosition == null) {
                return null;
            }
            path.add(nextPosition);  // Add the next position to the path
            currentPosition = nextPosition;  // Update current position
        }

        return path;  // Return the found safe path
    }

    // Private helper method to find a safe starting position in the first row
    private int[] findStart() {
        for (int i = 0; i < columns; i++) {
            // If a safe spot (1) is found, return its coordinates
            if (minefield[0][i] == 1) {
                return new int[]{0, i};
            }
        }
        // If no safe spot found in the first row, return null
        return null;
    }

    // Private helper method to find a safe next position from the current one
    private int[] findNext(int[] currentPosition) {
        int row = currentPosition[0];
        int col = currentPosition[1];

        // Check all possible adjacent spots in the next row
        for (int j = Math.max(0, col - 1); j <= Math.min(columns - 1, col + 1); j++) {
            // If a safe spot (1) is found, return its coordinates
            if (minefield[row + 1][j] == 1) {
                return new int[]{row + 1, j};
            }
        }
        // If no safe spot found, return null
        return null;
    }
}
