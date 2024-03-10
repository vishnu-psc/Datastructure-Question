class Solution 
{
    public int[] intersection(int[] nums1, int[] nums2) 
    {
        Set<Integer> s = new HashSet<>();
        int n = nums1.length;
        int m = nums2.length;
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i = 0, j = 0; 
        while(i < n && j < m)
        {
            if(nums1[i] == nums2[j])
            {
                s.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i] < nums2[j]) i++;
            else j++;
        }
        
        i= 0;
        int[] ans = new int[s.size()];
        for(int k: s)
        {
            ans[i++] = k; 
        }
        return ans;
    }
}