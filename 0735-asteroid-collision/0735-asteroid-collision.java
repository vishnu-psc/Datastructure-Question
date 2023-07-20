class Solution 
{
    public int[] asteroidCollision(int[] asteroids) 
    {
        if(asteroids.length <= 1) return asteroids;
        
        Stack<Integer> st = new Stack<>();
        
        for(int stone: asteroids)
        {
            if(stone > 0) st.push(stone);
            else
            {
                while(!st.isEmpty() && st.peek() > 0 && Math.abs(stone) > st.peek())
                    st.pop();
                if(st.isEmpty() || st.peek() < 0) st.push(stone);
                else if(st.peek() == Math.abs(stone)) st.pop();
            }
        }
        
        int[] ans = new int[st.size()]; 
        
        int i = 0;
        for(int e: st)
            ans[i++] = e;
        
        return ans;
    }
}