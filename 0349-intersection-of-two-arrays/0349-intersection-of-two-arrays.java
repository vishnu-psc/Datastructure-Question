class Solution 
{
    public int[] intersection(int[] nums1, int[] nums2) 
    {
        int[] freq = new int[1001];
        for(int i: nums1) freq[i] = 1;
        
        int resSize = 0;
        
        for(int i: nums2)
        {
            if(freq[i] == 1)
            {
                freq[i] = 2;
                resSize++;
            }
        }
        
        int[] res = new int[resSize];
        int i = 0;
        for(int j: nums1)
        {
            if(freq[j] == 2)
            {
                res[i++] = j;
                freq[j] = 1;
            }
        }
        return res;
    }
}