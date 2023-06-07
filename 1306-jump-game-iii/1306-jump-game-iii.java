class Solution 
{
    public boolean canReach(int[] arr, int start) 
    {
        return dfs(arr, start);
    }
    
    private boolean dfs(int[] arr, int i)
    {
        if(i >= 0 && i < arr.length && arr[i] >= 0)
        {
            if(arr[i] == 0)
                return true;
            arr[i] = -arr[i];
            return (dfs(arr, i+arr[i]) || dfs(arr, i-arr[i]));
        }
        return false;
    }
}