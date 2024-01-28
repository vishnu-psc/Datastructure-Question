class Solution 
{
    public int numSubmatrixSumTarget(int[][] matrix, int target) 
    {
        int n = matrix.length;
        int m = matrix[0].length;
        
        for(int i = 0 ; i < n; i++)
        {
            for(int j = 1; j < m; j++)
            {
                matrix[i][j] += matrix[i][j-1];
            }
        }
        int count = 0;
        
        for(int startCol = 0 ; startCol < m; startCol++)
        {
            for(int j = startCol; j < m; j++)
            {
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                int cumSum = 0;
                for(int row = 0; row < n; row++)
                {
                    cumSum += matrix[row][j]-(startCol>0 ? matrix[row][startCol-1] : 0);
                    if(map.containsKey(cumSum-target))
                    {
                        count += map.get(cumSum-target);
                    }
                    map.put(cumSum, map.getOrDefault(cumSum, 0) + 1);
                }
            }
        }
        
        return count;
    }
}