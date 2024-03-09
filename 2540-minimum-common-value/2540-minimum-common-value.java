class Solution 
{
    public int getCommon(int[] nums1, int[] nums2) 
    {
        int n = nums1.length;
        int m = nums2.length;
        
        int i = 0, j = 0;
        int res = 0;
        while(i < n && j < m)
        {
            if(nums1[i] == nums2[j])
            {
                res = nums1[i];
                break;
            }
            else if(nums1[i] > nums2[j]) j++;
            else i++;
        }
        i = 0; j = 0;
        while(i < n && j < m)
        {
            if(nums2[j] == nums1[i])
            {
                res = nums2[j];
                break;
            }
            else if(nums2[j] > nums1[i]) i++;
            else j++;
        }
        
        return res != 0? res:-1;
    }
}