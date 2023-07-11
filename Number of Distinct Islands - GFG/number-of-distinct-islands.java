//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution 
{
    public static void dfs(int row, int col, int[][] grid, int[][] vis, ArrayList<String> island, int brow, int bcol)
    {
        vis[row][col] = 1;
        island.add(toString(row - brow, col - bcol));
        int n = grid.length;
        int m = grid[0].length;
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, -1, 0, 1};
        
        for(int i = 0; i < 4; i++)
        {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1)
                dfs(nrow, ncol, grid, vis, island, brow, bcol);
        }
    }
    
    private static String toString(int a, int b)
    {
        return Integer.toString(a) + " " + Integer.toString(b);
    }

    int countDistinctIslands(int[][] grid) 
    {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        
        HashSet<ArrayList<String>> set = new HashSet<>();
        for(int i = 0; i < n; i ++)
        {
            for(int j = 0; j < m; j++)
            {
                if(vis[i][j] == 0 && grid[i][j] == 1)
                {
                    ArrayList<String> island = new ArrayList<>();
                    dfs(i, j, grid, vis, island, i, j);
                    set.add(island);
                }
            }
        }
        return set.size();
    }
}
