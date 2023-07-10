//{ Driver Code Starts
// Initial Template for Java

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
            int ans = ob.numberOfEnclaves(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Pair
{
    int x;
    int y;
    public Pair(int row, int col)
    {
        x = row;
        y = col;
    }
}

class Solution 
{
    int numberOfEnclaves(int[][] grid) 
    {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        
        int[] delrow = {-1, 0, +1, 0};
        int[] delcol = {0, +1, 0, -1};
    
        Queue<Pair> q = new LinkedList<>();
        
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(i == 0 || j == 0 || i == n-1 || j == m-1)
                {
                    if(grid[i][j] == 1)
                    {
                        q.add(new Pair(i, j));
                        vis[i][j] = 1;
                    }
                }
            }
        }  
        
        while(!q.isEmpty())
        {
            int row = q.peek().x;
            int col = q.peek().y;
            q.remove();
            
            for(int i = 0; i < 4; i++)
            {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1)
                {
                    q.add(new Pair(nrow, ncol));
                    vis[nrow][ncol] = 1;
                }
            }
        }
        
        int c = 0;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(grid[i][j] == 1 && vis[i][j] == 0) c++;
            }
        }
        return c;
    }
}


