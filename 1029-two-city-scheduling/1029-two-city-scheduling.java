class Solution 
{
    public int twoCitySchedCost(int[][] costs) 
    {
        int n = costs.length;
        int total = 0;
        int[] diff = new int[n];
        for(int i = 0; i < n; i++)
        {
            total += costs[i][0];
            diff[i] = costs[i][1] - costs[i][0];
        }
        Arrays.sort(diff);
        for(int i = 0; i < n/2; i++)
        {
            total += diff[i];
        }
        return total;
    }
}