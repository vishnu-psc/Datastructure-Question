class Solution 
{
    public int furthestBuilding(int[] heights, int bricks, int ladders) 
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int i = 0, n = heights.length;
        for(; i < n-1; i++)
        {
            if(heights[i+1] <= heights[i]) continue;
            
            int diff = heights[i+1] - heights[i];
            
            if(bricks >= diff)
            {
                bricks -= diff;
                pq.add(diff);
            }
            else if(ladders > 0)
            {
                if(!pq.isEmpty())
                {
                    int max_bricks_past = pq.peek();
                    if(max_bricks_past > diff)
                    {
                        bricks += max_bricks_past;
                        pq.poll();
                        bricks -= diff;
                        pq.add(diff);
                    }   
                }
                ladders--;
            }
            else break;
        
        }
        return i;
        
    }
}