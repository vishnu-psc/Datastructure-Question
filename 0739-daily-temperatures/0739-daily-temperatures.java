class Solution 
{
    public int[] dailyTemperatures(int[] T) 
    {
        int[] result = new int[T.length];
        for (int day = T.length - 1; day >= 0; day--)
            for (int i = day - 1; i >= 0 && T[i] < T[day]; i--)  
                result[i] = day - i;
        return result;
    }
}