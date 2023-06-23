class Solution 
{
    public int orangesRotting(int[][] grid) 
    {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        int countFresh = 0;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0 ; j < m; j++)
            {
                if(grid[i][j] == 2)
                {
                    q.add(new Pair(i , j, 0));
                    vis[i][j] = 2;
                }
                else
                {
                    vis[i][j] = 0;
                }
                
                if(grid[i][j] == 1) countFresh++;
            }
        }
        
        int tm = 0, count = 0;
        int[] drow = {-1, 0, +1, 0};
        int[] dcol = {0, +1, 0, -1};
        while(!q.isEmpty())
        {
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().time;
            tm = Math.max(tm ,t);
            q.remove();
            
            for(int i = 0; i < 4; i++)
            {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if(nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && vis[nrow][ncol] != 2 && grid[nrow][ncol] == 1)
                {
                    q.add(new Pair(nrow, ncol, t+1));
                    vis[nrow][ncol] = 2;
                    count++;
                }
            }
            
        }
        return (count != countFresh) ? -1: tm;
    }
}

class Pair
{   
    int row;
    int col;
    int time;
    Pair(int r, int c, int t)
    {
        row = r;
        col = c;
        time = t;
    }
}