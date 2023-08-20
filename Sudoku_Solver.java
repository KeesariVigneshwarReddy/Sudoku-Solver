import java.util.*;
public class Sudoku 
{
    public static boolean Impute(int[][] matrix, int r, int c, int digit)
    {
        // check row
        for (int j = 0; j < matrix[0].length; j++)
        {
            if (matrix[r][j] == digit)
            {
                return false;
            }
        }
        // check column
        for (int i = 0; i < matrix.length; i++)
        {
            if (matrix[i][c] == digit)
            {
                return false;
            }
        }
        // check grid
        int sr = (r / 3) * 3, sc = (c / 3) * 3;
        for (int i = sr; i < sr + 3; i++)
        {
            for (int j = sc; j < sc + 3; j++)
            {
                if (matrix[i][j] == digit)
                {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean Solve(int[][] matrix, int r, int c)
    {
        // base case
        if (r == matrix.length)
        {
            return true;
        }
        int nextr = r;
        int nextc = c + 1;
        if (c + 1 == 9)
        {
            nextr = r + 1;
            nextc = 0;
        }
        // Kaam + recursion
        if (matrix[r][c] != 0)
        {
            return Solve(matrix, nextr, nextc);
        }
        for (int digit = 1; digit <= 9; digit++)
        {
            if (Impute(matrix, r, c, digit))
            {
                matrix[r][c] = digit;
                if (Solve(matrix, nextr, nextc))
                {
                    return true;
                }
                else
                {
                    matrix[r][c] = 0;
                }
            }
        }
        return false;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int[][] matrix = new int[9][9];
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[0].length; j++)
            {
                matrix[i][j] = sc.nextInt();
            }
        }
        if (Solve(matrix, 0, 0))
        {
            System.out.println("Solution exists");
            for (int i = 0; i < matrix.length; i++)
            {
                for (int j = 0; j < matrix[0].length; j++)
                {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
        else
        {
            System.out.println("Solution do not exists");
        }
    }    
}
