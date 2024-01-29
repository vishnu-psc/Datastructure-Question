class Solution 
{
    public int maximumLength(int[] nums) 
    {
        int n = nums.length;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++)
        {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        Arrays.sort(nums);
        System.out.println(map);
        for(int i = 0; i < n; i++)
        {
            int ele = nums[i];
            int count = 0;
            while(map.containsKey(ele) && map.get(ele) > 0)
            {
                if(ele == 1) count += map.get(1);
                else if(map.get(ele) >= 2) count += 2;
                else if(map.get(ele) == 1)
                {
                    count += 1;
                    break;
                }
                map.put(ele, 0);
                if(ele > 100000) break; 
                ele = ele*ele;
            }
            ans = Math.max(ans, count - (count%2 == 0 ? 1:0));
        }
        return ans;
    }
}