class Solution {
    public int[][] divideArray(int[] nums, int k) 
    {
        int n = nums.length;
        int[][] ans = new int[n/3][3];
        
        Arrays.sort(nums);
        int c = 0;
        for(int i = 0; i < n/3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                ans[i][j] = nums[c++];
            }
            
            if(ans[i][2] - ans[i][0] > k) return new int[][]{};
        }
        
        return ans;
        
    }
}