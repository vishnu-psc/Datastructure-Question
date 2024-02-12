class Solution 
{
    public int majorityElement(int[] arr) 
    {
        int n = arr.length;
        int count = 0,ele=0;
        for(int i = 0; i < n; i++)
        {
            if(count == 0) 
            {
                ele = arr[i];
                //idx = i;
            }
            if(ele == arr[i])count++;
            else count--;
        }
        return ele;
        
    }
}