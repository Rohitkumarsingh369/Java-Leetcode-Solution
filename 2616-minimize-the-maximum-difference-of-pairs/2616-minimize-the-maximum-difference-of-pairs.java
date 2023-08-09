class Solution 
{
    public int minimizeMax(int[] a, int p) 
    {
        if (p == 0)
            return 0;
        int n = a.length;
        Arrays.sort(a);
        int l = 0;
        int r = 1000000000;
        int ans = -1;
        while (l <= r) 
        {
            int mid = (l + r) / 2;
            int count = 0;
            int j = 0;
            while (j + 1 < n) 
            {
                if (a[j + 1] - a[j] > mid) 
                {
                    j += 1;
                    continue;
                }
                count += 1;
                j += 2;
            }
            if (count >= p) 
            {
                ans = mid;
                r = mid - 1;
            } 
            else
                l = mid + 1;
        }
        return ans;
    }
}