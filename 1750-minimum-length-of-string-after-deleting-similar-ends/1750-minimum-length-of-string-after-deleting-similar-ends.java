class Solution 
{
    public int minimumLength(String s) 
    {
        int n = s.length();
        char[] arr = s.toCharArray();
        int l = 0, r = n - 1;
        
        while(l < r)
        {
            if(arr[l] == arr[r])
            {
                char a = arr[l];
                while(l <= r && arr[l] == a) l++;
                while(l <= r && arr[r] == a) r--;
            }
            else break;
        }
        System.out.println(l + " " + r);
        return r-l+1;  
    }
}