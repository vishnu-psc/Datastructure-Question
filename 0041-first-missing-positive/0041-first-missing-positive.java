class Solution {
    public int firstMissingPositive(int[] nums) {
        //num is negative or greater than array length or if its at its correct position
        if(nums.length==0)return 1;
        for(int i=0;i<nums.length;){
            if(nums[i]<=0||nums[i]>nums.length){
                i++;
            }
            else if(nums[i]==nums[nums[i]-1]){
                i++;
            }
            else{
                //swap num[i] with value on index nums[i]-1
                int temp=nums[nums[i]-1];
                nums[nums[i]-1]=nums[i];
                nums[i]=temp;
                
            }
        }
        int i=0;
        for(i=0;i<nums.length;i++){
            if(nums[i]!=i+1)return i+1;
        }
        return nums[i-1]+1;
    }
}