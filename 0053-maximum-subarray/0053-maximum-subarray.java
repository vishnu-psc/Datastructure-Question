class Solution {
    public int maxSubArray(int[] nums) 
    {
        int n = nums.length;
        return maxSubArray(nums, 0, n-1);
    }
    
    private int maxSubArray(int[] nums, int low, int high)
    {
        if(low == high)
            return nums[low];
        int currSum = 0;
        int leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE;
        int mid = (low + high) >> 1;
        for(int i = mid; i >= low; i--)
        {
            currSum += nums[i];
            leftSum = Math.max(leftSum, currSum);
        }
        currSum = 0;
        for(int i = mid+1; i <= high; i++)
        {
            currSum += nums[i];
            rightSum = Math.max(rightSum, currSum);
        }
        int maxSum = leftSum + rightSum;
        int l = maxSubArray(nums, low, mid);
        int r = maxSubArray(nums, mid + 1, high);
        
        return Math.max(maxSum, Math.max(l,r));
    }
}