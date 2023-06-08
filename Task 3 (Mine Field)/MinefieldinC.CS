using System;
using System.Collections.Generic;

public class MinefieldGenerator
{
    public static void Main(string[] args)
    {
        // Set the size of the minefield
        int rows = 5;
        int columns = 5;

        // Generate the minefield
        int[,] minefield = GenerateMinefield(rows, columns);

        // Print out the minefield to the console
        PrintMinefield(minefield);

        // Instantiate a path finder with the generated minefield
        MinefieldPathFinder pathFinder = new MinefieldPathFinder(minefield);

        // Find a safe path through the minefield for Totoshka
        List<int[]> pathTotoshka = pathFinder.FindPath();
        if (pathTotoshka != null)
        {
            Console.WriteLine("Started before Ally");
            for (int i = 0; i < pathTotoshka.Count; i++)
            {
                int[] positionTotoshka = pathTotoshka[i];
                Console.Write($"Totoshka: Row: {positionTotoshka[0]}, Column: {positionTotoshka[1]}");

                if (i > 0)
                {
                    int[] positionAlly = pathTotoshka[i - 1];
                    Console.WriteLine($" ... Ally: Row: {positionAlly[0]}, Column: {positionAlly[1]}");
                }
                else
                {
                    Console.WriteLine(" ... Ally: Not started yet");
                }
            }
            Console.WriteLine($"Totoshka: Finished ... Ally: Row: {pathTotoshka[pathTotoshka.Count - 1][0]}," +
                              $" Column: {pathTotoshka[pathTotoshka.Count - 1][1]}");
        }
        else
        {
            Console.WriteLine("No safe path found for Totoshka.");
            Console.WriteLine("No safe path found for Ally.");
        }
    }

    public static int[,] GenerateMinefield(int rows, int columns)
    {
        int[,] minefield = new int[rows, columns];
        Random random = new Random();

        // For each row, determine the number of safe spots and their locations
        for (int row = 0; row < rows; row++)
        {
            int numSafeSpots = random.Next(columns) + 1;
            int[] safeColumns = new int[numSafeSpots];

            // Create safe spots, ensuring each is adjacent to at least one safe spot from the previous row
            for (int i = 0; i < numSafeSpots; i++)
            {
                int safeColumn;
                do
                {
                    safeColumn = random.Next(columns);
                } while (!IsValidSafeSpot(row, safeColumn, safeColumns, minefield));
                minefield[row, safeColumn] = 1;
                safeColumns[i] = safeColumn;
            }
        }

        // For each spot that isn't a safe spot, place a bomb
        for (int row = 0; row < rows; row++)
        {
            for (int col = 0; col < columns; col++)
            {
                if (minefield[row, col] != 1)
                {
                    minefield[row, col] = 0;
                }
            }
        }

        return minefield;
    }

    // Check if the spot is valid as a safe spot.
    public static bool IsValidSafeSpot(int row, int col, int[] safeColumns, int[,] minefield)
    {
        if (row == 0)
        {
            return true; // First row doesn't need to check connectivity
        }

        for (int i = 0; i < safeColumns.Length; i++)
        {
            int prevRow = row - 1;
            int prevCol = safeColumns[i];

            if (IsAdjacent(prevRow, prevCol, row, col))
            {
                return true;
            }
        }

        return false;
    }

    // Check if two spots are adjacent.
    public static bool IsAdjacent(int row1, int col1, int row2, int col2)
    {
        return Math.Abs(row1 - row2) <= 1 && Math.Abs(col1 - col2) <= 1;
    }

    // Print the minefield to the console.
    public static void PrintMinefield(int[,] minefield)
    {
        for (int row = 0; row < minefield.GetLength(0); row++)
        {
            for (int col = 0; col < minefield.GetLength(1); col++)
            {
                Console.Write($"{minefield[row, col]} ");
            }
            Console.WriteLine();
        }
    }
}

public class MinefieldPathFinder
{
    private int[,] minefield;  // 2D array representing the minefield
    private int rows;           // Number of rows in the minefield
    private int columns;        // Number of columns in the minefield

    // Constructor to initialize the minefield and its dimensions
    public MinefieldPathFinder(int[,] minefield)
    {
        this.minefield = minefield;
        this.rows = minefield.GetLength(0);
        this.columns = minefield.GetLength(1);
    }

    // Public method to find a safe path through the minefield
    public List<int[]> FindPath()
    {
        List<int[]> path = new List<int[]>();
        int[] currentPosition = FindStart();  // Find the starting position

        // If there's no valid start, return null (no safe path)
        if (currentPosition == null)
        {
            return null;
        }
        path.Add(currentPosition);  // Add the starting position to the path

        // Continue finding next safe positions until reaching the final row
        while (currentPosition[0] < rows - 1)
        {
            int[] nextPosition = FindNext(currentPosition);

            // If there's no valid next position, return null (no safe path)
            if (nextPosition == null)
            {
                return null;
            }
            path.Add(nextPosition);  // Add the next position to the path
            currentPosition = nextPosition;  // Update current position
        }

        return path;  // Return the found safe path
    }

    // Private helper method to find a safe starting position in the first row
    private int[] FindStart()
    {
        for (int i = 0; i < columns; i++)
        {
            // If a safe spot (1) is found, return its coordinates
            if (minefield[0, i] == 1)
            {
                return new int[] { 0, i };
            }
        }
        // If no safe spot found in the first row, return null
        return null;
    }

    // Private helper method to find a safe next position from the current one
    private int[] FindNext(int[] currentPosition)
    {
        int row = currentPosition[0];
        int col = currentPosition[1];

        // Check all possible adjacent spots in the next row
        for (int j = Math.Max(0, col - 1); j <= Math.Min(columns - 1, col + 1); j++)
        {
            // If a safe spot (1) is found, return its coordinates
            if (minefield[row + 1, j] == 1)
            {
                return new int[] { row + 1, j };
            }
        }
        // If no safe spot found, return null
        return null;
    }
}
